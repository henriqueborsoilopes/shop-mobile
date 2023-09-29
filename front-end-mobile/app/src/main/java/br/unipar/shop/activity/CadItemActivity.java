package br.unipar.shop.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import br.unipar.shop.R;
import br.unipar.shop.controlador.ItemControlador;
import br.unipar.shop.controlador.manipuladorExcessao.ErroPadrao;
import br.unipar.shop.dto.ItemDTO;

public class CadItemActivity extends AppCompatActivity {

    private EditText etDescricaoItem;
    private EditText etValorUnitItem;
    private ItemControlador itemControlador = new ItemControlador();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_item);

        etDescricaoItem = findViewById(R.id.etDescricaoItem);
        etValorUnitItem = findViewById(R.id.etValorUnitItem);

        findViewById(R.id.btFinalizarItem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ItemDTO dto = new ItemDTO(null, etDescricaoItem.getText().toString(), etValorUnitItem.getText().toString().isEmpty() ? 0.0 : new Double(etValorUnitItem.getText().toString()));
                    itemControlador.salvarItem(dto);
                    limparCampos();
                    redirecionarFocu(etDescricaoItem);
                    Toast.makeText(CadItemActivity.this, "Item Salvo com Sucesso!", Toast.LENGTH_LONG).show();
                } catch (ErroPadrao erro) {
                    Toast.makeText(CadItemActivity.this, "Erro " + erro.getCod() + ", " + erro.getMsg(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void redirecionarFocu(EditText editText) {
        editText.requestFocus();
    }
    private void limparCampos() {
        etDescricaoItem.setText("");
        etValorUnitItem.setText("");
    }
}
