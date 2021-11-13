package com.example.kuufappsquiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder2>{

    Context ctx;
    String[] Name;
    String[] Min;
    String[] Max;
    int Price[];

    @NonNull
    @Override
    public StoreAdapter.ViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ctx = parent.getContext();

        View view = LayoutInflater.from(ctx).inflate(R.layout.storeitems,parent,false);
        return new ViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreAdapter.ViewHolder2 holder, int position) {

        holder.tv_ProductName.setText(Name[position]);
        holder.tv_ProductMin.setText(Min[position]);
        holder.tv_ProductMax.setText(Max[position]);
        holder.tv_ProductPrice.setText( String.valueOf(Price[position]));

    }

    @Override
    public int getItemCount() {


        return Name.length;
    }

    public void SetData (String[] Name,String[] Min,String[] Max, int[] Price) {
        this.Name=Name;
        this.Min=Min;
        this.Max=Max;
        this.Price=Price;

    }

    class ViewHolder2 extends RecyclerView.ViewHolder {

        TextView tv_ProductName,tv_ProductMin,tv_ProductMax,tv_ProductPrice;

        public ViewHolder2 (@NonNull View itemView) {
            super(itemView);

            tv_ProductName = itemView.findViewById(R.id.tv_ProductName);
            tv_ProductMin = itemView.findViewById(R.id.tv_ProductMin);
            tv_ProductMax = itemView.findViewById(R.id.tv_ProductMax);
            tv_ProductPrice = itemView.findViewById(R.id.tv_ProductPrice);
        }
    }
}

