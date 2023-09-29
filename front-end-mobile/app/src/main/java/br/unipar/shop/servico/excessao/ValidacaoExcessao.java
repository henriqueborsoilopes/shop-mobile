package br.unipar.shop.servico.excessao;

public class ValidacaoExcessao extends RuntimeException {
    public ValidacaoExcessao(String msg) {
        super(msg);
    }
}
