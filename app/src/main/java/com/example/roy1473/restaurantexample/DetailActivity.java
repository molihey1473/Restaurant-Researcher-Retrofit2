package com.example.roy1473.restaurantexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.roy1473.restaurantexamle.R;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
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
    Button backButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        titles = (TextView)findViewById(R.id.title);
        photos = (ImageView)findViewById(R.id.photo);
        catches = (TextView)findViewById(R.id.catches);
        access = (TextView)findViewById(R.id.access);
        address = (TextView)findViewById(R.id.address);
        open = (TextView)findViewById(R.id.open);
        close = (TextView)findViewById(R.id.close);
        wifi = (TextView)findViewById(R.id.wifi);
        privateRoom= (TextView)findViewById(R.id.privateRoom);
        card = (TextView)findViewById(R.id.card);
        about= (TextView)findViewById(R.id.about);
        url = (TextView)findViewById(R.id.url);
        budget = (TextView)findViewById(R.id.budget);
        backButton = (Button)findViewById(R.id.backButton);


        Intent intent = getIntent();
        String selectedText = intent.getStringExtra("title");
        String photoText = intent.getStringExtra("photo");
        String addressText= intent.getStringExtra("address");
        String catchText = intent.getStringExtra("catches");
        String accessText = intent.getStringExtra("access");
        String openText = intent.getStringExtra("open");
        String closeText= intent.getStringExtra("close");
        String wifiText = intent.getStringExtra("wifi");
        String privateRoomText = intent.getStringExtra("private");
        String cardText= intent.getStringExtra("card");
        String aboutText = intent.getStringExtra("about");
        String urlText = intent.getStringExtra("url");
        String budgetText = intent.getStringExtra("budget");
        titles.setText(selectedText);
        address.setText(addressText);
        catches.setText(catchText);
        access.setText(accessText);
        open.setText(openText);
        close.setText(closeText);
        budget.setText(budgetText);
        wifi.setText(wifiText);
        privateRoom.setText(privateRoomText);
        card.setText(cardText);
        about.setText(aboutText);
        url.setText(urlText);



        Picasso.with(getApplicationContext()).load(photoText).into(photos);



    }

    public void onBackButtonTapped(View view){
        finish();
    }





}
