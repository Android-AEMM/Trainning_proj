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
import com.example.trainning_proj.Product.Product_buy;
import com.example.trainning_proj.R;

import java.util.ArrayList;

public class DataProductAddapter extends RecyclerView.Adapter<DataProductAddapter.DataViewHolder> {
    ArrayList<DataProduct> list_data ;
    Context context ;

    public DataProductAddapter(Context context, ArrayList<DataProduct> list_data ) {
        this.list_data = list_data;
        this.context = context;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.card_item,parent ,false);

        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {

        final DataProduct  item = list_data.get(position);

        holder.txt_name_card_item.setText(item.getName());
        holder.image_card_item.setImageResource(item.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            Intent intent = new Intent(context, Product_buy.class);
            @Override
            public void onClick(View v) {

                intent.putExtra("name_product", item.getName());
                intent.putExtra("image_product", item.getImage());
                intent.putExtra("price", item.getPrice());
                intent.putExtra("desc_product", item.getDesc());



                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }


    public  static class DataViewHolder extends RecyclerView.ViewHolder{

        ImageView image_card_item;
        TextView  txt_name_card_item;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);

            image_card_item = itemView.findViewById(R.id.image_card_item);
            txt_name_card_item= itemView.findViewById(R.id.txt_name_card_item);
        }
    }
}
