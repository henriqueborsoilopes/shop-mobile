package br.unipar.shop.servico;

import java.util.ArrayList;
import java.util.List;

import br.unipar.shop.dto.ClienteDTO;
import br.unipar.shop.entidade.Cliente;
import br.unipar.shop.repositorio.ClienteRepositorio;
import br.unipar.shop.servico.excessao.ObjetoNaoEncontradoExcessao;
import br.unipar.shop.servico.excessao.ValidacaoExcessao;
import br.unipar.shop.servico.validacao.ClienteValidacao;

public class ClienteServico {

    private final ClienteRepositorio clienteRepositorio;

    public ClienteServico() {
        this.clienteRepositorio = new ClienteRepositorio();
    }

    public void salvarCliente(ClienteDTO dto) {
        ClienteValidacao.clienteValidacao(dto);
        clienteRepositorio.salvarCliente(new Cliente(
                clienteRepositorio.getQtdPosicoesLista(),
                dto.getNome(),
                dto.getCpf()
        ));
    }

    public List<ClienteDTO> getListaClientes() {
        List<ClienteDTO> dtos = new ArrayList<>();
        for (Cliente entidade : clienteRepositorio.getListaCliente()) {
            ClienteDTO dto = new ClienteDTO(entidade.getId(), entidade.getNome(), entidade.getCpf());
            dtos.add(dto);
        }
        return dtos;
    }

    public ClienteDTO getCliente(String nome) {
        Cliente cliente = clienteRepositorio.getCliente(nome);
        if (cliente == null) {
            throw new ObjetoNaoEncontradoExcessao("Cliente não encontrado!");
        }
        return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getCpf());
    }
}
