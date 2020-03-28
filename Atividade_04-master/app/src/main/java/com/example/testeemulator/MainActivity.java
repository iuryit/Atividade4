package com.example.testeemulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtNomeAluno;
    private EditText edtEmail;
    private EditText edtTelefone;
    private EditText edtCidade;
    private EditText edtUF;
    private EditText edtCurso;
    private EditText edtPeriodo;
    private Button btnSalvar;
    private Button btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        atribuirEventos();
    }

    private void initViews() {
        edtNomeAluno = findViewById(R.id.edtNomeAluno);
        edtEmail = findViewById(R.id.edtEmail);
        edtTelefone = findViewById(R.id.edtTelefone);
        edtCidade = findViewById(R.id.edtCidade);
        edtUF = findViewById(R.id.edtEstado);
        edtCurso = findViewById(R.id.edtCurso);
        edtPeriodo = findViewById(R.id.edtPeriodo);
        btnSalvar = findViewById(R.id.btnGravar);
        btnLimpar = findViewById(R.id.btnLimpar);
    }

    private void atribuirEventos() {
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Salvar();
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCampos();
            }
        });
    }

    private void Salvar() {
        Intent intentConfirmacao = new Intent(this, Confirmacao.class);
        intentConfirmacao = CarregarParametros(intentConfirmacao);
        startActivity(intentConfirmacao);
    }

    private Intent CarregarParametros(Intent intent) {
        int periodo = Integer.parseInt(edtPeriodo.getText().toString().isEmpty() ? "0" : edtPeriodo.getText().toString());

        intent.putExtra("Nome", edtNomeAluno.getText().toString());
        intent.putExtra("Email", edtEmail.getText().toString());
        intent.putExtra("Telefone", edtTelefone.getText().toString());
        intent.putExtra("Cidade", edtCidade.getText().toString());
        intent.putExtra("UF", edtUF.getText().toString());
        intent.putExtra("Curso", edtCurso.getText().toString());
        intent.putExtra("Periodo", periodo);
        return intent;
    }

    private void limparCampos() {
        edtNomeAluno.setText("");
        edtEmail.setText("");
        edtTelefone.setText("");
        edtCidade.setText("");
        edtUF.setText("");
        edtCurso.setText("");
        edtPeriodo.setText("");
    }
}
