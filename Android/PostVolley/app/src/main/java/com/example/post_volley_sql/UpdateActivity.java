package com.example.post_volley_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    private int postId;

    EditText title;
    EditText body;

    Button updatebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        title = findViewById(R.id.innertitle);
        body = findViewById(R.id.innerbody);

        updatebtn = findViewById(R.id.innerupdatebtn);

        Bundle extras = getIntent().getExtras();
        postId = extras.getInt("postId");

        Cursor c = MainActivity._db.rawQuery("SELECT * FROM posts WHERE id = ?", new String[] {String.valueOf(postId)});
        if (c.moveToFirst()) {
            title.setText(c.getString(c.getColumnIndex("title")));
            body.setText(c.getString(c.getColumnIndex("body")));
        }
        updatebtn.setOnClickListener(v->{
            String title1 = title.getText().toString();
            String body1 = body.getText().toString();

            ContentValues updateValues = new ContentValues();
            updateValues.put("title", title1);
            updateValues.put("body", body1);
            MainActivity._db.update("posts", updateValues, "id = ?", new String[] {String.valueOf(postId)});

            Toast.makeText(getApplicationContext(),"Successfully updated",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
            startActivity(intent);
        });

    }
}
