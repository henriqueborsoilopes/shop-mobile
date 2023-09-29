package br.unipar.shop.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.unipar.shop.entidade.Cliente;
import br.unipar.shop.entidade.Pedido;

public class PedidoRepositorio {
    private static List<Pedido> pedidos;
    public PedidoRepositorio() {
        if (pedidos == null) {
            pedidos = new ArrayList<>();
        }
    }
    public Long getQtdPosicoesLista() {
        return new Long(pedidos.size() + 1);
    }
    public void salvarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
    public List<Pedido> getListaPedido() {
        return pedidos;
    }
    public Pedido getPedido(Long pedidoId) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId().equals(pedidoId)) {
                return pedido;
            }
        }
        return null;
    }
}
