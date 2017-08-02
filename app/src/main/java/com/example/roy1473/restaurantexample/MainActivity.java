package com.example.roy1473.restaurantexample;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.roy1473.restaurantexamle.R;
import com.example.roy1473.restaurantexample.Areas.Area1;
import com.example.roy1473.restaurantexample.Areas.Area10;
import com.example.roy1473.restaurantexample.Areas.Area11;
import com.example.roy1473.restaurantexample.Areas.Area12;
import com.example.roy1473.restaurantexample.Areas.Area13;
import com.example.roy1473.restaurantexample.Areas.Area14;
import com.example.roy1473.restaurantexample.Areas.Area15;
import com.example.roy1473.restaurantexample.Areas.Area16;
import com.example.roy1473.restaurantexample.Areas.Area17;
import com.example.roy1473.restaurantexample.Areas.Area18;
import com.example.roy1473.restaurantexample.Areas.Area19;
import com.example.roy1473.restaurantexample.Areas.Area2;
import com.example.roy1473.restaurantexample.Areas.Area20;
import com.example.roy1473.restaurantexample.Areas.Area21;
import com.example.roy1473.restaurantexample.Areas.Area3;
import com.example.roy1473.restaurantexample.Areas.Area4;
import com.example.roy1473.restaurantexample.Areas.Area5;
import com.example.roy1473.restaurantexample.Areas.Area6;
import com.example.roy1473.restaurantexample.Areas.Area7;
import com.example.roy1473.restaurantexample.Areas.Area8;
import com.example.roy1473.restaurantexample.Areas.Area9;


public class MainActivity extends AppCompatActivity{
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerButton;
    private ListView drawerList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerList = (ListView)findViewById(R.id.drawer_ListView);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_Layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupNavigationDrawer();
        setNavigationDrawerList();

        MainFragment mainFragment = new MainFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.activity_main, mainFragment);
        transaction.commit();




    }


    private void setupNavigationDrawer(){

        drawerButton = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.drawer_open, R.string.drawer_close){

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);

            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }
        };

        drawerLayout.addDrawerListener(drawerButton);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerButton.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerButton.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (drawerButton.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }


    private void setNavigationDrawerList(){
        String[] osakaAreaList = new String[]{
                "梅田　エリア",
                "福島、野田 エリア",
                "淀屋橋・本町・北浜・天満橋　エリア",
                "京橋・天満・天六・南森町　エリア",
                "心斎橋・なんば・南船場・堀江　エリア",
                "天王寺　エリア",
                "上本町・鶴橋　エリア",
                "針中野･長居･西田辺･西成区･住吉　エリア",
                "関目・千林・緑橋・深江橋　エリア",
                "大阪市その他",
                "堺・高石市・和泉市　エリア",
                "高槻市　エリア",
                "茨木市　エリア",
                "泉大津･岸和田･泉佐野･りんくう　エリア",
                "松原市･藤井寺市･富田林･南河内　エリア",
                "江坂・西中島・新大阪・十三　エリア",
                "東大阪市・八尾市・平野・大東市　エリア",
                "九条･西九条･弁天町･大正･住之江　エリア",
                "枚方・寝屋川・守口・門真　エリア",
                "大阪府その他",
                "箕面・池田　エリア"
        };

        drawerList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                osakaAreaList));
        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                FragmentManager fragmentPosition = getFragmentManager();
                switch (position){
                    case 0:
                        Fragment area1 = new Area1();
                        FragmentTransaction transaction0 = fragmentPosition.beginTransaction();
                        transaction0.replace(R.id.activity_main, area1);
                        transaction0.commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 1:
                        Fragment area2 = new Area2();
                        FragmentTransaction transaction1 = fragmentPosition.beginTransaction();
                        transaction1.replace(R.id.activity_main, area2);
                        transaction1.commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 2:
                        Fragment area3 = new Area3();
                        FragmentTransaction transaction2 = fragmentPosition.beginTransaction();
                        transaction2.replace(R.id.activity_main, area3);
                        transaction2.commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 3:
                        Fragment area4 = new Area4();
                        FragmentTransaction transaction3 = fragmentPosition.beginTransaction();
                        transaction3.replace(R.id.activity_main, area4);
                        transaction3.commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 4:
                        Fragment area5 = new Area5();
                        FragmentTransaction transaction4 = fragmentPosition.beginTransaction();
                        transaction4.replace(R.id.activity_main, area5);
                        transaction4.commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 5:
                        Fragment area6 = new Area6();
                        FragmentTransaction transaction5 = fragmentPosition.beginTransaction();
                        transaction5.replace(R.id.activity_main, area6);
                        transaction5.commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 6:
                        Fragment area7 = new Area7();
                        FragmentTransaction transaction6 = fragmentPosition.beginTransaction();
                        transaction6.replace(R.id.activity_main, area7);
                        transaction6.commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 7:
                        Fragment area8 = new Area8();
                        FragmentTransaction transaction7 = fragmentPosition.beginTransaction();
                        transaction7.replace(R.id.activity_main, area8);
                        transaction7.commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 8:
                        Fragment area9 = new Area9();
                        FragmentTransaction transaction8 = fragmentPosition.beginTransaction();
                        transaction8.replace(R.id.activity_main, area9);
                        transaction8.commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 9:
                        Fragment area10 = new Area10();
                        FragmentTransaction transaction9 = fragmentPosition.beginTransaction();
                        transaction9.replace(R.id.activity_main, area10);
                        transaction9.commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 10:
                        Fragment area11 = new Area11();
                        FragmentTransaction transaction10 = fragmentPosition.beginTransaction();
                        transaction10.replace(R.id.activity_main, area11);
                        transaction10.commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 11:
                        Fragment area12 = new Area12();
                        FragmentTransaction transaction11 = fragmentPosition.beginTransaction();
                        transaction11.replace(R.id.activity_main, area12);
                        transaction11.commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 12:
                        Fragment area13 = new Area13();
                        FragmentTransaction transaction12 = fragmentPosition.beginTransaction();
                        transaction12.replace(R.id.activity_main, area13);
                        transaction12.commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 13:
                        Fragment area14 = new Area14();
                        FragmentTransaction transaction13 = fragmentPosition.beginTransaction();
                        transaction13.replace(R.id.activity_main, area14);
                        transaction13.commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 14:
                        Fragment area15 = new Area15();
                        FragmentTransaction transaction14 = fragmentPosition.beginTransaction();
                        transaction14.replace(R.id.activity_main, area15);
                        transaction14.commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 15:
                        Fragment area16 = new Area16();
                        FragmentTransaction transaction15 = fragmentPosition.beginTransaction();
                        transaction15.replace(R.id.activity_main, area16);
                        transaction15.commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 16:
                        Fragment area17 = new Area17();
                        FragmentTransaction transaction16 = fragmentPosition.beginTransaction();
                        transaction16.replace(R.id.activity_main, area17);
                        transaction16.commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 17:
                        Fragment area18 = new Area18();
                        FragmentTransaction transaction17 = fragmentPosition.beginTransaction();
                        transaction17.replace(R.id.activity_main, area18);
                        transaction17.commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 18:
                        Fragment area19 = new Area19();
                        FragmentTransaction transaction18 = fragmentPosition.beginTransaction();
                        transaction18.replace(R.id.activity_main, area19);
                        transaction18.commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 19:
                        Fragment area20 = new Area20();
                        FragmentTransaction transaction19 = fragmentPosition.beginTransaction();
                        transaction19.replace(R.id.activity_main, area20);
                        transaction19.commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 20:
                        Fragment area21 = new Area21();
                        FragmentTransaction transaction20 = fragmentPosition.beginTransaction();
                        transaction20.replace(R.id.activity_main, area21);
                        transaction20.commit();
                        drawerLayout.closeDrawers();
                        break;





                }



            }
        });

    }
}

