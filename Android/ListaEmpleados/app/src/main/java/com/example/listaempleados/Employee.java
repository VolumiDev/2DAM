package com.example.listaempleados;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private String position;
    private String company;
    private ImageView avatar;

    Employee(String n, String c, String p){
        name = n;
        position = p ;
        company = c;
    }

    protected Employee(Parcel in) {
        name = in.readString();
        position = in.readString();
        company = in.readString();
    }

    public String show(){
        return "Name: " + name + " - Company: " + company + " - Position: " + position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
