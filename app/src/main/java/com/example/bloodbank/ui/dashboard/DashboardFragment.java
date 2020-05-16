package com.example.bloodbank.ui.dashboard;

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
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodbank.R;
import com.example.bloodbank.donorViewHolder;
import com.example.bloodbank.model.donoritem;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class DashboardFragment extends Fragment {
    private EditText search;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;


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
}
