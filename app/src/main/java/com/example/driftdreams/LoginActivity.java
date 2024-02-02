package com.example.driftdreams;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
EditText edemail1,edpass2;
Button btnlogin;
TextView txtsignup;
FirebaseAuth mAuth;

    public static String PREFS_NAME="MyPrefsFile";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edemail1=findViewById(R.id.idemail);
        edpass2=findViewById(R.id.idpass);
        btnlogin=findViewById(R.id.loginbutton);
        txtsignup=findViewById(R.id.idsignup);

        txtsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,Signupactivity.class);
                startActivity(intent);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences(LoginActivity.PREFS_NAME,0);
                SharedPreferences.Editor editor=sharedPreferences.edit();

                editor.putBoolean("haslogin",true);
                editor.commit();

                startActivity(new Intent(LoginActivity.this,NavigationActivity.class));
                finish();
            String email=edemail1.getText().toString().trim();
            String pass=edpass2.getText().toString().trim();
            Login(email,pass);

            //Intent intent = new Intent(LoginActivity.this,NavigationActivity.class);
           // startActivity(intent);
            }
        });
    }

    private void Login(String email, String pass) {

        ProgressDialog dialog=new ProgressDialog(LoginActivity.this);
        dialog.setMessage("Loading Please wait");
        dialog.show();
        mAuth=FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Intent intent = new Intent(LoginActivity.this,NavigationActivity.class);
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this, "Please Enter Correct Detail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}