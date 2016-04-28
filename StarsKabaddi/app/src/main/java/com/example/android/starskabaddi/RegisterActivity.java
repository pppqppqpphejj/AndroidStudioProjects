package com.example.android.starskabaddi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import android.app.AlertDialog;
import org.json.JSONException;
import org.json.JSONObject;



public class RegisterActivity extends AppCompatActivity {
    Button bRegister;
    EditText etName,etUsername,etEmail,etPassword;
    TextView tvLogin;
    String name,username,email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText) findViewById(R.id.etName);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bRegister = (Button) findViewById(R.id.bRegister);
        tvLogin = (TextView) findViewById(R.id.tvLogin);

        bRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            name = etName.getText().toString();
            username = etUsername.getText().toString();
            email= etEmail.getText().toString();
            password = etPassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                RegisterActivity.this.startActivity(intent);

                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Registration Failed!")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }

                };

                RegisterRequest registerRequest = new RegisterRequest(name, username,email,password,responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(RegisterActivity.this,LoginActivity.class);
                RegisterActivity.this.startActivity(loginIntent);


            }
        });
    }
}
