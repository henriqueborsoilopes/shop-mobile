package br.unipar.shop.servico.mapeadorEntidade;

import br.unipar.shop.dto.ClienteDTO;
import br.unipar.shop.dto.ItemPedidoDTO;
import br.unipar.shop.dto.PagamentoDTO;
import br.unipar.shop.dto.PedidoDTO;
import br.unipar.shop.entidade.Cliente;
import br.unipar.shop.entidade.ItemPedido;
import br.unipar.shop.entidade.Pagamento;
import br.unipar.shop.entidade.Pedido;

public class PedidoMapeador {
    public static PedidoDTO paraDTO(Pedido pedido) {
        PedidoDTO dto = new PedidoDTO(pedido.getId(),
                new ClienteDTO(pedido.getCliente().getId(), pedido.getCliente().getNome(), pedido.getCliente().getCpf()),
                new PagamentoDTO(pedido.getPagamento().getId(), pedido.getPagamento().getMeioPagamento(), pedido.getPagamento().getQtdParcela(), pedido.getPagamento().getValorTotal()));
        for (ItemPedido item : pedido.getItens()) {
            dto.addItem(new ItemPedidoDTO(item.getId(), item.getQuantidade(), item.getDescricao(), item.getPrecoUnit()));
        }
        return dto;
    }
    public static Pedido deDTO(PedidoDTO dto) {
        Pedido entidade = new Pedido(dto.getId(),
                new Cliente(dto.getCliente().getId(), dto.getCliente().getNome(), dto.getCliente().getCpf()),
                new Pagamento(dto.getPagamento().getId(), dto.getPagamento().getMeioPagamento(), dto.getPagamento().getQtdParcela(), dto.getPagamento().getValorTotal()));
        for (ItemPedidoDTO item : dto.getItens()) {
            entidade.addItens(new ItemPedido(item.getId(), item.getQuantidade(), item.getDescricao(), item.getPrecoUnit()));
        }
        return entidade;
    }
}
