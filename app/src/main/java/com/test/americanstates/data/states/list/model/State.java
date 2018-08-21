package com.test.americanstates.data.states.list.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by
 * Mykhailo on 8/21/2018.
 */
public class State implements Serializable {

    private int id;
    private String country;
    private String name;
    private String abbr;
    private String area;
    @SerializedName("largest_city")
    private String largestCity;
    private String capital;

    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public String getAbbr() {
        return abbr;
    }

    public String getArea() {
        return area;
    }

    public String getLargestCity() {
        return largestCity;
    }

    public String getCapital() {
        return capital;
    }
}
