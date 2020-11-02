package com.example.bloodbank.ui.dashboard;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodbank.R;
import com.example.bloodbank.donorLogin;
import com.example.bloodbank.donorViewHolder;
import com.example.bloodbank.image;
import com.example.bloodbank.model.donoritem;
import com.example.bloodbank.video1;
import com.example.bloodbank.video3;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class DashboardFragment extends Fragment {
    private EditText search;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressDialog dialog;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        search=root.findViewById(R.id.searchbar);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView = root.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);



        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString()!=null){
                    Loaddata(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });

        return root;
    }

    public void Loaddata(String data){

        final DatabaseReference listref = FirebaseDatabase.getInstance().getReference().child("Donors");
        Query query=listref.orderByChild("city").startAt(data).endAt(data+"\uf8ff");

        FirebaseRecyclerOptions<donoritem> options=
                new FirebaseRecyclerOptions.Builder<donoritem>()
                        .setQuery(query,donoritem.class)
                        .build();

        FirebaseRecyclerAdapter<donoritem, donorViewHolder> adapter=new FirebaseRecyclerAdapter<donoritem, donorViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull donorViewHolder holder, int position, @NonNull donoritem model) {
                holder.name.setText(model.getName());
                holder.city.setText("City: " + model.getCity());
                holder.number.setText("Contact: "+ model.getPhone());
                holder.bloodGroup.setText(model.getBloodGroup());
            }

            @NonNull
            @Override
            public donorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.donoritem,parent,false);
                donorViewHolder holder=new donorViewHolder(view);
                return holder;
            }
        };
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }


    public void onStart() {

        super.onStart();
        final DatabaseReference listref = FirebaseDatabase.getInstance().getReference().child("Donors");

        FirebaseRecyclerOptions<donoritem> options=
                new FirebaseRecyclerOptions.Builder<donoritem>()
                        .setQuery(listref,donoritem.class)
                        .build();

        FirebaseRecyclerAdapter<donoritem, donorViewHolder> adapter=new FirebaseRecyclerAdapter<donoritem, donorViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull donorViewHolder holder, int position, @NonNull donoritem model) {

                final String number=model.getPhone();
                holder.name.setText(model.getName());
                holder.city.setText("City: " + model.getCity());
                holder.number.setText("Contact: "+ model.getPhone());
                holder.bloodGroup.setText(model.getBloodGroup());

                holder.view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog=new ProgressDialog(getContext());
                        dialog.setMessage("Loading");
                        dialog.show();
//                        new AlertDialog.Builder(getContext())
//                                .setTitle("Make Call")
//                                .setMessage("Are you sure you want to make a call to the donor")
//
//                                // Specifying a listener allows you to take an action before dismissing the dialog.
//                                // The dialog is automatically dismissed when a dialog button is clicked.
//                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        Intent intent = new Intent(Intent.ACTION_DIAL);
//                                        intent.setData(Uri.parse("tel:"+number));
//                                        startActivity(intent);
//
//                                    }
//                                })
//
//                                // A null listener allows the button to dismiss the dialog and take no further action.
//                                .setNegativeButton("No", null)
//                                .setIcon(android.R.drawable.ic_dialog_alert)
//                                .show();
                        Intent intent=new Intent(getActivity(), image.class);
                        startActivity(intent);
                        dialog.dismiss();




                    }
                });
            }

            @NonNull
            @Override
            public donorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.donoritem,parent,false);
                donorViewHolder holder=new donorViewHolder(view);
                return holder;
            }
        };
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }
}
