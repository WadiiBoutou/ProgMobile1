package com.example.travaille;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Recapitulatif extends AppCompatActivity {
    private TextView textReca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recapitulatif);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            textReca = findViewById(R.id.textReca);


            String name = getIntent().getStringExtra("nom");
            String email = getIntent().getStringExtra("email");
            String phone = getIntent().getStringExtra("phone");
            String address = getIntent().getStringExtra("adresse");
            String ville = getIntent().getStringExtra("ville");


            String reca = "Nom : " + name + "\n" +
                    "Email : " + email + "\n" +
                    "Téléphone : " + phone + "\n" +
                    "Adresse : " + address + "\n" +
                    "Ville : " + ville;

            textReca.setText(reca);
            return insets;

        });
    }
}