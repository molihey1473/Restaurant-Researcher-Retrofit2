package com.example.roy1473.restaurantexample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends Fragment {
    public DetailActivity(){

    }

    TextView titles;
    ImageView photos;
    TextView address;
    TextView catches;
    TextView access;
    TextView open;
    TextView close;
    TextView wifi;
    TextView privateRoom;
    TextView card;
    TextView about;
    TextView url;
    TextView budget;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle args = getArguments();
        String selectedTitle = args.getString("title");
        String selectedAddress = args.getString("address");
        String selectedPhoto = args.getString("photo");
        String selectedCatches = args.getString("catches");
        String selectedAccess = args.getString("access");
        String selectedOpen = args.getString("open");
        String selectedClose = args.getString("close");
        String selectedWifi = args.getString("wifi");
        String selectedPrivate = args.getString("private");
        String selectedCard = args.getString("card");
        String selectedAbout = args.getString("about");
        String selectedUrl = args.getString("url");
        String selectedBudget = args.getString("budget");


        View view = inflater.inflate(R.layout.activity_detail, container, false);

        titles = (TextView)view.findViewById(R.id.title);
        photos = (ImageView)view.findViewById(R.id.photo);
        catches = (TextView)view.findViewById(R.id.catches);
        access = (TextView)view.findViewById(R.id.access);
        address = (TextView)view.findViewById(R.id.address);
        open = (TextView)view.findViewById(R.id.open);
        close = (TextView)view.findViewById(R.id.close);
        wifi = (TextView)view.findViewById(R.id.wifi);
        privateRoom= (TextView)view.findViewById(R.id.privateRoom);
        card = (TextView)view.findViewById(R.id.card);
        about= (TextView)view.findViewById(R.id.about);
        url = (TextView)view.findViewById(R.id.url);
        budget = (TextView)view.findViewById(R.id.budget);





        titles.setText(selectedTitle);
        address.setText(selectedAddress);
        catches.setText(selectedCatches);
        access.setText(selectedAccess);
        open.setText(selectedOpen);
        close.setText(selectedClose);
        budget.setText(selectedBudget);
        wifi.setText(selectedWifi);
        privateRoom.setText(selectedPrivate);
        card.setText(selectedCard);
        about.setText(selectedAbout);
        url.setText(selectedUrl);



        Picasso.with(getActivity()).load(selectedPhoto).into(photos);

        return view;

    }

}
