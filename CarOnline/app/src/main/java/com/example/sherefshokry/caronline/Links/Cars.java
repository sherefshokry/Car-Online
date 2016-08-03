package com.example.sherefshokry.caronline.Links;

import android.content.Context;
import android.content.Intent;

import org.json.JSONException;
import org.json.JSONObject;
        import android.widget.Toast;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.ArrayList;

/**
 * Created by Sheref Shokry on 8/2/2016.
 */

public class Cars implements ControllerOptions {

    private Context context;

    public Cars(Context context)
    {
        this.context = context;
    }
    @Override
    public String[] connect(String... params) {
        String all[] = new String[2];
        all[0] = "http://shokry-autorestaurant.rhcloud.com/BackendAutoRestaurant/rest/GetCars";
        all[1] ="brandId="+Integer.parseInt(params[0]);
        return all;
    }

    @Override
    public void connReturn(String result) throws JSONException {

        //Toast.makeText(context,result, Toast.LENGTH_LONG).show();


        JSONObject object = new JSONObject(result);
        String cars = object.getString("cars");

        Intent intent = new Intent("com.example.sherefshokry.caronline.View.CarsActivity");
        intent.putExtra("cars",cars);
        context.startActivity(intent);

    }
}


