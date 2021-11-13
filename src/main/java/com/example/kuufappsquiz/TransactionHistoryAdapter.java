package com.example.kuufappsquiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TransactionHistoryAdapter extends RecyclerView.Adapter<TransactionHistoryAdapter.ViewHolder>{

    Context ctx;
    String[] Name;
    String[] Date;
    int Price[];

    @NonNull
    @Override
    public TransactionHistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ctx = parent.getContext();

        //Inflater = BG
        View view = LayoutInflater.from(ctx).inflate(R.layout.transaction_history,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionHistoryAdapter.ViewHolder holder, int position) {

        holder.tv_name.setText(Name[position]);
        holder.tv_date.setText(Date[position]);
        holder.tv_price.setText( String.valueOf(Price[position]));

    }

    @Override
    public int getItemCount() {


        return Name.length;
    }

    public void SetData (String[] Name,String[] Date, int[] Price) {
        this.Name=Name;
        this.Price=Price;
        this.Date=Date;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name,tv_date,tv_price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_date = itemView.findViewById(R.id.tv_date);
        }
    }
}
