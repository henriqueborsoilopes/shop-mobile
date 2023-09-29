package br.unipar.shop.dto;

public class PagamentoDTO {

    private Long id;
    private String meioPagamento;
    private Integer qtdParcela;
    private Double valorTotal;

    public PagamentoDTO() { }

    public PagamentoDTO(Long id, String meioPagamento, Integer qtdParcela, Double valorTotal) {
        this.id = id;
        this.meioPagamento = meioPagamento;
        this.qtdParcela = qtdParcela;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeioPagamento() {
        return meioPagamento;
    }

    public void setMeioPagamento(String meioPagamento) {
        this.meioPagamento = meioPagamento;
    }

    public Integer getQtdParcela() {
        return qtdParcela;
    }

    public void setQtdParcela(Integer qtdParcela) {
        this.qtdParcela = qtdParcela;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public Double getValorPorParcela() {
        return getValorTotal() / getQtdParcela();
    }
}
