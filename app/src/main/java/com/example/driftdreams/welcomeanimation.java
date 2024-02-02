package com.example.driftdreams;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class welcomeanimation extends AppCompatActivity {

    private static int Splashtimeout=1000;
Button button;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomeanimation);

        button=findViewById(R.id.button);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SharedPreferences sharedPreferences=getSharedPreferences(LoginActivity.PREFS_NAME,0);
                        boolean haslogin=sharedPreferences.getBoolean("haslogin",false);

                        if(haslogin){
                            Intent intent=new Intent(welcomeanimation.this,NavigationActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Intent intent=new Intent(welcomeanimation.this,Signupactivity.class);
                            startActivity(intent);
                            finish();

                        }

                    }
                });
            }
        },Splashtimeout);
    }
}