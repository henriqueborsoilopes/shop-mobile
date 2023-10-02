package br.unipar.shop.entidade;

import java.util.Objects;

public class Pagamento {
    private Long id;
    private String meioPagamento;
    private Integer qtdParcela;
    private Double valorAcrescimo;
    private Double valorDesconto;
    private Double valorTotal;

    public Pagamento() { }

    public Pagamento(Long id, String meioPagamento, Integer qtdParcela, Double valorAcrescimo, Double valorDesconto, Double valorTotal) {
        this.id = id;
        this.meioPagamento = meioPagamento;
        this.qtdParcela = qtdParcela;
        this.valorAcrescimo = valorAcrescimo;
        this.valorDesconto = valorDesconto;
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
    public Double getValorAcrescimo() {
        return valorAcrescimo;
    }
    public void setValorAcrescimo(Double valorAcrescimo) {
        this.valorAcrescimo = valorAcrescimo;
    }
    public Double getValorDesconto() {
        return valorDesconto;
    }
    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }
    public Double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return id.equals(pagamento.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
