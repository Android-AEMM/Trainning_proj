package com.example.trainning_proj.Home;

import android.os.Parcelable;

import java.util.ArrayList;

public class Data  {
    int image;
    String name ,desc,address,location;

    public Data(int image, String name, String desc, String address, String location) {
        this.image = image;
        this.name = name;
        this.desc = desc;
        this.address = address;
        this.location = location;
    }

    public Data(int image, String name, String desc) {
        this.image = image;
        this.name = name;
        this.desc = desc;
    }

    public Data(int image, String name, String desc, String address) {
        this.image = image;
        this.name = name;
        this.desc = desc;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getLocation() {
        return location;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
