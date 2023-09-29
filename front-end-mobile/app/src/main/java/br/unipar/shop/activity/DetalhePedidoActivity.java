package br.unipar.shop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import br.unipar.shop.R;
import br.unipar.shop.controlador.PedidoControlador;
import br.unipar.shop.dto.ItemDTO;
import br.unipar.shop.dto.ItemPedidoDTO;
import br.unipar.shop.dto.PedidoDTO;
import br.unipar.shop.entidade.ItemPedido;

public class DetalhePedidoActivity extends AppCompatActivity {

    private TextView tvListaItens;
    public Long pedidoId;
    private final PedidoControlador pedidoControlador = new PedidoControlador();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pedido);

        tvListaItens = findViewById(R.id.tvListaItens);

        Intent intent = getIntent();
        pedidoId = new Long(intent.getSerializableExtra("pedidoId").toString());

        carregarPedido();
    }
    private void carregarPedido() {
        PedidoDTO pedidoDTO = pedidoControlador.getPedido(pedidoId);
        String itens = "";
        for (ItemPedidoDTO item : pedidoDTO.getItens()) {
            itens += item.getDescricao();
        }
        tvListaItens.setText(itens);
    }
}
