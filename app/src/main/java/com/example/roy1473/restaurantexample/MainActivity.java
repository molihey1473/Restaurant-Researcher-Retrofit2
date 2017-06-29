package com.example.roy1473.restaurantexample;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.roy1473.restaurantexamle.R;
import com.example.roy1473.restaurantexample.Models.GourmetData;
import com.example.roy1473.restaurantexample.Models.ServiceManager;
import com.example.roy1473.restaurantexample.Models.Shop;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {
    public static final String TAG = "Restaurants";
    private ServiceManager rManager;
    private List<Shop> shops;
    private String shinsaibashiCode = "Y315";
    private String json = "json";
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private ListView drawerList;
    private String[] areaList;
    private Toolbar toolbar;


    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);
        rManager = new ServiceManager();
        getGourmetData();
        listView.setOnItemClickListener(this);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_Layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerList = (ListView)findViewById(R.id.drawer_ListView) ;
        setSupportActionBar(toolbar);


        setupNavigationDrawer();
        setNavigationDrawerList();

    }


    private void setupNavigationDrawer(){

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.drawer_open, R.string.drawer_close){

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);

            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }
        };

        drawerLayout.addDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }


    private void setNavigationDrawerList(){
        areaList = new String[]{"梅田", "福島、野田", "淀屋橋・本町・北浜・天満橋",
                "京橋・天満・天六・南森町", "心斎橋・なんば・南船場・堀江", "天王寺", "上本町・鶴橋",
                "針中野･長居･西田辺･西成区･住吉", "関目・千林・緑橋・深江橋", "大阪市その他",
                "堺・高石市・和泉市", "高槻市", "茨木市", "泉大津･岸和田･泉佐野･りんくう",
                "松原市･藤井寺市･富田林･南河内", "江坂・西中島・新大阪・十三", "東大阪市・八尾市・平野・大東市",
                "九条･西九条･弁天町･大正･住之江", "枚方・寝屋川・守口・門真",
                "大阪府その他", "箕面・池田" };

        drawerList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                areaList));
        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

            }
        });

    }





    private void getGourmetData(){

          //final Call<?> requestData = rManager.getApiInterface().getGourmet("{yourToken or KeyId}",
        //{AreaCode}, {"json"} );
        final Call<GourmetData> requestData = rManager.getApiInterface().getGourmet("a2e960081c3ba832",
               shinsaibashiCode, json );

        requestData.enqueue(new Callback<GourmetData>() {
            @Override
            public void onResponse(Call<GourmetData> call, Response<GourmetData> response) {
                    List<Shop> shopList = response.body().results.getShop();








                shops = shopList;


                showList();


            }

            @Override
            public void onFailure(Call<GourmetData> call, Throwable t) {
                Log.e(TAG, "Error" + t.getMessage());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });


    }

    private void showList(){
        String[] items = new String[shops.size()];
        for (int i = 0; i < shops.size(); i++){
            items[i] = shops.get(i).getName();

        }
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);



    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, DetailActivity.class);
        Shop shopInfo = shops.get(position);
        intent.putExtra("title", shopInfo.getName());
        intent.putExtra("address", shopInfo.getAddress());
        intent.putExtra("catches", shopInfo.getCatch());
        intent.putExtra("access", shopInfo.getAccess());
        intent.putExtra("open", shopInfo.getOpen());
        intent.putExtra("close",shopInfo.getClose());
        intent.putExtra("wifi", shopInfo.getWifi());
        intent.putExtra("private", shopInfo.getPrivateRoom());
        intent.putExtra("card", shopInfo.getCard());
        intent.putExtra("about", shopInfo.getOtherMemo());
        intent.putExtra("budget", shopInfo.getBudget().getAverage());
        intent.putExtra("photo", shopInfo.getPhoto().getMobile().getL());
        intent.putExtra("url", shopInfo.getUrls().getMobile());




        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.findItem(R.id.city_menu_setting).setOnMenuItemClickListener(
                new MenuItem.OnMenuItemClickListener(){
                    @Override
                    public boolean onMenuItemClick(MenuItem item){
                        Intent intent = new Intent(MainActivity.this, OsakaArea.class);
                        startActivity(intent);
                        return true;
                    }
                }
        );
        return true;
    }

}

