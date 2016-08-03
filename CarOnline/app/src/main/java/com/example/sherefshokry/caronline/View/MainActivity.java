package com.example.sherefshokry.caronline.View;

import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.example.sherefshokry.caronline.Controllers.Controller;
import com.example.sherefshokry.caronline.Links.Brands;
import com.example.sherefshokry.caronline.Links.ServicesCentersBrands;
import com.example.sherefshokry.caronline.Model.MainMenuAdapter;
import com.example.sherefshokry.caronline.Model.MainMenuDataProvider;
import com.example.sherefshokry.caronline.R;

public class MainActivity extends AppCompatActivity {
    MainMenuAdapter adapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView2);
        adapter = new MainMenuAdapter(getApplicationContext(),R.layout.mainlayout);
        listView.setAdapter(adapter);



      String categoryNames [] = new String[]{"New Cars","Services Centers"};
         int menuImageIcons [] = new int[]{R.drawable.car , R.drawable.service};


        for(int i=0; i<2;i++)
        {
            MainMenuDataProvider dataProvider = new MainMenuDataProvider(menuImageIcons[i],categoryNames[i]);
         adapter.add(dataProvider);
        }


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(checkInternetConenction()) {
                    Controller controller = Controller.getInstance();

                    if(position==0) {
                        final Brands brands = new Brands(MainActivity.this);
                        controller.execute(MainActivity.this, brands);

                    }
                    else {
                        final ServicesCentersBrands servicesCentersBrands = new ServicesCentersBrands(MainActivity.this);
                        controller.execute(MainActivity.this, servicesCentersBrands);
                    }

                }
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
