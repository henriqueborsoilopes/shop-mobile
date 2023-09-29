package br.unipar.shop.controlador;

import java.util.List;

import br.unipar.shop.controlador.manipuladorExcessao.ManipuladorExcessao;
import br.unipar.shop.dto.ClienteDTO;
import br.unipar.shop.dto.ItemDTO;
import br.unipar.shop.servico.ItemServico;
import br.unipar.shop.servico.excessao.ObjetoNaoEncontradoExcessao;
import br.unipar.shop.servico.excessao.ValidacaoExcessao;

public class ItemControlador {
    private final ItemServico itemServico;
    public ItemControlador() {
        itemServico = new ItemServico();
    }
    public void salvarItem(ItemDTO dto) {
        try {
            itemServico.salvarItem(dto);
        } catch (ValidacaoExcessao e) {
            throw new ManipuladorExcessao().validacaoExcessaoManipulador(e);
        }
    }
    public List<ItemDTO> getListaItens() {
        return itemServico.getListaItens();
    }
    public ItemDTO getItem(String descricao) {
        try {
            return itemServico.getItem(descricao);
        } catch (ObjetoNaoEncontradoExcessao e) {
            throw new ManipuladorExcessao().objetoNaoEncontradoExcessaoManipulador(e);
        }
    }
}
