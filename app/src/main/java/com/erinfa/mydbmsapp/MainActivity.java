package com.erinfa.mydbmsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Databasehelper db;
    EditText name,phone,address;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
        db = new Databasehelper(this);

        name = findViewById(R.id.Names);
       phone = findViewById(R.id.Phones);
      address = findViewById(R.id.Address);
      submit = findViewById(R.id.Submit);

         submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean chk = db.insertData(name.getText().toString(),phone.getText().toString(),address.getText().toString());
               if (chk==true)
               {
                  Toast.makeText(getApplicationContext(),"Submit Successfully", Toast.LENGTH_SHORT).show();
               }else {
                   Toast.makeText(getApplicationContext(),"Failure", Toast.LENGTH_SHORT).show();
               }
            }
       });
    }
}