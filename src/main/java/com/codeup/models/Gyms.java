package com.codeup.models;

public class Gyms {
    private long id;
    private String name;
    private String type;
    private double membership;

    public Gyms(){
    }

    public Gyms(String name, String type, double membership){
        this.name = name;
        this.type = type;
        this.membership = membership;
    }

    public Gyms(long id, String name, String type, double membership){
        this.id = id;
        this.name = name;
        this.type = type;
        this.membership = membership;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public double getMembership(){
        return membership;
    }

    public void setMembership(double membership){
        this.membership = membership;
    }

}
