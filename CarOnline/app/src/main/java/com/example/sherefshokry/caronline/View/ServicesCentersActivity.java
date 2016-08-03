package com.example.sherefshokry.caronline.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sherefshokry.caronline.Links.ServicesCentersLink;
import com.example.sherefshokry.caronline.Model.CarsAdapter;
import com.example.sherefshokry.caronline.Model.ServiceCenters;
import com.example.sherefshokry.caronline.R;

import java.util.ArrayList;

/**
 * Created by Sheref Shokry on 8/2/2016.
 */
public class ServicesCentersActivity extends AppCompatActivity {

    private Intent intent;
    private ListView listView;
    private CarsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servicescenterslist);
        listView = (ListView) findViewById(R.id.listView4);

        final ArrayList<ServiceCenters> servicesCentersList = new ArrayList<ServiceCenters>();
        intent = getIntent();
        String centers = intent.getStringExtra("centers");

        String centersArray[] = centers.split("##");

        for (int i = 0; i < centersArray.length; i++) {
            String centersDetails[] = centersArray[i].split(",,");
            ServiceCenters s = new ServiceCenters(Integer.parseInt(centersDetails[0]), centersDetails[1], centersDetails[2], centersDetails[3], centersDetails[4], centersDetails[5]);
            servicesCentersList.add(s);
        }


        ArrayList<String> servicesCentersNames = new  ArrayList<String>();

        for(int i=0;i<servicesCentersList.size();i++)
            servicesCentersNames.add(servicesCentersList.get(i).getCenterName());


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this , R.layout.servicescenterslayout,servicesCentersNames );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ServicesCentersActivity.this, serviceCenterInformationActivity.class);
                intent.putExtra("name",servicesCentersList.get(position).getCenterName());
                intent.putExtra("phone", servicesCentersList.get(position).getCenterPhone());
                intent.putExtra("address", servicesCentersList.get(position).getCenterAddress());
                intent.putExtra("hours", servicesCentersList.get(position).getCenterWorkingHours());
                intent.putExtra("holiday",servicesCentersList.get(position).getCenterHolidays());

                startActivity(intent);
            }
        });



    }
}
