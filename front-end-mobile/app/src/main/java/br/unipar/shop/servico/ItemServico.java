package br.unipar.shop.servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.unipar.shop.dto.ItemDTO;
import br.unipar.shop.entidade.Item;
import br.unipar.shop.repositorio.ItemRepositorio;
import br.unipar.shop.servico.excessao.ObjetoNaoEncontradoExcessao;
import br.unipar.shop.servico.validacao.ItemValidacao;

public class ItemServico {
    private final ItemRepositorio itemRepositorio;
    public ItemServico() {
        itemRepositorio = new ItemRepositorio();
    }
    public void salvarItem(ItemDTO dto) {
        ItemValidacao.itemValidacao(dto);
        Item item = new Item(itemRepositorio.getQtdPosicoesLista(), dto.getDescricao(), dto.getValorUnit());
        itemRepositorio.savarItem(item);
    }
    public List<ItemDTO> getListaItens() {
        List<ItemDTO> dtos = new ArrayList<>();
        for (Item entidade : itemRepositorio.getListaItens()) {
            dtos.add(new ItemDTO(entidade.getId(), entidade.getDescricao(), entidade.getValorUnit()));
        }
        return dtos;
    }
    public ItemDTO getItem(String descricao) {
        Optional<Item> item = itemRepositorio.getItem(descricao);
        if (item == null) {
            throw new ObjetoNaoEncontradoExcessao("Item não encontrado");
        }
        return new ItemDTO(item.get().getId(), item.get().getDescricao(), item.get().getValorUnit());
    }
}
