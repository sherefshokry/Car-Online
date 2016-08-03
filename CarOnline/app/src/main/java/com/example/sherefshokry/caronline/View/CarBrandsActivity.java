package com.example.sherefshokry.caronline.View;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sherefshokry.caronline.Controllers.Controller;
import com.example.sherefshokry.caronline.Links.Brands;
import com.example.sherefshokry.caronline.Links.Cars;
import com.example.sherefshokry.caronline.Model.Brand;
import com.example.sherefshokry.caronline.Model.CarBrandsAdapter;
import com.example.sherefshokry.caronline.Model.CarBrandsDataProvider;
import com.example.sherefshokry.caronline.R;

import java.util.ArrayList;

/**
 * Created by Sheref Shokry on 8/2/2016.
 */
public class CarBrandsActivity extends AppCompatActivity {

    private Intent intent;
    private ListView listView;
    private CarBrandsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brandslist);
        listView = (ListView) findViewById(R.id.listView1);

       ArrayList<Brand> brandList = new  ArrayList<Brand>();
        intent = getIntent();
       String brands= intent.getStringExtra("car_brands");

        String carBrands[]= brands.split("##");

        for(int i=0;i<carBrands.length;i++) {
            String brandDetails[] = carBrands[i].split(",,");
            Brand brand = new Brand(Integer.parseInt(brandDetails[0]), brandDetails[1], brandDetails[2]);
            brandList.add(brand);
        }


        adapter = new CarBrandsAdapter(getApplicationContext(),R.layout.brandslayout);
        listView.setAdapter(adapter);

        for(int i=0; i< brandList.size();i++)
        {
            CarBrandsDataProvider dataProvider = new CarBrandsDataProvider( brandList.get(i).getBrandID(), brandList.get(i).getBrandName(), brandList.get(i).getBrandImage());
            adapter.add(dataProvider);
        }


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(checkInternetConenction()) {
                    Controller controller = Controller.getInstance();
                    final Cars cars = new Cars(CarBrandsActivity.this);
                    controller.execute(CarBrandsActivity.this, cars, String.valueOf(position+1));  }
                else {
                    Toast.makeText(getBaseContext(), "Please,check your Internet Connection", Toast.LENGTH_LONG).show();
                }
            }

            private boolean checkInternetConenction() {
                // get Connectivity Manager object to check connection
                ConnectivityManager connec =(ConnectivityManager)getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

                // Check for network connections
                if ( connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||

                        connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
                        connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
                        connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED ) {
                    return true;
                }else if (
                        connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.DISCONNECTED ||
                                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.DISCONNECTED  ) {
                    return false;
                }
                return false;
            }

        });






    }


}
