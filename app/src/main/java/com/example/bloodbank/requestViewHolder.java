package com.example.bloodbank;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class requestViewHolder extends RecyclerView.ViewHolder {
    public TextView name,city,phone,bloodGroup;
    public requestViewHolder(@NonNull View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.name);
        city=itemView.findViewById(R.id.city);
        bloodGroup=itemView.findViewById(R.id.bloodgroup);
        phone=itemView.findViewById(R.id.number);


    }
}
