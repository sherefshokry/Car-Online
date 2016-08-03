package com.example.sherefshokry.caronline.Links;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Sheref Shokry on 8/2/2016.
 */
public class ServicesCentersLink implements ControllerOptions {

    private Context context;

    public ServicesCentersLink(Context context)
    {
        this.context = context;
    }


    @Override
    public String[] connect(String... params) {
        String all[] = new String[2];
        all[0] = "http://shokry-autorestaurant.rhcloud.com/BackendAutoRestaurant/rest/GetServiceCenters";
        all[1] ="brandId="+Integer.parseInt(params[0]);
        return all;
    }


    @Override
    public void connReturn(String result) throws JSONException {

        Toast.makeText(context,result, Toast.LENGTH_LONG).show();


       JSONObject object = new JSONObject(result);
        String centers = object.getString("service centers");

        Intent intent = new Intent("com.example.sherefshokry.caronline.View.ServicesCentersActivity");
        intent.putExtra("centers",centers );
        context.startActivity(intent);

    }
}



