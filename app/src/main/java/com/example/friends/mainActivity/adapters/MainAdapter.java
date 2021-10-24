package com.example.friends.mainActivity.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.friends.R;
import com.example.friends.detailsActivity.DetailsActivity;
import com.example.friends.mainActivity.models.datamodels.MainDataModel;

import java.text.DecimalFormat;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    Context context;
    List<MainDataModel.Result> datumList;
    //ArrayList arrayList, address;

    public MainAdapter(Context context, List<MainDataModel.Result> datumList) {
        this.context = context;
        this.datumList = datumList;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.textView1.setText(datumList.get(position).getName().getTitle() + " " + datumList.get(position).getName().getFirst() + " "  + datumList.get(position).getName().getLast());
        holder.textView2.setText(datumList.get(position).getLocation().getCountry());

        Glide.with(context).load(datumList.get(position).getPicture().getThumbnail()).apply(new RequestOptions()
                .error(R.drawable.ic_launcher_background)).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("image", datumList.get(position).getPicture().getLarge());
                intent.putExtra("name", datumList.get(position).getName().getTitle() + " " + datumList.get(position).getName().getFirst() + " "  + datumList.get(position).getName().getLast());
                intent.putExtra("address", datumList.get(position).getLocation().getStreet().getNumber() + " " + datumList.get(position).getLocation().getStreet().getName());
                intent.putExtra("city", datumList.get(position).getLocation().getCity() + ", " + datumList.get(position).getLocation().getState() + ", " + datumList.get(position).getLocation().getCountry());
                intent.putExtra("email", datumList.get(position).getEmail());
                intent.putExtra("cell", datumList.get(position).getPhone());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        Log.i("getItemCount: ", "count " + datumList.size());
        return datumList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView1, textView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);

        }
    }



}