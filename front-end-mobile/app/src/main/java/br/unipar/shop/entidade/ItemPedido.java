package br.unipar.shop.entidade;

import java.util.Objects;

public class ItemPedido {
    private Long id;
    private Integer quantidade;
    private String descricao;
    private Double precoUnit;

    public ItemPedido() { }

    public ItemPedido(Long id, Integer quantidade, String descricao, Double precoUnit) {
        this.id = id;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.precoUnit = precoUnit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(Double precoUnit) {
        this.precoUnit = precoUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
