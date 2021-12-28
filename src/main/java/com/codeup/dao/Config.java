package com.codeup.dao;

public class Config {

    public String getURL(){
        return "jdbc:mysql://localhost:3306/products_db?&allowPublicKeyRetrieval=true&useSSL=false";
    }

    public String getUser(){
        return "root";
    }

    public String getPassword(){
        return "codeup";
    }
}
