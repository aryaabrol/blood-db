package com.example.bloodbank.ui.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bloodbank.MainActivity;
import com.example.bloodbank.R;
import com.example.bloodbank.chatbot;
import com.example.bloodbank.donorLogin;
import com.example.bloodbank.request;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeFragment extends Fragment {
    private Button donate,request,help;
    private TextView donorcount,requestcount,logout;
    private FloatingActionButton help2;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        help2=root.findViewById(R.id.help2);
        help=(Button)root.findViewById(R.id.help);
        donate=(Button) root.findViewById(R.id.donateButton);
        request=(Button) root.findViewById(R.id.requestButton);
        donorcount=(TextView) root.findViewById(R.id.donorcount);
        requestcount=(TextView) root.findViewById(R.id.requestcount);
        logout=(TextView)root.findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        help2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), chatbot.class);
                startActivity(intent);

            }
        });

        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                new AlertDialog.Builder(getContext())
                                .setTitle("Become Donor")
                                .setMessage("Your Blood report will be publicly visible until verified. Are you Sure?")

                                // Specifying a listener allows you to take an action before dismissing the dialog.
                                // The dialog is automatically dismissed when a dialog button is clicked.
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent=new Intent(getActivity(), donorLogin.class);
                                        startActivity(intent);

                                    }
                                })

                                // A null listener allows the button to dismiss the dialog and take no further action.
                                .setNegativeButton("No", null)
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();
            }
        });

        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), com.example.bloodbank.request.class);
                startActivity(intent);
            }
        });

        DatabaseReference mDatabaseRef = FirebaseDatabase.getInstance().getReference();
        mDatabaseRef.child("Donors").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int count=(int)dataSnapshot.getChildrenCount();
                donorcount.setText(Integer.toString(count)+"\nDonors");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mDatabaseRef.child("Requests").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int count=(int)dataSnapshot.getChildrenCount();
                requestcount.setText(Integer.toString(count)+"\nRequests");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        return root;
    }
}
