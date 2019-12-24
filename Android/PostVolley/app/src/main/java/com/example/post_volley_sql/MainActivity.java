package com.example.post_volley_sql;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.post_volley_sql.Recycler.PostAdapter;
import com.example.post_volley_sql.data.db;
import com.example.post_volley_sql.data.items;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static SQLiteDatabase _db=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("1weqw");
        PostAdapter adapter;
        db sql = new db(this);
        _db = sql.getWritableDatabase();
        TextView add;
        add = findViewById(R.id.add);
        add.setOnClickListener(v->{
            Intent intent = new Intent(this,AddActivity.class);
            startActivity(intent);
        });
        ArrayList<items> data = new ArrayList<>();
        Cursor selectData = this._db.query("posts", null, null, null, null, null, null, null);
        if(selectData.moveToFirst()){
            do {
                System.out.println("founddbpost");
                int id = selectData.getInt(selectData.getColumnIndex("id"));
                String title = selectData.getString(selectData.getColumnIndex("title"));
                String body = selectData.getString(selectData.getColumnIndex("body"));
                items itemData = new items(id, title, body);
                data.add(itemData);
            } while (selectData.moveToNext());
        }else{

            System.out.println("founddbpostnoooooooooo");
            JsonArrayRequest postArrayRequest = new JsonArrayRequest(
                    Request.Method.GET,
                    "https://jsonplaceholder.typicode.com/posts",
                    null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            for (int i=0; i<50; i++){
                                try {
                                    JSONObject item = response.getJSONObject(i);
                                    ContentValues insertValues = new ContentValues();
                                    insertValues.put("title", item.getString("title"));
                                    insertValues.put("body", item.getString("body"));
                                    _db.insert("posts", null, insertValues);
                                    System.out.println(item.getString("name"));
                                } catch (JSONException e) { e.printStackTrace(); }
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) { }
                    }
            );

            RequestQueue newRequestQueue = Volley.newRequestQueue(this);
            newRequestQueue.add(postArrayRequest);
        }
        RecyclerView recyclerView = findViewById(R.id.RecyclerID);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PostAdapter(getApplicationContext(), data);
        recyclerView.setAdapter(adapter);
    }
}
