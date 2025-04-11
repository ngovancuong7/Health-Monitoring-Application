package com.example.healthtrack.Views.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthtrack.R;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.ThreeBounce;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {
    private TextInputEditText emailInput;
    private Button sendEmailButton;
    private ProgressBar progressBar;
    private TextView loginText;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        init();
        setupListeners();
    }

    private void init() {
        emailInput = findViewById(R.id.forgot_email);
        sendEmailButton = findViewById(R.id.sendEmailButton);
        progressBar = findViewById(R.id.forgotProgressBar);
        loginText = findViewById(R.id.loginText);
        mAuth = FirebaseAuth.getInstance();

        Sprite threeBounce = new ThreeBounce();
        progressBar.setIndeterminateDrawable(threeBounce);
    }

    private void setupListeners() {
        sendEmailButton.setOnClickListener(v -> {
            String email = emailInput.getText().toString().trim();
            if (email.isEmpty()) {
                emailInput.setError("Vui lòng nhập email");
                return;
            }

            progressBar.setVisibility(View.VISIBLE);
            sendEmailButton.setVisibility(View.GONE);

            mAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(ForgotPasswordActivity.this, 
                                "Đã gửi email khôi phục mật khẩu", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(ForgotPasswordActivity.this,
                                "Không thể gửi email khôi phục. Vui lòng kiểm tra lại email.", 
                                Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                            sendEmailButton.setVisibility(View.VISIBLE);
                        }
                    });
        });

        loginText.setOnClickListener(v -> {
            Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
            finish();
        });
    }
} 