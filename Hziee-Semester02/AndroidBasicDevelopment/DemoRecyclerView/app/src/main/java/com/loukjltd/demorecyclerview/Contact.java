package com.loukjltd.demorecyclerview;

public class Contact {
    private String name;
    private String mobile;
    private int photo;

    public Contact(String name, String mobile, int photo) {
        this.name = name;
        this.mobile = mobile;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
