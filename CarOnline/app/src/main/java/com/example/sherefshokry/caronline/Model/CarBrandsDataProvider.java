package com.example.sherefshokry.caronline.Model;

/**
 * Created by Sheref Shokry on 8/2/2016.
 */
public class CarBrandsDataProvider {

    private int brandID;
    private String brandName;
    private String brandImage;


public  CarBrandsDataProvider(int id,String name,String img)
{
    brandID=id;
    brandName=name;
    brandImage=img;
}

 public int getBrandID()
 {
     return brandID;
 }

public String getBrandName()
{
    return brandName;
}

   public String getBrandImage()
   {
       return brandImage;
   }


}
