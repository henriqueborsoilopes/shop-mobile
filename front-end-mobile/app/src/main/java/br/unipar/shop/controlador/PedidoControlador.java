package br.unipar.shop.controlador;

import java.util.List;

import br.unipar.shop.controlador.manipuladorExcessao.ManipuladorExcessao;
import br.unipar.shop.dto.ClienteDTO;
import br.unipar.shop.dto.PedidoDTO;
import br.unipar.shop.servico.ClienteServico;
import br.unipar.shop.servico.PedidoServico;
import br.unipar.shop.servico.excessao.ObjetoNaoEncontradoExcessao;
import br.unipar.shop.servico.excessao.ValidacaoExcessao;

public class PedidoControlador {
    private final PedidoServico pedidoServico;
    public PedidoControlador() {
        this.pedidoServico = new PedidoServico();
    }
    public void salvarPedido(PedidoDTO dto) {
        try {
            pedidoServico.salvarPedido(dto);
        } catch (ValidacaoExcessao e) {
            throw new ManipuladorExcessao().validacaoExcessaoManipulador(e);
        }
    }
    public List<PedidoDTO> getListaPedidos() {
        return pedidoServico.getListaPedidos();
    }
    public PedidoDTO getPedido(Long id) {
        try {
            return pedidoServico.getPedido(id);
        } catch (ObjetoNaoEncontradoExcessao e) {
            throw new ManipuladorExcessao().objetoNaoEncontradoExcessaoManipulador(e);
        }
    }
}
