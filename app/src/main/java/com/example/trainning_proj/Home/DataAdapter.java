package com.example.trainning_proj.Home;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.trainning_proj.Place.Place;
import com.example.trainning_proj.R;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    ArrayList<Data> list_data ;
    Context context ;

    public DataAdapter(Context context, ArrayList<Data> list_data ) {
        this.list_data = list_data;
        this.context = context;
    }

    public DataAdapter(Home context, ArrayList<DataProduct> arrayList_product) {
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        final Data data_item = list_data.get(position);

        holder.txt_name_card_item.setText(data_item.getName());
        holder.image_card_item.setImageResource(data_item.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            Intent intent = new Intent(context, Place.class);
            @Override
            public void onClick(View v) {

                intent.putExtra("name", data_item.getName());
                intent.putExtra("desc", data_item.getDesc());
                intent.putExtra("image", data_item.getImage());
                intent.putExtra("address", data_item.getAddress());


                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }


    public static class DataViewHolder extends RecyclerView.ViewHolder{

        ImageView image_card_item;
        TextView  txt_name_card_item;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);

            image_card_item = itemView.findViewById(R.id.image_card_item);
            txt_name_card_item= itemView.findViewById(R.id.txt_name_card_item);
        }
    }
}
