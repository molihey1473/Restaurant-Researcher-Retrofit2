package com.example.roy1473.restaurantexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.roy1473.restaurantexample.Osakas.EsakaAreaActivity;
import com.example.roy1473.restaurantexample.Osakas.FukushimaAreaActivity;
import com.example.roy1473.restaurantexample.Osakas.HigashiOsakaAreaActivity;
import com.example.roy1473.restaurantexample.Osakas.HirakataAreaActivity;
import com.example.roy1473.restaurantexample.Osakas.IbarakiAreaActivity;
import com.example.roy1473.restaurantexample.Osakas.KishiwadaAreaActivity;
import com.example.roy1473.restaurantexample.Osakas.KujoAreaActivity;
import com.example.roy1473.restaurantexample.Osakas.KyobashiAreaActivity;
import com.example.roy1473.restaurantexample.Osakas.MatsubaraAreaActivity;
import com.example.roy1473.restaurantexample.Osakas.MinoAreaActivity;
import com.example.roy1473.restaurantexample.Osakas.NagaiAreaActivity;
import com.example.roy1473.restaurantexample.Osakas.OsakaCityAreaActivity;
import com.example.roy1473.restaurantexample.Osakas.OsakaSonotaAreaActivity;
import com.example.roy1473.restaurantexample.Osakas.SakaiAreaActivity;
import com.example.roy1473.restaurantexample.Osakas.SekimeAreaActivity;
import com.example.roy1473.restaurantexample.Osakas.TakatsukiAreaActivity;
import com.example.roy1473.restaurantexample.Osakas.TennojiAreaActivity;
import com.example.roy1473.restaurantexample.Osakas.TsuruhashiAreaActivity;
import com.example.roy1473.restaurantexample.Osakas.UmedaAreaActivity;
import com.example.roy1473.restaurantexample.Osakas.YodoyabashiAreaActivity;
import com.example.roy1473.restaurantexamle.R;

import java.util.ArrayList;

public class OsakaArea extends AppCompatActivity implements ListView.OnItemClickListener {

     ArrayList<String> areaList = new ArrayList<String>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_osaka_area);
        ListView listView = (ListView)findViewById(R.id.areaListView);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, areaList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

        getAreaList();
    }
    private void getAreaList(){

        //getAreaPostion

        areaList.add("梅田");
        areaList.add( "福島、野田");
        areaList.add("淀屋橋・本町・北浜・天満橋");
        areaList.add("京橋・天満・天六・南森町");
        areaList.add("心斎橋・なんば・南船場・堀江");
        areaList.add("天王寺");
        areaList.add("上本町・鶴橋");
        areaList.add("針中野･長居･西田辺･西成区･住吉");
        areaList.add("関目・千林・緑橋・深江橋");
        areaList.add("大阪市その他");
        areaList.add("堺・高石市・和泉市");
        areaList.add("高槻");
        areaList.add("茨木");
        areaList.add("泉大津･岸和田･泉佐野･りんくう");
        areaList.add("松原市･藤井寺市･富田林･南河内");
        areaList.add("江坂・西中島・新大阪・十三");
        areaList.add("東大阪市・八尾市・平野・大東市");
        areaList.add("九条･西九条･弁天町･大正･住之江");
        areaList.add("枚方・寝屋川・守口・門真");
        areaList.add("大阪府その他");
        areaList.add("箕面・池田");

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long l) {



        switch (position){
            case 0:
                Intent intentUmeda = new Intent(this, UmedaAreaActivity.class);
                startActivity(intentUmeda);
                break;
            case 1:
                Intent intentFukushima = new Intent(this, FukushimaAreaActivity.class);
                startActivity(intentFukushima);
                break;
            case 2:
                Intent intentYodoyabashi = new Intent(this, YodoyabashiAreaActivity.class);
                startActivity(intentYodoyabashi);
                break;
            case 3:
                Intent intentKyobashi = new Intent(this, KyobashiAreaActivity.class);
                startActivity(intentKyobashi);
                break;
            case 4:
                Intent intentShinsaibahi = new Intent(this, MainActivity.class);
                startActivity(intentShinsaibahi);
                break;
            case 5:
                Intent intentTennoji = new Intent(this, TennojiAreaActivity.class);
                startActivity(intentTennoji);
                break;
            case 6:
                Intent intentTsuruhashi = new Intent(this, TsuruhashiAreaActivity.class);
                startActivity(intentTsuruhashi);
                break;
            case 7:
                Intent intentNagai = new Intent(this, NagaiAreaActivity.class);
                startActivity(intentNagai);
                break;
            case 8:
                Intent intentSekime = new Intent(this, SekimeAreaActivity.class);
                startActivity(intentSekime);
                break;
            case 9:
                Intent intentOsakaCity = new Intent(this, OsakaCityAreaActivity.class);
                startActivity(intentOsakaCity);
                break;
            case 10:
                Intent intentSakai = new Intent(this, SakaiAreaActivity.class);
                startActivity(intentSakai);
                break;
            case 11:
                Intent intentTakatsuki = new Intent(this, TakatsukiAreaActivity.class);
                startActivity(intentTakatsuki);
                break;
            case 12:
                Intent intentIbaraki = new Intent(this, IbarakiAreaActivity.class);
                startActivity(intentIbaraki);
                break;
            case 13:
                Intent intentKishiwada = new Intent(this, KishiwadaAreaActivity.class);
                startActivity(intentKishiwada);
                break;
            case 14:
                Intent intentMatsubara = new Intent(this, MatsubaraAreaActivity.class);
                startActivity(intentMatsubara);
                break;
            case 15:
                Intent intentEsaka = new Intent(this, EsakaAreaActivity.class);
                startActivity(intentEsaka);
                break;
            case 16:
                Intent intentHigashiOsaka = new Intent(this, HigashiOsakaAreaActivity.class);
                startActivity(intentHigashiOsaka);
                break;
            case 17:
                Intent intentKujo = new Intent(this, KujoAreaActivity.class);
                startActivity(intentKujo);
                break;
            case 18:
                Intent intentHirakata = new Intent(this, HirakataAreaActivity.class);
                startActivity(intentHirakata);
                break;
            case 19:
                Intent intentOsakaSonota = new Intent(this, OsakaSonotaAreaActivity.class);
                startActivity(intentOsakaSonota);
                break;
            case 20:
                Intent intentMino = new Intent(this, MinoAreaActivity.class);
                startActivity(intentMino);
                break;
        }

    }
}
