package br.unipar.shop.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.unipar.shop.entidade.Item;

public class ItemRepositorio {
    private static List<Item> itens;
    public ItemRepositorio() {
        if (itens == null) {
            itens = new ArrayList<>();
        }
    }
    public Long getQtdPosicoesLista() {
        return new Long(itens.size() + 1);
    }
    public void savarItem(Item item) {
        itens.add(item);
    }
    public List<Item> getListaItens() {
        return itens;
    }
    public Optional<Item> getItem(String descricao) {
        for (Item item : itens) {
            if (item.getDescricao().equals(descricao)) {
                return Optional.of(item);
            }
        }
        return null;
    }
}
