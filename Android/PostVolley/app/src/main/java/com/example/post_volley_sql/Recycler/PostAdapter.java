package com.example.post_volley_sql.Recycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.post_volley_sql.MainActivity;
import com.example.post_volley_sql.R;
import com.example.post_volley_sql.UpdateActivity;
import com.example.post_volley_sql.data.items;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private ArrayList<items> itemsData;
    private Context context;

    public PostAdapter(Context context, ArrayList<items> itemsData) {
        this.itemsData = itemsData;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(context)
                .inflate(R.layout.recycler_list, null);

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtViewTitle.setText(itemsData.get(position).getTitle());
        holder.txtViewBody.setText(itemsData.get(position).getBody());
        holder.btnUpdate.setOnClickListener(v->{
            Intent intent = new Intent(context, UpdateActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("postId", itemsData.get(position).getId());
            context.startActivity(intent);
        });
        holder.btnDelete.setOnClickListener(v->{
                String postId = String.valueOf(itemsData.get(position).getId());
                MainActivity._db.delete("posts", "id = ?", new String[] {postId});
                itemsData.remove(position);
                notifyDataSetChanged();
            });

    }

    @Override
    public int getItemCount() {
        return itemsData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtViewTitle;
        public TextView txtViewBody;
        public Button btnUpdate;
        public Button btnDelete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtViewTitle = itemView.findViewById(R.id.title);
            txtViewBody = itemView.findViewById(R.id.body);
            btnUpdate = itemView.findViewById(R.id.update);
            btnDelete = itemView.findViewById(R.id.delete);
        }
    }
}
