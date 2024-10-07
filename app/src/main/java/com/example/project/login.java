package com.example.project;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private Button loginButton, signUpButton;
    private CheckBox rememberMeCheckBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Link UI components
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.login);
        signUpButton = findViewById(R.id.signUp);
        rememberMeCheckBox = findViewById(R.id.rememberMeCheckBox);


        // Set up button click listeners
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSignUp();
            }
        });


    }

    private void handleLogin() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show();
        } else {
            // Implement your authentication logic here (API call, database check, etc.)
            if (authenticateUser(email, password)) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                // Navigate to another activity after successful login
                // startActivity(new Intent(this, HomeActivity.class));
            } else {
                Toast.makeText(this, "Invalid Email or Password", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean authenticateUser(String email, String password) {
        // This is just a placeholder for actual authentication logic
        // In a real app, you might check these details from a database or API
        return email.equals("test@example.com") && password.equals("password");
    }

    private void navigateToSignUp() {
        // Navigate to SignUp Activity
        Intent intent = new Intent(login.this, SignUpActivity.class);
        startActivity(intent);
    }

    private void handleForgotPassword() {
        // Logic for Forgot Password (could be navigating to a Reset Password Activity or showing a dialog)
        Toast.makeText(this, "Forgot Password clicked", Toast.LENGTH_SHORT).show();
    }

    // A simple method to validate username and password
    private boolean validateCredentials(String username, String password) {
        return username.equals("user") && password.equals("pass123");
    }
}
