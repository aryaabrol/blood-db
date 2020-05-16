package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class donorLogin extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText name,phone,city;
    Spinner bloodGroup;
    private Button register;
    private ProgressDialog dialog;
    String bloodGroup1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_login);

        register= (Button) findViewById(R.id.login);
        name=(EditText) findViewById(R.id.password);
        phone=(EditText) findViewById(R.id.number);
        city=(EditText) findViewById(R.id.city);
        bloodGroup=(Spinner) findViewById(R.id.email);
        ArrayAdapter<CharSequence> arrayAdapter=ArrayAdapter.createFromResource(this,R.array.groups,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloodGroup.setAdapter(arrayAdapter);
        bloodGroup.setOnItemSelectedListener(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1=name.getText().toString();
                String phone1=phone.getText().toString();
                String city1=city.getText().toString();
                //String bloodGroup1;

                if(TextUtils.isEmpty(name1)) Toast.makeText(getApplicationContext(),"Please enter name",Toast.LENGTH_SHORT).show();
                else if(TextUtils.isEmpty(phone1)) Toast.makeText(getApplicationContext(),"Please enter phone number",Toast.LENGTH_SHORT).show();
                else if(TextUtils.isEmpty(city1)) Toast.makeText(getApplicationContext(),"Please enter city",Toast.LENGTH_SHORT).show();

                else{
                    dialog=new ProgressDialog(donorLogin.this);
                    dialog.setMessage("Please wait while checking credentials");
                    dialog.show();

                    AddData(name1,phone1,city1,bloodGroup1);
                }
            }
        });
    }

    private void AddData(final String name1, final String phone1, final String city1, final String bloodGroup1) {
        final DatabaseReference ref= FirebaseDatabase.getInstance().getReference();
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(!(dataSnapshot.child("Donors").child(phone1).exists())){
                    HashMap<String,Object> hashMap=new HashMap<>();
                    hashMap.put("name",name1);
                    hashMap.put("phone",phone1);
                    hashMap.put("bloodGroup",bloodGroup1);
                    hashMap.put("city",city1);

                    ref.child("Donors").child(phone1).updateChildren(hashMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(getApplicationContext(),"Details Added Successfully",Toast.LENGTH_SHORT).show();
                                        dialog.dismiss();
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(),"Phone number already exists",Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });

                }
                else
                    Toast.makeText(getApplicationContext(),"Phone number already exists",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        bloodGroup1 =parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(getApplicationContext(),"Please enter blood group",Toast.LENGTH_SHORT).show();
    }
}
