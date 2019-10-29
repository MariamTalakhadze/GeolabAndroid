package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recycleview.models.Person;
import com.squareup.picasso.Picasso;

public class InnerPageActivity extends AppCompatActivity {
    private ImageView detailedimg;
    private TextView name;
    private TextView Lastname;
    private TextView MobileNumber;
    private TextView Age;
    private Button call;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_page);

        detailedimg = findViewById(R.id.detailed_image);
        MobileNumber = findViewById(R.id.MobileNumber);
        name = findViewById(R.id.DetailedName);
        Lastname = findViewById(R.id.DetailedLastName);
        Age = findViewById(R.id.DetailedAge);
        call = findViewById(R.id.callme);
        Person person = (Person) getIntent().getSerializableExtra("Person");
        if (person != null) {
            Picasso.get().load(person.getImageurl()).into(detailedimg);
            MobileNumber.setText(person.getPhoneNumber());
            name.setText(person.getName());
            Lastname.setText(person.getLastName());
            Age.setText(person.getAge() + "");
            call.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + person.getPhoneNumber()));
                startActivity(intent);
            });
            MobileNumber.setOnClickListener(v -> {
                Intent intent  = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+person.getPhoneNumber()));
                startActivity(intent);
            });

        }
    }
}
