package br.unipar.shop.servico.excessao;

public class ObjetoNaoEncontradoExcessao extends RuntimeException {
    public ObjetoNaoEncontradoExcessao(String msg) {
        super(msg);
    }
}
