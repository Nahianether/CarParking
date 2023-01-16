package com.example.ether.carparking;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ether.carparking.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity{

    ActivityMainBinding binding;
    String name,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main);

        name=binding.name.getText().toString();
        pass=binding.pass.getText().toString();

        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBAccess dbAccess=DBAccess.getInstance(getApplicationContext());
                dbAccess.open();

                int value=dbAccess.login(name,pass);
                if(value==1){
                    Toast.makeText(MainActivity.this,"Logged in",Toast.LENGTH_LONG).show();
                }
                else{

                    Toast.makeText(MainActivity.this,"Wrong Username or Password",Toast.LENGTH_LONG).show();
                }

            }
        });

    }


}
