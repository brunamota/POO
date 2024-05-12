# Aula 09 - Relacionamentos entre classes: composição, agregação e associação. Atribuição entre objetos, comparação de objetos

### Composição
Um trem **é formado por** 1 locomotivas e n vagões. Relacionamento tem-um. A classe trem precisa ter pelo menos 1 locomotiva para existir.
Para orientação a objeto, uma composição seria uma classe composta por outras. 

![composição](https://github.com/brunamota/POO/assets/66503956/ab2e5e19-1fd7-4375-bccd-88c9a35bc400)

### Agregação
Uma locomotiva (todo) **tem** um farol (parte), mas não deixa de existir caso não tenha o farol.
Para orientação a objeto, classe não depende de outra para existir.

![agregação](https://github.com/brunamota/POO/assets/66503956/23475506-fd40-4e08-985a-8e7e627d3727)

### Associação
Um trem **usa** uma estrada de ferro. A estrada não faz parte de trem, mas depende dela para funcionar.
Para orientação a objeto, o funcionamento da classe trem depende da classe estrada estar funcionando/liberada.

![associação](https://github.com/brunamota/POO/assets/66503956/7a6f5bf7-eb31-4ccc-baee-b6f8e50d2afa)
# Exercicio 8 -  Relações

``` Java

package relacoes;


public class Relacoes {

    public static void main(String[] args) {
        
        //Associação
        Carro carro = new Carro("Prata", new Pneu(255, 60, 18));   
        System.out.println(carro);
        
        //Composição        
        ContaCorrente contas[] = new ContaCorrente[2];
        contas[0] = new ContaCorrente("001", 1050, 15000);
        contas[1] = new ContaCorrente("002", 1060, 5000);
        
        ContaPoupanca poupanca[] = new ContaPoupanca[2];
        poupanca[0] = new ContaPoupanca("001", 1115, 150000);
        poupanca[1] = new ContaPoupanca("002", 1116, 500);
        
        Banco banco = new Banco("Banco do Brasil", contas, poupanca);
   
        System.out.println(banco);
        
        //Agregação
    }  
}


```

## a) Banco - Composição

```Java

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
```

## b) Carro - Associação
``` Java

package relacoes;

public class Carro {
    //atributos
    String cor;
    Pneu p1, p2, p3, p4;
    
    //metodos
    public Carro(String cor, Pneu pneu) {
        this.cor = cor;
        this.p1 = pneu;
        this.p2 = pneu;
        this.p3 = pneu;
        this.p4 = pneu;
    }

    public String getCor() {
        return cor;
    }

    public Pneu getP1() {
        return p1;
    }

    public Pneu getP2() {
        return p2;
    }

    public Pneu getP3() {
        return p3;
    }

    public Pneu getP4() {
        return p4;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setP1(Pneu p1) {
        this.p1 = p1;
    }

    public void setP2(Pneu p2) {
        this.p2 = p2;
    }

    public void setP3(Pneu p3) {
        this.p3 = p3;
    }

    public void setP4(Pneu p4) {
        this.p4 = p4;
    }

    @Override
    public String toString() {
        return "Carro{" + "cor=" + cor + ", p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + ", p4=" + p4 + '}';
    }      
}

class Pneu{
    //atributos
    private int largura;
    private int altura;
    private int aro;
    
    //metodos
    public Pneu(int largura, int altura, int aro) {
        this.largura = largura;
        this.altura = altura;
        this.aro = aro;
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    public int getAro() {
        return aro;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setAro(int aro) {
        this.aro = aro;
    }

    @Override
    public String toString() {
        return "Pneu{" + "largura=" + largura + ", altura=" + altura + ", aro=" + aro + '}';
    }   
    
}
```
## a) Venda - Agregação
- Vendedor
```Java

package relacoes;


public class Vendedor {
    //atributos
    private int codigo;
    private String nome;
    
    //metodos

    public Vendedor(int codigo, String nome) {
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
        return "Vendedor{" + "codigo=" + codigo + ", nome=" + nome + '}';
    }
    
}

```
- Comprador
```Java

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
```
- Venda
```Java

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

```
