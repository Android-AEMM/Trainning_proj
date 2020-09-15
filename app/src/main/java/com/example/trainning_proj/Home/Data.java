package com.example.trainning_proj.Home;

public class Data {
    int image;
    String name ,desc;

    public Data(int image, String name, String desc) {
        this.image = image;
        this.name = name;
        this.desc = desc;
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
