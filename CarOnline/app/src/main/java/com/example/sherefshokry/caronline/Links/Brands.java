package com.example.sherefshokry.caronline.Links;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.sherefshokry.caronline.Model.Brand;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Sheref Shokry on 8/2/2016.
 */
public class Brands implements ControllerOptions {

    private Context context;

    public Brands(Context context)
    {
        this.context = context;
    }
    @Override
    public String[] connect(String... params) {
        String all[] = new String[2];
        all[0] = "http://shokry-autorestaurant.rhcloud.com/BackendAutoRestaurant/rest/GetBrands";
        all[1] ="";
        return all;

    }

    @Override
    public void connReturn(String result) throws JSONException {

//        Toast.makeText(context,result, Toast.LENGTH_LONG).show();

        JSONObject object = new JSONObject(result);
        String brands = object.getString("car brands");

        Intent intent = new Intent("com.example.sherefshokry.caronline.View.CarBrandsActivity");
        intent.putExtra("car_brands",brands);
        context.startActivity(intent);

    }
}
