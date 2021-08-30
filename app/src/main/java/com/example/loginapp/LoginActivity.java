package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txUser;
    private EditText txPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txUser =(EditText) findViewById(R.id.txUser);
        txPassword =(EditText) findViewById(R.id.txPassword);
        btnLogin =(Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                onLogin();
                break;
            default:
                break;
        }
    }

    private void onLogin() {
        if (txUser.getText().toString().isEmpty() || txPassword.getText().toString().isEmpty()){
            Toast.makeText(this, "Mời nhập Username và Password", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra("USER_NAME", txUser.getText().toString());
            startActivity(intent);
        }
    }
}