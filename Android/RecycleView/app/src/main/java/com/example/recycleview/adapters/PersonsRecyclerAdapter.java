package com.example.recycleview.adapters;

import android.app.Activity;
import android.graphics.Color;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.R;
import com.example.recycleview.mock.mockdata;
import com.example.recycleview.models.Person;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PersonsRecyclerAdapter extends RecyclerView.Adapter<PersonsRecyclerAdapter.PersonHolder> {
    private List<Person> persons = new ArrayList<>();
    private Activity activity;
    private List<Person> toDeletePerson = new ArrayList<>();
    private ActionMode mActionMode;
    private boolean done = false;



    public void setActivity(Activity activity){
        this.activity = activity;
    }
    @NonNull
    @Override
    public PersonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.persons_list_layout, parent, false);
        final PersonHolder holder = new PersonHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonHolder holder, int position) {
        Person person = persons.get(position);
        holder.applyData(person);
    }

    @Override
    public int getItemCount() {
        return persons.size();
//            return 10;
    }
    public void setItems(List<Person> persons){
        this.persons.clear();
        this.persons.addAll(persons);
    }
    private Person selectedPerson;

    class PersonHolder extends  RecyclerView.ViewHolder{
        private TextView Name ;
        private TextView Age;
        private ImageView Image;
        public PersonHolder(@NonNull View itemView) {
            super(itemView);

            Name  = itemView.findViewById(R.id.user_name);
            Age   = itemView.findViewById(R.id.user_age);
            Image = itemView.findViewById(R.id.person_image);
        }



        void applyData(Person person){
            Name.setText(person.getName()+"");
            Age.setText(person.getAge()+" "+"Year Old");
            selectedPerson = person;
            Picasso.get().load(person.getImageurl()).into(Image);
            clear();
            toDeletePerson.clear();
            itemView.setOnClickListener(v -> {
                myclick.OnClickListener(person);
            });
         itemView.setOnLongClickListener(v -> {
             Toast.makeText(activity, mActionMode+"", Toast.LENGTH_SHORT).show();
             if(mActionMode!=null){
                 return false;
             }
             mActionMode = activity.startActionMode(actionModeCallBack);
             if(person.isChecked()== false){
                 person.setChecked(true);
                 itemView.setBackgroundColor(Color.parseColor("#8f9595"));
                 toDeletePerson.add(person);
             }else{
                 person.setChecked(false);
                 clear();
                 toDeletePerson.remove(person);
             }
             mActionMode = null;
             return true;
         });
        }
        void clear(){
            itemView.setBackgroundColor(Color.parseColor("#ffffff"));
        }
    }
    void deletePErsons(){
        int toDeleteSize =  toDeletePerson.size();
        for ( Person toDeletePersons : toDeletePerson ) {
            persons.remove(toDeletePersons);
            notifyDataSetChanged();
//            Toast.makeText(activity, toDeletePersons.getName() , Toast.LENGTH_SHORT).show();
        }
    }
    public void removeSelection() {
        for (Person personsa: persons  ) {
            personsa.setChecked(false);
            Toast.makeText(activity, personsa.getName()+"", Toast.LENGTH_SHORT).show();
        }
        notifyDataSetChanged();
    }
    private clicklistener myclick;

    public void setOnClickListener(clicklistener listener){
        this.myclick= listener;
    }


    public interface clicklistener{
        void OnClickListener(Person person);
    }



 private ActionMode.Callback actionModeCallBack = new ActionMode.Callback() {
     @Override
     public boolean onCreateActionMode(ActionMode mode, Menu menu) {
         activity.getMenuInflater().inflate(R.menu.avanger_menu_app, menu);
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
//                 method
                 deletePErsons();
                 mActionMode = null;
         }
         mode.finish();
         return true;
     }

     @Override
     public void onDestroyActionMode(ActionMode mode) {
         Toast.makeText(activity, mActionMode+"", Toast.LENGTH_SHORT).show();
         mActionMode = null;
     }
 };

}