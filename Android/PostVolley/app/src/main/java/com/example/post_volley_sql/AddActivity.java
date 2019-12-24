package com.example.post_volley_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    EditText addtitle;
    EditText addbody;

    Button addbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        addtitle = findViewById(R.id.addtitle);
        addbody = findViewById(R.id.addbody);

        addbtn = findViewById(R.id.addButton);

        addbtn.setOnClickListener(v->{
            String title = addtitle.getText().toString();
            String body = addbody.getText().toString();
            ContentValues insertValues = new ContentValues();
            insertValues.put("title", title);
            insertValues.put("body", body);
            MainActivity._db.insert("posts", null, insertValues);
            Toast.makeText(getApplicationContext(),"Successfully Added",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(AddActivity.this, MainActivity.class);
            startActivity(intent);
        });


    }
}
