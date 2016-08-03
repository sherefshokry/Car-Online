package com.example.sherefshokry.caronline.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sherefshokry.caronline.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Sheref Shokry on 8/2/2016.
 */
public class serviceCenterInformationActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.center_information_layout);

        final TextView nameTxt = (TextView) findViewById(R.id.centerName1);
        final TextView phoneTxt = (TextView) findViewById(R.id.centerPhone);
        final TextView addressTxt = (TextView) findViewById(R.id.centerAddress);
        final TextView hoursTxt = (TextView) findViewById(R.id.centerWorkingHours);
        final TextView holidaysTxt = (TextView) findViewById(R.id.centerHolidays);
        final Button backToHome = (Button) findViewById(R.id.homeBtn2);

        intent=getIntent();

        nameTxt.setText(" Name  :  " + intent.getStringExtra("name"));
        phoneTxt.setText("phone number  :  " + intent.getStringExtra("phone"));
        addressTxt.setText("Address  :  " + intent.getStringExtra("address"));
        hoursTxt.setText("Working Hours:    "+intent.getStringExtra("hours"));
        holidaysTxt.setText("Holidays :   "+intent.getStringExtra("holiday"));



        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(serviceCenterInformationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
