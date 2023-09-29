package br.unipar.shop.controlador;

import java.util.List;

import br.unipar.shop.controlador.manipuladorExcessao.ManipuladorExcessao;
import br.unipar.shop.dto.ClienteDTO;
import br.unipar.shop.servico.ClienteServico;
import br.unipar.shop.servico.excessao.ObjetoNaoEncontradoExcessao;
import br.unipar.shop.servico.excessao.ValidacaoExcessao;

public class ClienteControlador {
    private final ClienteServico clienteServico;
    public ClienteControlador() {
        this.clienteServico = new ClienteServico();
    }
    public void salvarCliente(ClienteDTO dto) {
        try {
            clienteServico.salvarCliente(dto);
        } catch (ValidacaoExcessao e) {
            throw new ManipuladorExcessao().validacaoExcessaoManipulador(e);
        }
    }
    public List<ClienteDTO> getListaClientes() {
        return clienteServico.getListaClientes();
    }
    public ClienteDTO getCliente(String nome) {
        try {
            return clienteServico.getCliente(nome);
        } catch (ObjetoNaoEncontradoExcessao e) {
            throw new ManipuladorExcessao().objetoNaoEncontradoExcessaoManipulador(e);
        }
    }
}
