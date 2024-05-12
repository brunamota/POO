
package relacoes;

public class Venda {
    private Comprador comprador;
    private Vendedor vendedor;
    private String produto;

    public Venda(Comprador comprador, Vendedor vendedor, String produto) {
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.produto = produto;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public String getProduto() {
        return produto;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Venda{" + comprador + "\n" + vendedor + "\nProduto=" + produto + '}';
    }
}
