package br.unipar.shop.dto;

public class ItemPedidoDTO {

    private Long id;
    private Integer quantidade;
    private String descricao;
    private Double precoUnit;
    public ItemPedidoDTO() { }

    public ItemPedidoDTO(Long id, Integer quantidade, String descricao, Double precoUnit) {
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
    public Double getTotal() {
        return getQuantidade() * getPrecoUnit();
    }
}
