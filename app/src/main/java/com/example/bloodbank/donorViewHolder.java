package com.example.bloodbank;

import android.view.View;
import android.widget.TextView;
import com.example.bloodbank.itemClicklistener;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class donorViewHolder extends RecyclerView.ViewHolder  {
    public TextView name;
    public TextView city;
    public TextView bloodGroup;
    public TextView number;
    public View view;
    public donorViewHolder(@NonNull View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.name);
        city=itemView.findViewById(R.id.city);
        bloodGroup=itemView.findViewById(R.id.bloodgroup);
        number=itemView.findViewById(R.id.number);
        view=itemView;

    }


}
