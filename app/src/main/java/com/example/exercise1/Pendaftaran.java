package com.example.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class Pendaftaran extends AppCompatActivity {
    String agama, jk;
    int stsAgama, stsJk;
    Button daftar, batal;
    EditText nama, alamat, email, pass, repass;
    TextInputLayout namaInp, alamatInp, emailInp, passInp, repassInp;
    RadioButton islam, kristen, hindu, buddha, katolik, konghucu, kepercayaan, laki, perempuan;
    RadioGroup agama1, agama2, kepercayaan1, jeniskelamin;
    boolean isRadioChecked, isEmailValid, isPassValid, isRePassValid, isNamaValid, isAlamatValid;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran);

        daftar = findViewById(R.id.btnDaftar);
        batal = findViewById(R.id.btnBatal);
        nama = findViewById(R.id.daftarNama);
        alamat = findViewById(R.id.daftarAlamat);
        email = findViewById(R.id.addEmail);
        pass = findViewById(R.id.addPassword);
        repass = findViewById(R.id.addRePassword);
        namaInp = findViewById(R.id.ndaftarNama);
        alamatInp = findViewById(R.id.ndaftarAlamat);
        emailInp = findViewById(R.id.TambahEmail);
        passInp = findViewById(R.id.TambahPassword);
        repassInp = findViewById(R.id.TambahPasswordLagi);
        islam = findViewById(R.id.RadioIslam);
        kristen = findViewById(R.id.RadioKristen);
        hindu = findViewById(R.id.RadioHindu);
        katolik = findViewById(R.id.RadioKatolik);
        buddha = findViewById(R.id.RadioBudha);
        konghucu = findViewById(R.id.RadioKonghucu);
        kepercayaan = findViewById(R.id.RadioPenKepercayaan);
        laki = findViewById(R.id.radioCowo);
        perempuan = findViewById(R.id.radioCewe);
        jeniskelamin = findViewById(R.id.jnklmnRadio);
        agama1 = findViewById(R.id.RadioAgama_a);
        agama2 = findViewById(R.id.RadioaAgama_b);
        kepercayaan1 = findViewById(R.id.RadioKepercayaan);
        agama = "";
        jk = "";

//        Untuk Button Daftar
        this.daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pendaftaran.this.setAgama(v);
                Pendaftaran.this.setJeniskelamin(v);
                Pendaftaran.this.validasiDaftar(v);
            }
        });

//        Untuk Button Batal
        this.batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        this.agama1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                if (i != -1 && isRadioChecked){
                    isRadioChecked = false;
                    agama2.clearCheck();
                    kepercayaan1.clearCheck();
                    stsAgama = i;
                }
                isRadioChecked = true;
            }
        });

        this.agama2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int j) {
                if (j != -1 && isRadioChecked){
                    isRadioChecked = false;
                    agama1.clearCheck();
                    kepercayaan1.clearCheck();
                    stsAgama = j;
                }
                isRadioChecked = true;
            }
        });

        this.kepercayaan1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int k) {
                if (k != -1 && isRadioChecked){
                    isRadioChecked = false;
                    agama1.clearCheck();
                    agama2.clearCheck();
                    stsAgama = k;
                }
                isRadioChecked = true;
            }
        });

        this.jeniskelamin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                if (i != -1 && Pendaftaran.this.isRadioChecked){
                    Pendaftaran.this.isRadioChecked = false;
                    Pendaftaran.this.stsJk = i;
                }
                Pendaftaran.this.isRadioChecked = true;
            }
        });



    }

    public void setAgama(View v){
        int i = stsAgama;

        if(i == R.id.RadioIslam){
            agama = "Islam";
        }else if(i == R.id.RadioKristen){
            agama = "Kristen";
        }else if(i == R.id.RadioKatolik){
            agama = "Katolik";
        }else if(i == R.id.RadioHindu){
            agama = "Hindu";
        }else if(i == R.id.RadioBudha){
            agama = "Buddha";
        }else if(i == R.id.RadioKonghucu){
            agama = "Konghucu";
        }else if(i == R.id.RadioPenKepercayaan){
            agama = "Aliran Kepercayaan";
        }
    }

    public void setJeniskelamin(View v){
        int i = this.stsJk;
        if(i == R.id.radioCewe){
            this.jk = "Perempuan";
        }else if(i == R.id.radioCowo){
            this.jk = "Laki-laki";
        }
    }

    public void validasiDaftar(View v){
        if(this.nama.getText().toString().isEmpty() || this.alamat.getText().toString().isEmpty() ||
                this.email.getText().toString().isEmpty() || this.pass.getText().toString().isEmpty() ||
                this.repass.getText().toString().isEmpty() || this.agama.isEmpty() || this.jk.isEmpty()){
            Toast.makeText(getApplicationContext(),"Data Harus Diisi Semua",Toast.LENGTH_LONG).show();
        }

        if(nama.getText().toString().isEmpty()){
            namaInp.setError("Nama Tidak Boleh Kosong");
            isNamaValid = false;
        }else{
            namaInp.setErrorEnabled(false);
            isNamaValid = true;
        }

        if (this.alamat.getText().toString().isEmpty()){
            this.alamatInp.setError("Alamat Tidak Boleh Kosong");
            this.isAlamatValid = false;
        }else{
            this.alamatInp.setErrorEnabled(false);
            this.isAlamatValid = true;
        }

        if (this.email.getText().toString().isEmpty()){
            this.emailInp.setError("Email Tidak Boleh Kosong");
            this.isEmailValid = false;
        }else if (!Patterns.EMAIL_ADDRESS.matcher(this.email.getText().toString()).matches()){
            this.emailInp.setError("Format Email Kurang Tepat");
            this.isEmailValid = false;
        }else{
            this.emailInp.setErrorEnabled(false);
            this.isEmailValid = true;
        }

        if (this.pass.getText().toString().isEmpty()){
            this.passInp.setError("Password Tidak Boleh Kosong");
            this.isPassValid = false;
        }else if (this.pass.getText().length() < 6){
            this.passInp.setError("Password Minimal Memiliki 6 Karakter");
            this.isPassValid = false;
        }else{
            this.passInp.setErrorEnabled(false);
            this.isPassValid = true;
        }

        if (this.repass.getText().toString().isEmpty()){
            this.repassInp.setError("Re-Password Tidak Boleh Kosong");
            this.isRePassValid = false;
        }else if (this.repass.getText().length() < 6){
            this.repassInp.setError("Password Minimal Memiliki 6 Karakter");
            this.isRePassValid = false;
        }else if (!this.repass.getText().toString().equals(pass.getText().toString())){
            this.repassInp.setError("Password Tidak Sama");
            this.isRePassValid = false;
        }else{
            this.repassInp.setErrorEnabled(false);
            this.isRePassValid = true;
        }

        if (this.isNamaValid && this.isAlamatValid && this.isEmailValid && this.isPassValid && this.isRePassValid && !this.agama.isEmpty() && !this.jk.isEmpty()){
            Toast.makeText(getApplicationContext(),"Pendaftaran Telah Berhasil",Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }
    }
}

