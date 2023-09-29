package br.unipar.shop.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.unipar.shop.entidade.Cliente;

public class ClienteRepositorio {
    private static List<Cliente> clientes;
    public ClienteRepositorio() {
        if (clientes == null) {
           clientes = new ArrayList<>();
        }
    }
    public Long getQtdPosicoesLista() {
        return new Long(clientes.size() + 1);
    }
    public void salvarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    public List<Cliente> getListaCliente() {
        return clientes;
    }
    public Cliente getCliente(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                return cliente;
            }
        }
        return null;
    }
}
