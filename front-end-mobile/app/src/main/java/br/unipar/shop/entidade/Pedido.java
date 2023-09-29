package br.unipar.shop.entidade;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.unipar.shop.dto.ItemPedidoDTO;
import br.unipar.shop.dto.PagamentoDTO;

public class Pedido {
    private Long id;
    private Cliente cliente;
    private Pagamento pagamento;
    private List<ItemPedido> itens = new ArrayList<>();
    public Pedido() { }
    public Pedido(Long id, Cliente cliente, Pagamento pagamento) {
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
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Pagamento getPagamento() {
        return pagamento;
    }
    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
    public List<ItemPedido> getItens() {
        return itens;
    }
    public void addItens(ItemPedido item) {
        this.itens.add(item);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return id.equals(pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
