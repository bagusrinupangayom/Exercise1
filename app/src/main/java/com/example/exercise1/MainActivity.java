package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    TextView textDaftar;
    Button btnLogin;
    EditText email, pass;
    TextInputLayout lgEmail, lgPassword;
    boolean isEmailValid, isPassValid;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.txEmail);
        pass = findViewById(R.id.txPassword);
        btnLogin = findViewById(R.id.btnLogin);
        textDaftar = findViewById(R.id.txDaftar);
        lgEmail = findViewById(R.id.txxEmail);
        lgPassword = findViewById(R.id.txxPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { validasiData(); }
        });

        textDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Pendaftaran.class));
            }
        });
    }

    public void validasiData(){
        String trueEmail ="admin@mail.com";
        String truePass = "123456";

        if (email.getText().toString().isEmpty()){
            lgEmail.setError("Email Tidak Boleh Kosong");
            isEmailValid = false;
        } else if(!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){
            lgEmail.setError("Email Masih Kurang Tepat");
            isEmailValid = false;
        }else{
            isEmailValid = true;
            lgEmail.setErrorEnabled(false);
        }
        if (pass.getText().toString().isEmpty()){
            lgPassword.setError("Password Tidak Boleh Kosong");
            isPassValid = false;
        }else if (pass.getText().length() < 6){
            lgPassword.setError("Panjang Password Minimal 6 Karakter");
            isPassValid = false;
        }else{
            isPassValid = true;
            lgPassword.setErrorEnabled(false);
        }

        if (!email.getText().toString().equals(trueEmail) || !pass.getText().toString().equals(truePass) || !isPassValid || !isEmailValid){
            Toast.makeText(getApplicationContext(), "Email / Password Salah", Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_LONG).show();
        startActivity(new Intent(getApplicationContext(),Kontak.class));
    }
}