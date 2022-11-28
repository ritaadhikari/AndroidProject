package com.example.firstandroidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//for frontend view
public class SignUpActivity extends AppCompatActivity {

    private Button btnSignUp;
    private EditText etUsername, etFullName, etEmail, etPassword, etConfirmPassword;
    private String username, fullname, email, password, confirmPassword;

    @Override
    //initializing an activity using onCreate()
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //variableName = findViewById(id of view.xml file ko)
        btnSignUp = findViewById(R.id.btnSignUp);
        etUsername = findViewById(R.id.etUsername);
        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (signupValidation()) {
                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    // to write msg after button is clicked
                    Toast.makeText(SignUpActivity.this, "Please enter details correctly", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean signupValidation() {
        username = etUsername.getText().toString();
        fullname = etFullName.getText().toString();
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();
        confirmPassword = etConfirmPassword.getText().toString();
        if (username.isEmpty()) {
            etUsername.setError("Username cannot be blank");
            return false;
        }
        if (fullname.isEmpty()) {
            etFullName.setError("FullName cannot be blank");
            return false;
        }
        if (email.isEmpty()) {
            etEmail.setError("Email cannot be blank");
            return false;
        }
        if (password.isEmpty()) {
            etPassword.setError("Password cannot be blank");
            return false;
        }
        return !confirmPassword.isEmpty();
    }
}