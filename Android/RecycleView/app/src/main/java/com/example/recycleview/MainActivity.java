package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.recycleview.adapters.PersonsRecyclerAdapter;
import com.example.recycleview.mock.mockdata;
import com.example.recycleview.models.Person;

import java.util.List;

public class MainActivity extends AppCompatActivity implements PersonsRecyclerAdapter.clicklistener {
    private RecyclerView recyclerView;
    private PersonsRecyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPersonAdapter();
    }
    private void initPersonAdapter(){
        recyclerView = findViewById(R.id.Recycler_id);
        adapter = new PersonsRecyclerAdapter();
        adapter.setItems(mockdata.getPersons());
        adapter.setOnClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void OnClickListener(Person person) {
       Intent intent = new Intent(this, InnerPageActivity.class);
       intent.putExtra("Person", person);
       startActivity(intent);
    }
}
