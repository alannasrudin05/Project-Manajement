package com.praktikum.projectmanajer.View;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.praktikum.projectmanajer.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    String intentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.login.setOnClickListener(v -> {
            String email = binding.emailInput.getText().toString();
            String password = binding.passwordInput.getText().toString();

            if (isValidInput(email, password)) {
//                lakukan pengecekan lagi pada database
                if (performLogin(email, password)) {
                    navigateToMainActivity(email, password);
                } else {
                    Toast.makeText(this, "Kredensial salah!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Harap masukan email and password yang benar", Toast.LENGTH_SHORT).show();
            }
        });

        binding.register.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, SignupActivity.class)));
    }

    private boolean isValidInput(String email, String password) {
//        buat logic untuk mengecek format email dan password
        return !email.isEmpty() && !password.isEmpty();
    }

    private boolean performLogin(String email, String password) {
//        lakukan pengecekan pada database
        Intent intent = getIntent();
        if (intent != null) {
            intentName = intent.getStringExtra("name");
            String intentEmail = intent.getStringExtra("email");
            String intentPassword = intent.getStringExtra("password");
            if (intentEmail != null && intentPassword != null) {
                return email.equals(intentEmail) && password.equals(intentPassword);
            }
        }
        return false;
    }

    private void navigateToMainActivity(String email, String password) {
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        i.putExtra("name", intentName);
        i.putExtra("email", email);
        i.putExtra("password", password);
        startActivity(i);
//        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }
}