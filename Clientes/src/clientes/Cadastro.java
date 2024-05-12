
package clientes;

public class Cadastro {
    static int codClienteStatic = 0;
    private int codCliente;
    private String nomeCliente;

    public Cadastro(){}
    
    public Cadastro(String nomeCliente) {
        this.codCliente = ++codClienteStatic;
        this.nomeCliente = nomeCliente;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    @Override
    public String toString() {
        return "Cadastro{" + "Codigo =" + codCliente + ", Nome=" + nomeCliente + '}';
    }
    
    
}
