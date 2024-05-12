
package relacoes;

public class Comprador {
    //atributos
    private int codigo;
    private String nome;
    
    //metodos

    public Comprador(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Comprador{" + "codigo=" + codigo + ", nome=" + nome + '}';
    }
}
