package br.unipar.shop.controlador.manipuladorExcessao;

import br.unipar.shop.servico.excessao.ObjetoNaoEncontradoExcessao;
import br.unipar.shop.servico.excessao.ValidacaoExcessao;

public class ManipuladorExcessao {
    public ErroPadrao validacaoExcessaoManipulador(ValidacaoExcessao excessao) {
        return new ErroPadrao(excessao.getMessage(), 400);
    }
    public ErroPadrao objetoNaoEncontradoExcessaoManipulador(ObjetoNaoEncontradoExcessao excessao) {
        return new ErroPadrao(excessao.getMessage(), 404);
    }
}
