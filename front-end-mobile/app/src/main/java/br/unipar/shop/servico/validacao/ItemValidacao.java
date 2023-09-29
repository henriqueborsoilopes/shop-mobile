package br.unipar.shop.servico.validacao;

import br.unipar.shop.dto.ClienteDTO;
import br.unipar.shop.dto.ItemDTO;
import br.unipar.shop.servico.excessao.ValidacaoExcessao;

public class ItemValidacao {
    public static void itemValidacao(ItemDTO dto) {
        descricaoValidacao(dto.getDescricao());
        valorUnitValidacao(dto.getValorUnit());
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
