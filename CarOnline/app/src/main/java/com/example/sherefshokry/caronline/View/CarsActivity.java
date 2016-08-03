package com.example.sherefshokry.caronline.View;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sherefshokry.caronline.Controllers.Controller;
import com.example.sherefshokry.caronline.Links.Cars;
import com.example.sherefshokry.caronline.Model.Brand;
import com.example.sherefshokry.caronline.Model.Car;
import com.example.sherefshokry.caronline.Model.CarBrandsAdapter;
import com.example.sherefshokry.caronline.Model.CarBrandsDataProvider;
import com.example.sherefshokry.caronline.Model.CarsAdapter;
import com.example.sherefshokry.caronline.Model.CarsDataProvider;
import com.example.sherefshokry.caronline.R;

import java.util.ArrayList;

public class CarsActivity extends AppCompatActivity {

    private Intent intent;
    private ListView listView;
    private CarsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carlist);
        listView = (ListView) findViewById(R.id.listView3);

        final ArrayList<Car> carList = new  ArrayList<Car>();
        intent = getIntent();
        String cars= intent.getStringExtra("cars");

            String carArray[]= cars.split("##");

            for(int i=0;i<carArray.length;i++) {
                String carDetails[] = carArray[i].split(",,");
                Car car = new Car(Integer.parseInt(carDetails[0]), carDetails[1],carDetails[2],Double.parseDouble(carDetails[3]),carDetails[4]);
                carList.add(car);
            }


            adapter = new CarsAdapter(getApplicationContext(),R.layout.carlayout);
            listView.setAdapter(adapter);

            for(int i=0; i< carList.size();i++)
            {
                CarsDataProvider dataProvider = new CarsDataProvider(carList.get(i).getCarID(), carList.get(i).getCarPic(),carList.get(i).getCarName());
                adapter.add(dataProvider);
            }

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(CarsActivity.this, CarInformationActivity.class);
                    intent.putExtra("carImg",carList.get(position).getCarPic());
                    intent.putExtra("carName",carList.get(position).getCarName());
                    intent.putExtra("carPrice",String.valueOf(carList.get(position).getCarPrice()));
                    intent.putExtra("carDiscription",carList.get(position).getCarDescription());

                    startActivity(intent);

                }
            });
        }
    }