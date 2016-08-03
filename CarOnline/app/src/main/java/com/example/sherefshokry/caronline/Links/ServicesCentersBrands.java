package com.example.sherefshokry.caronline.Links;

import android.content.Context;
import android.content.Intent;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Sheref Shokry on 8/2/2016.
 */
public class ServicesCentersBrands implements ControllerOptions {

    private Context context;

    public ServicesCentersBrands(Context context)
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

        Intent intent = new Intent("com.example.sherefshokry.caronline.View.ServicesCentersBrandsActivity");
        intent.putExtra("car_brands",brands);
        context.startActivity(intent);

    }
}

