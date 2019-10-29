package com.example.recycleview.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.R;
import com.example.recycleview.models.Person;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PersonsRecyclerAdapter extends RecyclerView.Adapter<PersonsRecyclerAdapter.PersonHolder> {
    private List<Person> persons = new ArrayList<>();

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
            Picasso.get().load(person.getImageurl()).into(Image);
            itemView.setOnClickListener(v -> {
                myclick.OnClickListener(person);
            });
        }
    }
    private clicklistener myclick;

    public void setOnClickListener(clicklistener listener){
        this.myclick= listener;
    }

    public interface clicklistener{
        void OnClickListener(Person person);
    }

}
