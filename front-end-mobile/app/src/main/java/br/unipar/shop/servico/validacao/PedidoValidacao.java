package br.unipar.shop.servico.validacao;

import br.unipar.shop.dto.ItemDTO;
import br.unipar.shop.dto.PedidoDTO;
import br.unipar.shop.entidade.Pedido;
import br.unipar.shop.servico.excessao.ValidacaoExcessao;

public class PedidoValidacao {
    public static void pedidoValidacao(PedidoDTO pedido) {
    }
    private static void descricaoValidacao(String descricao) {
        if (descricao == null || descricao.isEmpty()) {
            throw new ValidacaoExcessao("Campo descrição é obrigatório");
        }
    }
    private static void valorUnitValidacao(Double valorUnit) {
        if (valorUnit == null || valorUnit <= 0.0) {
            throw new ValidacaoExcessao("Valor unitário inválido");
        }
    }
}
