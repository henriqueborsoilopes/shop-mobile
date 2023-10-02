package br.unipar.shop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import br.unipar.shop.R;
import br.unipar.shop.controlador.PedidoControlador;
import br.unipar.shop.dto.ClienteDTO;
import br.unipar.shop.dto.PedidoDTO;

public class BuscarPedidoActivity extends AppCompatActivity {
    private TextView tvItem;
    private EditText etCodigoPedido;
    private Button btDetalhePedido;
    private final PedidoControlador pedidoControlador = new PedidoControlador();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_pedido);

        tvItem = findViewById(R.id.tvItem);
        etCodigoPedido = findViewById(R.id.etCodigoPedido);
        btDetalhePedido = findViewById(R.id.btDetalhePedido);

        btDetalhePedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivity(DetalhePedidoActivity.class);
            }
        });

        carregarListaPedidos();
    }
    private void carregarListaPedidos() {
        List<PedidoDTO> pedidoDTOList = pedidoControlador.getListaPedidos();
        String pedidos = "";
        for (PedidoDTO pedido : pedidoDTOList) {
            pedidos +=
                    "códido: " + pedido.getId().toString() + " | " +
                    "cliente: " + pedido.getCliente().getNome() + " | " +
                    "valor: " + pedido.getValorTotal().toString() + "\n";
        }
        tvItem.setText(pedidos);
    }
    private void abrirActivity(Class<?> activity) {
        Intent intent = new Intent(this, activity);
        intent.putExtra("pedidoId", new Long(etCodigoPedido.getText().toString()));
        startActivity(intent);
    }
}
