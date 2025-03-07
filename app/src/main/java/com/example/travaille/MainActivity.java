package com.example.travaille;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText nom, email, phone, adresse;
    private Spinner spinner;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        nom = findViewById(R.id.nom);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        adresse = findViewById(R.id.adresse);
        spinner = findViewById(R.id.spinner);
        btn = findViewById(R.id.btn);



        btn.setOnClickListener(v -> {

            String nomValue = nom.getText().toString();
            String emailValue = email.getText().toString();
            String phoneValue = phone.getText().toString();
            String adresseValue = adresse.getText().toString();
            String villeValue = spinner.getSelectedItem().toString();


            Intent intent = new Intent(MainActivity.this, Recapitulatif.class);
            intent.putExtra("nom", nomValue);
            intent.putExtra("email", emailValue);
            intent.putExtra("phone", phoneValue);
            intent.putExtra("adresse", adresseValue);
            intent.putExtra("ville", villeValue);
            startActivity(intent);
        });
    }

}