package br.unipar.shop.servico;

import java.util.ArrayList;
import java.util.List;

import br.unipar.shop.dto.PedidoDTO;
import br.unipar.shop.entidade.Pedido;
import br.unipar.shop.repositorio.PedidoRepositorio;
import br.unipar.shop.servico.excessao.ObjetoNaoEncontradoExcessao;
import br.unipar.shop.servico.mapeadorEntidade.PedidoMapeador;
import br.unipar.shop.servico.validacao.PedidoValidacao;

public class PedidoServico {

    private final PedidoRepositorio pedidoRepositorio;

    public PedidoServico() {
        this.pedidoRepositorio = new PedidoRepositorio();
    }

    public void salvarPedido(PedidoDTO dto) {
        PedidoValidacao.pedidoValidacao(dto);
        Pedido pedido = PedidoMapeador.deDTO(dto);
        pedido.setId(pedidoRepositorio.getQtdPosicoesLista());
        pedidoRepositorio.salvarPedido(pedido);
    }

    public List<PedidoDTO> getListaPedidos() {
        List<PedidoDTO> dtos = new ArrayList<>();
        for (Pedido entidade : pedidoRepositorio.getListaPedido()) {
            PedidoDTO dto = PedidoMapeador.paraDTO(entidade);
            dtos.add(dto);
        }
        return dtos;
    }

    public PedidoDTO getPedido(Long id) {
        Pedido pedido = pedidoRepositorio.getPedido(id);
        if (pedido == null) {
            throw new ObjetoNaoEncontradoExcessao("Pedido não encontrado!");
        }
        return PedidoMapeador.paraDTO(pedido);
    }
}
