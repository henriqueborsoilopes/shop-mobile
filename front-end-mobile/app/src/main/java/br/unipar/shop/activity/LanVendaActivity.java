package br.unipar.shop.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.unipar.shop.R;
import br.unipar.shop.controlador.ClienteControlador;
import br.unipar.shop.controlador.ItemControlador;
import br.unipar.shop.controlador.PedidoControlador;
import br.unipar.shop.controlador.manipuladorExcessao.ErroPadrao;
import br.unipar.shop.dto.ClienteDTO;
import br.unipar.shop.dto.ItemDTO;
import br.unipar.shop.dto.ItemPedidoDTO;
import br.unipar.shop.dto.PagamentoDTO;
import br.unipar.shop.dto.PedidoDTO;

public class LanVendaActivity extends AppCompatActivity {
    private String[] vectorClientes;
    private String[] quantidadeParcela;
    private Spinner snCliente;
    private AutoCompleteTextView actvItem;
    private EditText evCodItem;
    private EditText etValorUnitario;
    private EditText etQtdItem;
    private EditText etValorTotalItem;
    private TextView tvListaItens;
    private TextView tvQdtItem;
    private TextView tvValorTotalPedido;
    private TextView tvValorPorParcelas;
    private Spinner spParcelas;
    private RadioButton rbAvista;
    private RadioButton rbAprazo;
    private RadioGroup rgMeioPagamento;
    private Button btAddCarrinho;
    private Button btFinalizarPedido;
    private PedidoDTO pedidoDTO = new PedidoDTO();
    private ClienteDTO clienteDTO = new ClienteDTO();
    private PagamentoDTO pagamentoDTO = new PagamentoDTO();
    private ItemDTO itemDTO = new ItemDTO();
    private final ClienteControlador clienteControlador = new ClienteControlador();
    private final ItemControlador itemControlador = new ItemControlador();
    private final PedidoControlador pedidoControlador = new PedidoControlador();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanc_venda);

        etValorUnitario = findViewById(R.id.etValorUnitario);
        etQtdItem = findViewById(R.id.etQtdItem);
        etValorTotalItem = findViewById(R.id.etValorTotalItem);
        tvListaItens = findViewById(R.id.tvListaItens);
        tvQdtItem = findViewById(R.id.tvQdtItem);
        tvValorTotalPedido = findViewById(R.id.tvValorTotalPedido);
        tvValorPorParcelas = findViewById(R.id.tvValorPorParcelas);
        snCliente = findViewById(R.id.snCliente);
        spParcelas = findViewById(R.id.spParcelas);
        actvItem = findViewById(R.id.actvItem);
        evCodItem = findViewById(R.id.evCodItem);
        btAddCarrinho = findViewById(R.id.btAddCarrinho);
        btFinalizarPedido = findViewById(R.id.btFinalizarPedido);
        rgMeioPagamento = findViewById(R.id.rgMeioPagamento);
        rbAvista = findViewById(R.id.rbAvista);
        rbAprazo = findViewById(R.id.rbAprazo);

        carregarValoresIniciais();

        snCliente.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicao, long l) {
                if (posicao > 0) {
                    pesquisarCliente(posicao);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        actvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                pesquisarItem();
            }
        });

        etQtdItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getResultadoTotal();
            }
        });

        btAddCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btAddCarrinhoAcao();
            }
        });

        rgMeioPagamento.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == rbAvista.getId()) {
                    spParcelas.setEnabled(false);
                    atualizarParcelaComDesconto();
                    carregarParcelas();
                    mostrarParcelas();
                } else if (i == rbAprazo.getId()) {
                    spParcelas.setEnabled(true);
                }
            }
        });

        spParcelas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0) {
                    atualizarParcelaComAcrescimo();
                    atualizarPagamentoParcelas(i);
                    mostrarParcelas();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btFinalizarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarPedido();
            }
        });
    }
    private void carregarValoresIniciais() {
        carregarSpinnerCliente();
        carregarAutoCompleteTextViewItem();
        spParcelas.setEnabled(false);
        carregarParcelas();
        mudarMeioDePagamento("A vista");
    }
    private void carregarSpinnerCliente() {
        List<ClienteDTO> clientesDTO = clienteControlador.getListaClientes();
        vectorClientes = new String[clientesDTO.size() + 1];
        vectorClientes[0] = "Selecione o cliente";
        for (int i = 0; i < clientesDTO.size(); i++) {
            ClienteDTO clienteDTO = clientesDTO.get(i);
            vectorClientes[i+1] = clienteDTO.getNome();
        }
        ArrayAdapter adapterCliente = new ArrayAdapter(
                LanVendaActivity.this,
                android.R.layout.simple_dropdown_item_1line,
                vectorClientes);
        snCliente.setAdapter(adapterCliente);
    }
    private void pesquisarCliente(int posicao) {
        try {
            clienteDTO = clienteControlador.getCliente(vectorClientes[posicao]);
        } catch (ErroPadrao e) {
            Toast.makeText(LanVendaActivity.this, e.getMsg(), Toast.LENGTH_LONG).show();
        }
    }
    private void carregarAutoCompleteTextViewItem() {
        List<ItemDTO> itensDTO = itemControlador.getListaItens();
        String[] vectorItens = new String[itensDTO.size()];
        for (int i = 0; i < itensDTO.size(); i++) {
            ItemDTO itemDTO = itensDTO.get(i);
            vectorItens[i] = itemDTO.getDescricao();
        }
        ArrayAdapter adapterItem = new ArrayAdapter(
                LanVendaActivity.this,
                android.R.layout.simple_dropdown_item_1line,
                vectorItens);
        actvItem.setAdapter(adapterItem);
    }
    private void pesquisarItem() {
        try {
            itemDTO = itemControlador.getItem(actvItem.getText().toString());
            evCodItem.setText(itemDTO.getId().toString());
            etValorUnitario.setText(itemDTO.getValorUnit().toString());
        } catch (ErroPadrao e) {
            Toast.makeText(LanVendaActivity.this, e.getMsg(), Toast.LENGTH_LONG).show();
        }
    }
    private void getResultadoTotal() {
        if (!etQtdItem.getText().toString().isEmpty()) {
            etValorTotalItem.setText(String.valueOf(
                    new Integer(etQtdItem.getText().toString()) *
                            new Double(etValorUnitario.getText().toString())));
        } else {
            limparCampo(etValorTotalItem);
        }
    }
    private void btAddCarrinhoAcao() {
        if (itemDTO == null) {
            Toast.makeText(LanVendaActivity.this, "Escolha um Item", Toast.LENGTH_LONG).show();
            return;
        }
        pedidoDTO.addItem(new ItemPedidoDTO(itemDTO.getId(), new Integer(etQtdItem.getText().toString()), itemDTO.getDescricao(), itemDTO.getValorUnit()));
        mostrarItensDoPedido();
        mostrarQuantidadeItens();
        mostrarValorTotal();
        mostrarParcelas();
    }
    private void mostrarItensDoPedido() {
        String lista = "";
        for (ItemPedidoDTO item : pedidoDTO.getItens()) {
            lista += "     " +
                    item.getId() + "        " +
                    item.getDescricao() + "                     " +
                    item.getQuantidade() + "             " +
                    item.getPrecoUnit() + "              " +
                    item.getTotal() + "\n";
        }
        tvListaItens.setText(lista);
    }
    private void mostrarQuantidadeItens(){
        tvQdtItem.setText(pedidoDTO.getQuantidadeDeItem().toString());
    }
    private void mostrarValorTotal() {
        pagamentoDTO.setValorTotal(pedidoDTO.getValorTotal());
        tvValorTotalPedido.setText(pedidoDTO.getValorTotal().toString());
    }
    private void mudarMeioDePagamento(String meioDePagamento) {
        pagamentoDTO.setMeioPagamento(meioDePagamento);
    }
    private void atualizarParcelaComDesconto() {

    }
    private void atualizarParcelaComAcrescimo() {

    }
    private void carregarParcelas() {
        quantidadeParcela = new String[]{"1", "2", "3", "4", "5"};
        ArrayAdapter adapterItem = new ArrayAdapter(
                LanVendaActivity.this,
                android.R.layout.simple_dropdown_item_1line,
                quantidadeParcela);
        spParcelas.setAdapter(adapterItem);
        atualizarPagamentoParcelas(0);
    }
    private void atualizarPagamentoParcelas(int i) {
        pagamentoDTO.setQtdParcela(new Integer(quantidadeParcela[i].toString()));
    }
    private void mostrarParcelas() {
        if (pagamentoDTO.getValorTotal() == null) {
            return;
        }
        String parcelas = "";
        Double valorParcela = pagamentoDTO.getValorPorParcela();
        for (int i = 0; i < pagamentoDTO.getQtdParcela(); i++) {
            parcelas += (i + 1) + "º - R$ " + valorParcela + "\n";
        }
        tvValorPorParcelas.setText(parcelas);
    }
    private void salvarPedido() {
        if (clienteDTO.getId() == null) {
            Toast.makeText(LanVendaActivity.this, "Selecione um Cliente", Toast.LENGTH_LONG).show();
        }
        try {
            pedidoDTO.setCliente(clienteDTO);
            pedidoDTO.setPagamento(pagamentoDTO);
            pedidoControlador.salvarPedido(pedidoDTO);
            Toast.makeText(LanVendaActivity.this, "Pedido Salvo com Sucesso!", Toast.LENGTH_LONG).show();
        } catch (ErroPadrao e) {
            Toast.makeText(LanVendaActivity.this, e.getMsg(), Toast.LENGTH_LONG).show();
        }
    }
    private void limparCampo(EditText et) {
        et.setText("");
    }
}
