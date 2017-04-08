package com.example.roy1473.restaurantexample.Osakas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.roy1473.restaurantexample.DetailActivity;
import com.example.roy1473.restaurantexample.Models.GourmetData;
import com.example.roy1473.restaurantexample.Models.ServiceManager;
import com.example.roy1473.restaurantexample.Models.Shop;
import com.example.roy1473.restaurantexample.OsakaArea;
import com.example.roy1473.restaurantexamle.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.roy1473.restaurantexamle.R.id.listViewUmeda;

public class UmedaAreaActivity extends AppCompatActivity implements ListView.OnItemClickListener {
    public static final String TAG = "Restaurants";
    private ServiceManager rManager;
    private List<Shop> shops;
    private String umedaCode = "Y300";
    private String json = "json";
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umeda_area);
        listView = (ListView)findViewById(listViewUmeda);
        rManager = new ServiceManager();
        getGourmetData();
        listView.setOnItemClickListener(this);

    }


    private void getGourmetData(){


        final Call<GourmetData> requestData = rManager.getApiInterface().getGourmet("a2e960081c3ba832",
                umedaCode, json );

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
    public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
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
                        Intent intent = new Intent(UmedaAreaActivity.this, OsakaArea.class);
                        startActivity(intent);
                        return true;
                    }
                }
        );
        return true;
    }


}
