package com.example.testeemulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Confirmacao extends AppCompatActivity {

    private TextView txtDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao);

        initViews();

        Intent intentConfirmacao = getIntent();
        txtDados.setText(carregarDados(intentConfirmacao));
    }

    private void initViews() {
        txtDados = findViewById(R.id.txtDados);
    }

    private String carregarDados(Intent intent) {
        StringBuilder sb = new StringBuilder();
        sb.append(getText(R.string.txt_hint_nome) + ": " + intent.getStringExtra("Nome") + "\n");
        sb.append(getText(R.string.txt_hint_email) + ": " + intent.getStringExtra("Email") + "\n");
        sb.append(getText(R.string.txt_hint_telefone) + ": " + intent.getStringExtra("Telefone") + "\n");
        sb.append(getText(R.string.txt_hint_cidade) + ": " + intent.getStringExtra("Cidade") + "\n");
        sb.append(getText(R.string.txt_hint_uf) + ": " + intent.getStringExtra("UF") + "\n");
        sb.append(getText(R.string.txt_hint_curso) + ": " + intent.getStringExtra("Curso") + "\n");
        sb.append(getText(R.string.txt_hint_periodo) + ": " + intent.getIntExtra("Periodo", 0) + "\n");

        return sb.toString();
    }
}
