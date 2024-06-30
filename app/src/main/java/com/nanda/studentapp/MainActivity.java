package com.nanda.studentapp;

import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    AppCompatButton b1;
    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ed1=(EditText) findViewById(R.id.fname);
        ed2=(EditText) findViewById(R.id.lname);
        ed3=(EditText) findViewById(R.id.cname);
        ed4=(EditText) findViewById(R.id.dob);
        ed5=(EditText) findViewById(R.id.course);
        ed6=(EditText) findViewById(R.id.mob);
        ed7=(EditText) findViewById(R.id.email);
        ed8=(EditText) findViewById(R.id.add);
        b1=(AppCompatButton) findViewById(R.id.sub);

    }
}