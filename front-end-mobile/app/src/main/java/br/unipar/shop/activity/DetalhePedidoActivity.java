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
    private TextView tvCodigo;
    private TextView tvCliente;
    private TextView tvQtdItem;
    private TextView tvValorTotal;
    private TextView tvFormaPagamento;
    private TextView tvParcelas;
    public Long pedidoId;
    private final PedidoControlador pedidoControlador = new PedidoControlador();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pedido);

        tvListaItens = findViewById(R.id.tvListaItens);
        tvCodigo = findViewById(R.id.tvCodigo);
        tvCliente = findViewById(R.id.tvCliente);
        tvQtdItem = findViewById(R.id.tvQtdItem);
        tvValorTotal = findViewById(R.id.tvValorTotal);
        tvFormaPagamento = findViewById(R.id.tvFormaPagamento);
        tvParcelas = findViewById(R.id.tvParcelas);

        Intent intent = getIntent();
        pedidoId = new Long(intent.getSerializableExtra("pedidoId").toString());

        carregarPedido();
    }
    private void carregarPedido() {
        PedidoDTO pedidoDTO = pedidoControlador.getPedido(pedidoId);
        String parcelas = "";
        String itens = "Itens do Pedido: \n";
        tvCodigo.setText("código: " + pedidoDTO.getId().toString());
        tvCliente.setText("cliente: " + pedidoDTO.getCliente().getNome());
        tvQtdItem.setText("quantiddade de item: " + pedidoDTO.getQuantidadeDeItem());
        tvValorTotal.setText("valor total: " + pedidoDTO.getValorTotal().toString());
        tvFormaPagamento.setText("forma de pagamento: " + pedidoDTO.getPagamento().getMeioPagamento());
        for (int i = 0; i < pedidoDTO.getPagamento().getQtdParcela(); i++) {
            parcelas += "   " + (i+1) + "º - parcela R$ " + pedidoDTO.getPagamento().getValorPorParcela() + "\n";
        }
        for (ItemPedidoDTO item : pedidoDTO.getItens()) {
            itens += " código: " + item.getId() +
                    "\n   Descrição: " + item.getDescricao() +
                    "\n   Quantidade: " + item.getQuantidade() +
                    "\n   Valor unitário: " + item.getPrecoUnit() +
                    "\n   Valor total: " + item.getTotal() + "\n";
        }
        tvListaItens.setText(itens);
        tvParcelas.setText(parcelas);
    }
}
