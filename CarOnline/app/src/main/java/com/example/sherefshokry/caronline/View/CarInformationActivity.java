package com.example.sherefshokry.caronline.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sherefshokry.caronline.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Sheref Shokry on 8/2/2016.
 */
public class CarInformationActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_information_layout);
        final ImageView carImage = (ImageView) findViewById(R.id.carImg1);
        final TextView carNameTxt = (TextView) findViewById(R.id.carName1);
        final TextView carPriceTxt = (TextView) findViewById(R.id.carPrice);
        final TextView carDescriptionTxt = (TextView) findViewById(R.id.carDescription);
        final Button backToHome = (Button) findViewById(R.id.homeBtn);

        intent=getIntent();
;
        Picasso.with(this).load(intent.getStringExtra("carImg")).into(carImage);
        carNameTxt.setText("Car Name  : " + intent.getStringExtra("carName"));
        carPriceTxt.setText("Car Price :   "+intent.getStringExtra("carPrice"));
        carDescriptionTxt.setText("Car Description :  "+intent.getStringExtra("carDiscription"));



        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarInformationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }
}
