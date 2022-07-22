package com.example.healthstreet;

public class Person {
    int Image;
    String Name;
    String Des;
    String Cos;

    public Person(int image, String name, String des, String cos) {
        Image = image;
        Name = name;
        Des = des;
        Cos = cos;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDes() {
        return Des;
    }

    public void setDes(String des) {
        Des = des;
    }

    public String getCos() {
        return Cos;
    }

    public void setCos(String cos) {
        Cos = cos;
    }
}