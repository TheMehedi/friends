package com.example.friends.detailsActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.friends.R;

public class DetailsActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView fullNameTvId, addressTvId, cityTvId, emailTvId, cellPhoneTvId;
    private String image, name, address, city, email, cell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        image = getIntent().getExtras().getString("image");
        name = getIntent().getExtras().getString("name");
        address = getIntent().getExtras().getString("address");
        city = getIntent().getExtras().getString("city");
        email = getIntent().getExtras().getString("email");
        cell = getIntent().getExtras().getString("cell");


        initViews();


        //setting image and other values to the view
        Glide.with(DetailsActivity.this).load(image).apply(new RequestOptions()
                .error(R.drawable.ic_launcher_background)).into(imageView);

        fullNameTvId.setText(name);
        addressTvId.setText(address);
        cityTvId.setText(city);
        emailTvId.setText(email);
        cellPhoneTvId.setText(cell);

        emailTvId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String eaddress = "mailto:" + email;

                Intent email= new Intent(Intent.ACTION_SENDTO);
                email.setData(Uri.parse(eaddress));
                email.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                email.putExtra(Intent.EXTRA_TEXT, "My Email message");
                startActivity(email);
            }
        });

    }

    private void initViews() {

        imageView = findViewById(R.id.imageView);
        fullNameTvId = findViewById(R.id.fullNameTvId);
        addressTvId = findViewById(R.id.addressTvId);
        cityTvId = findViewById(R.id.cityTvId);
        emailTvId = findViewById(R.id.emailTvId);
        cellPhoneTvId = findViewById(R.id.cellPhoneTvId);
    }
}