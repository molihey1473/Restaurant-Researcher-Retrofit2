package com.example.roy1473.restaurantexamle.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Roy1473 on 2017/03/19.
 */

public class LargeArea {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("catch")
    @Expose
    private String _catch;
    @SerializedName("code")
    @Expose
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatch() {
        return _catch;
    }

    public void setCatch(String _catch) {
        this._catch = _catch;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
