package com.nanda.studentapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    AppCompatButton b1,b2;
    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8;
    String apiurl="https://courseapplogix.onrender.com/addstudents";
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
        b2=(AppCompatButton) findViewById(R.id.view);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), view.class);
                startActivity(i);
            }
        });
b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String getFname=ed1.getText().toString();
        String getLname=ed2.getText().toString();
        String getCname=ed3.getText().toString();
        String getDob=ed4.getText().toString();
        String getCourse=ed5.getText().toString();
        String getMob=ed6.getText().toString();
        String getEmail=ed7.getText().toString();
        String getAdd=ed8.getText().toString();
        Toast.makeText(getApplicationContext(),getFname+getLname+getCname+getDob+getCourse+getMob+getEmail+getAdd,Toast.LENGTH_LONG).show();
        JSONObject stud=new JSONObject();

        try {
            stud.put("firstname",getFname);
            stud.put("lastname",getFname);
            stud.put("college",getCname);
            stud.put("dob",getDob);
            stud.put("course",getCourse);
            stud.put("mobile",getMob);
            stud.put("email",getEmail);
            stud.put("address\n",getAdd);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(
                Request.Method.POST,
                apiurl,
                stud,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(getApplicationContext(), "succesfully added", Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "something went wrong", Toast.LENGTH_LONG).show();

                    }
                });
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(jsonObjectRequest);
    }

});




    }
}



