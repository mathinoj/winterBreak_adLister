package com.codeup.dao;

public class DaoFactory {
    private static GymsDao gymsDao;
    private static Config config = new Config();

    public static GymsDao getGymsDao(){
        if(gymsDao == null){
            gymsDao = new GymsDao(config);
        }
        return gymsDao;
    }
}
