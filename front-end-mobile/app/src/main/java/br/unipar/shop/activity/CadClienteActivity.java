package br.unipar.shop.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import br.unipar.shop.R;
import br.unipar.shop.controlador.ClienteControlador;
import br.unipar.shop.controlador.manipuladorExcessao.ErroPadrao;
import br.unipar.shop.dto.ClienteDTO;

public class CadClienteActivity extends AppCompatActivity {
    private EditText etNome;
    private EditText etCpf;
    private final ClienteControlador clienteControlador = new ClienteControlador();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_cliente);

        etNome = findViewById(R.id.etNome);
        etCpf = findViewById(R.id.etCpf);

        findViewById(R.id.btFinalizarCad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ClienteDTO dto = new ClienteDTO(null, etNome.getText().toString(), etCpf.getText().toString());
                    clienteControlador.salvarCliente(dto);
                    limparCampos();
                    redirecionarFocu(etNome);
                    Toast.makeText(CadClienteActivity.this, "Cliente Salvo com Sucesso!", Toast.LENGTH_LONG).show();
                } catch (ErroPadrao erro) {
                    Toast.makeText(CadClienteActivity.this, "Erro " + erro.getCod() + ", " + erro.getMsg(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void redirecionarFocu(EditText editText) {
        editText.requestFocus();
    }
    private void limparCampos() {
        etNome.setText("");
        etCpf.setText("");
    }
}
