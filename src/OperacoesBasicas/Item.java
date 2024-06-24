package OperacoesBasicas;

public class Item {
    private String descricao;
    private double preco;
    private int quantidade;

    public Item(String descricao, double preco, int quantidade) {
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "Item{" +
                "Nome: " + descricao + '\'' +
                ", preco: " + preco +
                ", quantidade: " + quantidade +
                '}';
    }
}
