package com.example.englishapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView editInfo, editPass;
    LinearLayout viewHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editPass = (TextView) findViewById(R.id.btneditPassword);
        editInfo = (TextView) findViewById(R.id.btneditUser);
        viewHistory = (LinearLayout) findViewById(R.id.btnlichsu);

        editPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditPass();
            }
        });
        editInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditInfo();
            }
        });
        viewHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHistory();
            }
        });
    }

    public void openEditPass(){
        Intent password = new Intent(this, UpdatePassword.class);
        startActivity(password);
    }
    public void openHistory(){
        Intent history = new Intent(this, ViewHistory.class);
        startActivity(history);
    }

    public void openEditInfo(){
        Intent intent = new Intent(this, EditInfo.class);
        startActivity(intent);
    }
}