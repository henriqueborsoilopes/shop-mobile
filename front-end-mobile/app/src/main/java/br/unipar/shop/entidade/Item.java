package br.unipar.shop.entidade;

import java.util.Objects;

public class Item {
    private Long id;
    private String descricao;
    private Double valorUnit;
    public Item() { }
    public Item(Long id, String descricao, Double valorUnit) {
        this.id = id;
        this.descricao = descricao;
        this.valorUnit = valorUnit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Double getValorUnit() {
        return valorUnit;
    }
    public void setValorUnit(Double valorUnit) {
        this.valorUnit = valorUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id.equals(item.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
