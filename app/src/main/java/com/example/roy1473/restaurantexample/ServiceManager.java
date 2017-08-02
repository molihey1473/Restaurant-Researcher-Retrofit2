package com.example.roy1473.restaurantexample;

import com.example.roy1473.restaurantexample.Interface.ApiInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**#set( $USER = "Roy1473" )
 * Created by Roy1473 on 2017/03/17.
 */

public class ServiceManager {

    private ApiInterface service;

    public ApiInterface getApiInterface(){

        /*
          The Retrofit class generates an implementation of the UService interface.
         */
        if(service == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ApiInterface.END_POINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            service = retrofit.create(ApiInterface.class);
        }
        return service;
    }
}
