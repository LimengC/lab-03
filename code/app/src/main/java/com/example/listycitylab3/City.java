package com.example.listycitylab3;

import java.io.Serializable;

public class City implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String province;

    public City(String name, String province) {
        this.name = name;
        this.province = province;
    }

    // Getters
    public String getName() { return name; }
    public String getProvince() { return province; }

    // Setters (required by the lab tip: allow editing properties)
    public void setName(String name) { this.name = name; }
    public void setProvince(String province) { this.province = province; }
}
