package br.unipar.shop.dto;

import java.util.ArrayList;
import java.util.List;

public class PedidoDTO {

    private Long id;
    private ClienteDTO cliente;
    private PagamentoDTO pagamento;
    private List<ItemPedidoDTO> itens = new ArrayList<>();
    public PedidoDTO() { }

    public PedidoDTO(Long id, ClienteDTO cliente, PagamentoDTO pagamento) {
        this.id = id;
        this.cliente = cliente;
        this.pagamento = pagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public ClienteDTO getCliente() {
        return cliente;
    }
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }
    public PagamentoDTO getPagamento() {
        return pagamento;
    }
    public void setPagamento(PagamentoDTO pagamento) {
        this.pagamento = pagamento;
    }
    public List<ItemPedidoDTO> getItens() {
        return itens;
    }
    public void addItem(ItemPedidoDTO item) {
        this.itens.add(item);
    }
    public Integer getQuantidadeDeItem() {
        return itens.size();
    }
    public Double getValorTotal() {
        Double total = 0.0;
        for (ItemPedidoDTO item : itens) {
            total += item.getTotal();
        }
        return total;
    }
}
