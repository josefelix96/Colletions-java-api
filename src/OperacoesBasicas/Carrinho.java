package OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Item> itemCarrinho;

    public Carrinho() {
        this.itemCarrinho = new ArrayList<>();
    }

    public void adicionarItem(String descricao, double preco, int quantidade){
        Item item = new Item(descricao, preco, quantidade);
        this.itemCarrinho.add(item);
    }

    public void removerItem(String descricao){
        List<Item> itemParaRemover = new ArrayList<>();
        if (!itemCarrinho.isEmpty()) {
            for (Item i : itemCarrinho) {
                if (i.getDescricao().equalsIgnoreCase(descricao)) {
                    itemParaRemover.add(i);
                }
            }
            itemCarrinho.removeAll(itemParaRemover);
        } else {
            System.out.println("O carrinho está vazio!");
        }
    }

    public double calcularValorTotal(){
        double valorTotal = 0d;
        if (!itemCarrinho.isEmpty()) {
            for (Item item : itemCarrinho) {
                double valorItem = item.getPreco() * item.getQuantidade();
                valorTotal += valorItem;
            }
            return valorTotal;
        }else {
            throw new RuntimeException("O carrinho está vazio!");
        }
    }

    public void exibirItens(){
        if (!itemCarrinho.isEmpty()){
            System.out.println(this.itemCarrinho);
        }else {
            System.out.println("O carrinho está vazio!");
        }
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "itemCarrinho=" + itemCarrinho +
                '}';
    }

    public static void main(String[] args) {
        Carrinho carrinhoDeCompras = new Carrinho();

        // Adicionando itens ao carrinho
        carrinhoDeCompras.adicionarItem("Lápis", 2d, 3);
        carrinhoDeCompras.adicionarItem("Lápis", 2d, 3);
        carrinhoDeCompras.adicionarItem("Caderno", 35d, 1);
        carrinhoDeCompras.adicionarItem("Borracha", 2d, 2);

        // Exibindo os itens no carrinho
        carrinhoDeCompras.exibirItens();

        // Removendo um item do carrinho
        carrinhoDeCompras.removerItem("Lápis");

        // Exibindo os itens atualizados no carrinho
        carrinhoDeCompras.exibirItens();

        // Calculando e exibindo o valor total da compra
        System.out.println("O valor total da compra é = " + carrinhoDeCompras.calcularValorTotal());
    }
}
