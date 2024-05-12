
package relacoes;

public class Banco {
    //atributos
    String nome;
    ContaCorrente contasCorrente[];
    ContaPoupanca contasPoupanca[];

    public Banco(String nome, ContaCorrente[] contasCorrente, ContaPoupanca[] contasPoupanca) {
        this.nome = nome;
        this.contasCorrente = contasCorrente;
        this.contasPoupanca = contasPoupanca;
    }

    @Override
    public String toString() {
        String correnteStr = "", poupancaStr = "";
        for(int i = 0;i< contasCorrente.length;i++){
           correnteStr = correnteStr +" "+contasCorrente[i].toString();
        }
        
        for(int i = 0;i< contasPoupanca.length;i++){
            poupancaStr = poupancaStr +" "+contasPoupanca[i].toString();
        }
        
        return "Banco{" + "nome = " + nome + "\ncontasCorrente=" + correnteStr + "\ncontasPoupanca=" + poupancaStr + '}';
    }
      
}

class Conta{
    String agencia;
    int numero;
    double saldo;

    public Conta(String agencia, int numero, double saldo) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
    }

    public String getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "\nConta{" + "agencia=" + agencia + ", numero=" + numero + ", saldo=" + saldo + '}';
    }
    
}

class ContaCorrente extends Conta{   
    ContaCorrente(String agencia, int numero, double saldo) {
        super(agencia, numero, saldo);
    }
    
}

class ContaPoupanca extends Conta{
   ContaPoupanca(String agencia, int numero, double saldo) {
        super(agencia, numero, saldo);
    }
    
}