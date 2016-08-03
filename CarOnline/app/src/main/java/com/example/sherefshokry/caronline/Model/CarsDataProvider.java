package com.example.sherefshokry.caronline.Model;

/**
 * Created by Sheref Shokry on 8/2/2016.
 */
public class CarsDataProvider {

    private int carId;
    private String carName;
    private String carImage;


    public  CarsDataProvider(String img,String name)
    {
        carName=name;
        carImage=img;
    }

    public  CarsDataProvider(int id,String img,String name)
    {
        carId=id;
        carName=name;
        carImage=img;
    }


    public String getCarName()
    {
        return carName;
    }

    public String getCarImg()
    {
        return carImage;
    }



}
