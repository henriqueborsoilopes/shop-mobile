package br.unipar.shop.controlador.manipuladorExcessao;

public class ErroPadrao extends RuntimeException {

    private String msg;
    private Integer cod;

    public ErroPadrao() { }

    public ErroPadrao(String msg, Integer cod) {
        this.msg = msg;
        this.cod = cod;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }
}
