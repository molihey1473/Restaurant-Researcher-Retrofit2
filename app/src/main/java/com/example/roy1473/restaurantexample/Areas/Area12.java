package com.example.roy1473.restaurantexample.Areas;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.roy1473.restaurantexamle.R;
import com.example.roy1473.restaurantexample.DetailActivity;
import com.example.roy1473.restaurantexample.Models.GourmetData;
import com.example.roy1473.restaurantexample.Models.Shop;
import com.example.roy1473.restaurantexample.ServiceManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Area12 extends Fragment {

    private ServiceManager rManager;
    private ListView listView;
    private List<Shop> shopList;
    private List<Shop>shops;

    public Area12(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.activity_main_fragment, container, false);

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        listView = (ListView)view.findViewById(R.id.listViewFragment);
        rManager = new ServiceManager();
        getGourmetData();


    }

    private void getGourmetData(){
        String shinsaibashiCode = "Y355";
        String json = "json";
        final Call<GourmetData> requestData = rManager.getApiInterface().getGourmet("a2e960081c3ba832",
                shinsaibashiCode, json);

        requestData.enqueue(new Callback<GourmetData>() {
            @Override
            public void onResponse(Call<GourmetData> call, Response<GourmetData> response) {
                shopList = response.body().results.getShop();
                shops = shopList;

                showList();


            }

            @Override
            public void onFailure(Call<GourmetData> call, Throwable t) {
                Log.e("Restaurants","Error" + t.getMessage());
                Toast.makeText(getActivity().getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });


    }

    private void showList(){
        String[] items = new String[shops.size()];
        for (int i = 0; i < shops.size(); i++){
            items[i] = shops.get(i).getName();

        }
        ArrayAdapter adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                DetailActivity detailFragment = new DetailActivity();
                Shop shopInfo = shops.get(position);
                Bundle bundle = new Bundle();
                bundle.putString("title", shopInfo.getName());
                bundle.putString("address", shopInfo.getAddress());
                bundle.putString("catches", shopInfo.getCatch());
                bundle.putString("access", shopInfo.getAccess());
                bundle.putString("open", shopInfo.getOpen());
                bundle.putString("close", shopInfo.getClose());
                bundle.putString("wifi", shopInfo.getWifi());
                bundle.putString("private", shopInfo.getPrivateRoom());
                bundle.putString("card", shopInfo.getCard());
                bundle.putString("about", shopInfo.getOtherMemo());
                bundle.putString("budget", shopInfo.getBudget().getAverage());
                bundle.putString("photo", shopInfo.getPhoto().getMobile().getL());
                bundle.putString("url", shopInfo.getUrls().getMobile());

                detailFragment.setArguments(bundle);

                FragmentManager fragmentManager = getActivity().getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.activity_main, detailFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });



    }

}
