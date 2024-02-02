package com.example.driftdreams;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.L;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signupactivity extends AppCompatActivity {
EditText edname,edemail,edpass;
Button btnsignup;
TextView txtsignin;
String name,email,pass;
FirebaseAuth mAuth;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupactivity);
        edname=findViewById(R.id.editText);
        edemail=findViewById(R.id.editText2);
        edpass=findViewById(R.id.editText3);
        btnsignup=findViewById(R.id.butn);
        txtsignin=findViewById(R.id.signin);

        txtsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Signupactivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });


        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name=edname.getText().toString().trim();
                email=edemail.getText().toString().trim();
                pass=edpass.getText().toString().trim();
                if(name.isEmpty()||email.isEmpty() ||pass.isEmpty() ||pass.length()< 6 ){
                    Toast.makeText(Signupactivity.this, "Please Enter Email and Password", Toast.LENGTH_LONG).show();
                }else{
                    Login(name,email,pass);
                }
            }
        });
    }

    public void Login(String name, String email, String pass) {

        mAuth=FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Adddatatorealtime();
                    Toast.makeText(Signupactivity.this, "Welcome", Toast.LENGTH_LONG).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Signupactivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void Adddatatorealtime() {
        AddData obj = new AddData(name,email,pass);
        FirebaseDatabase firebaseDatabase;
        DatabaseReference databaseReference;
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Drift Dreams").child("Details");
        databaseReference.setValue(obj).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()) {
                    Toast.makeText(Signupactivity.this, "Data Successfully Added", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Signupactivity.this, LoginActivity.class);
                    startActivity(intent);

                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Signupactivity.this, "Data Not Found", Toast.LENGTH_SHORT).show();
            }
        });

    }
}