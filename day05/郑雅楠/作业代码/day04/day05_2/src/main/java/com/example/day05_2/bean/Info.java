package com.example.day05_2.bean;

public class Info {
    private String name;
    private int pic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public Info(String name, int pic) {
        this.name = name;
        this.pic = pic;
    }
}
