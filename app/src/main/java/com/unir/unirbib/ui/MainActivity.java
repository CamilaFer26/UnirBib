package com.unir.unirbib.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.unir.unirbib.R;

public class MainActivity extends AppCompatActivity {
    private Button btnPesquisar, btnCadastrar, btnRemover, btnAtualizar;
    private RadioGroup rdPesquisarPor;
    private TextInputEditText editPesquisar;

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

        btnPesquisar = findViewById(R.id.btnPesquisar);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnRemover = findViewById(R.id.btnRemover);
        btnAtualizar = findViewById(R.id.btnAtualizar);
        rdPesquisarPor = findViewById(R.id.radioGroup);
        editPesquisar = findViewById(R.id.edtTituloPesquisa);

        btnPesquisar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PesquisaActivity.class);
            int tipo = rdPesquisarPor.getCheckedRadioButtonId();
            String busca = editPesquisar.getText().toString();

            intent.putExtra("tipo", tipo);
            intent.putExtra("busca", busca);
            startActivity(intent);
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });

        btnRemover.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Remover livro");
            builder.setIcon(R.drawable.unir);
            builder.setMessage("Informe o ID do livro:");

        });
    }
}