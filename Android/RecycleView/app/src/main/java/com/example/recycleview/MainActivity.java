package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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
        adapter.setActivity(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void OnClickListener(Person person) {
        Intent intent = new Intent(this, InnerPageActivity.class);
        intent.putExtra("Person", person);
        startActivity(intent);
    }
    private ActionMode.Callback actionmodecallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.avanger_menu_app, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()){
                case R.id.delete_avanger_menu_item:
//                    method()
                    mode.finish();
                    break;
            }


            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
        }
    };
}