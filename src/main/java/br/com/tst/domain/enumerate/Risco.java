package br.com.tst.domain.enumerate;

public enum Risco {
    ALTO("ALto"),
    MEDIO("Médio"),
    BAIXO("Baixo");

    private String descricao;

    Risco(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
