package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class register extends AppCompatActivity {

    private EditText email,pass;
    private Button register;
    private ProgressDialog dialog;
    private TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register= (Button) findViewById(R.id.login);
        email=(EditText) findViewById(R.id.email);
        pass=(EditText) findViewById(R.id.password);
        login=(TextView) findViewById(R.id.log);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(register.this,loginNow.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1=email.getText().toString();
                String pass1=pass.getText().toString();

                if(TextUtils.isEmpty(email1)) Toast.makeText(getApplicationContext(),"Please enter name",Toast.LENGTH_SHORT).show();
                else if(TextUtils.isEmpty(pass1)) Toast.makeText(getApplicationContext(),"Please enter phone number",Toast.LENGTH_SHORT).show();

                else{
                    dialog=new ProgressDialog(register.this);
                    dialog.setMessage("Please wait while checking credentials");
                    dialog.show();

                    FirebaseAuth mAuth= FirebaseAuth.getInstance();
                    mAuth.createUserWithEmailAndPassword(email1,pass1)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_SHORT).show();
                                        dialog.dismiss();
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(),"NO",Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                }
            }
    });
    }
}
