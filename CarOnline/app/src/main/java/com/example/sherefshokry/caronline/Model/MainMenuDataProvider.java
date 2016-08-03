package com.example.sherefshokry.caronline.Model;

/**
 * Created by Sheref Shokry on 8/2/2016.
 */
public class MainMenuDataProvider {
    private String categoryName;
    private int categoryImage;


    public  MainMenuDataProvider(int img,String name)
    {
        categoryName=name;
        categoryImage=img;
    }


    public String getName()
    {
        return categoryName;
    }

    public int getImg()
    {
        return categoryImage;
    }

}
