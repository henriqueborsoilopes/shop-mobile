package br.unipar.shop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import br.unipar.shop.R;
import br.unipar.shop.controlador.PedidoControlador;
import br.unipar.shop.dto.ClienteDTO;
import br.unipar.shop.dto.PedidoDTO;

public class BuscarPedidoActivity extends AppCompatActivity {
    private ListView lvPedidos;
    private List<String> pedidoDescricao = new ArrayList<>();
    private final PedidoControlador pedidoControlador = new PedidoControlador();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_pedido);

        lvPedidos = findViewById(R.id.lvPedidos);

        carregarListaPedidos();
    }
    private void carregarListaPedidos() {
        List<PedidoDTO> pedidoDTOList = pedidoControlador.getListaPedidos();
        for (PedidoDTO pedido : pedidoDTOList) {
            pedidoDescricao.add(pedido.getId().toString());
        }
        ArrayAdapter adapterCliente = new ArrayAdapter(
                BuscarPedidoActivity.this,
                android.R.layout.simple_dropdown_item_1line,
                pedidoDescricao);
        lvPedidos.setAdapter(adapterCliente);
    }
}
