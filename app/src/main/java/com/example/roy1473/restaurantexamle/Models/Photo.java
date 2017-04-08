package com.example.roy1473.restaurantexamle.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Roy1473 on 2017/03/19.
 */

public class Photo {
    @SerializedName("pc")
    @Expose
    private Pc pc;
    @SerializedName("mobile")
    @Expose
    private Mobile mobile;

    public Pc getPc() {
        return pc;
    }

    public void setPc(Pc pc) {
        this.pc = pc;
    }

    public Mobile getMobile() {
        return mobile;
    }

    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
    }
}
