package br.unipar.shop.servico.validacao;

import br.unipar.shop.dto.ClienteDTO;
import br.unipar.shop.servico.excessao.ValidacaoExcessao;

public class ClienteValidacao {
    public static void clienteValidacao(ClienteDTO dto) {
        nomeValidacao(dto.getNome());
        cpfValidacao(dto.getCpf());
    }
    private static void nomeValidacao(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new ValidacaoExcessao("Campo nome é obrigatório");
        }
    }
    private static void cpfValidacao(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            throw new ValidacaoExcessao("Campo cpf é obrigatório");
        }
    }
}
