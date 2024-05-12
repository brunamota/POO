
package relacoes;


public class Relacoes {

    public static void main(String[] args) {
        
//        //Associação
//        Carro carro = new Carro("Prata", new Pneu(255, 60, 18));   
//        System.out.println(carro);
        
//        //Composição        
//        ContaCorrente contas[] = new ContaCorrente[2];
//        contas[0] = new ContaCorrente("001", 1050, 15000);
//        contas[1] = new ContaCorrente("002", 1060, 5000);
//        
//        ContaPoupanca poupanca[] = new ContaPoupanca[2];
//        poupanca[0] = new ContaPoupanca("001", 1115, 150000);
//        poupanca[1] = new ContaPoupanca("002", 1116, 500);
//        
//        Banco banco = new Banco("Banco do Brasil", contas, poupanca);
//   
//        System.out.println(banco);
        
        //Agregação
        
        Vendedor vendedor = new Vendedor(1,"Marcos Wagner");
        Comprador comprador = new Comprador(1, "Fulano");
        
        System.out.println(vendedor);
        System.out.println(comprador);
        
        Venda venda = new Venda(comprador, vendedor, "Sobonete");
        
        System.out.println(venda);
        
        venda = null;
        
        System.out.println(venda);
        
        System.out.println(vendedor);
        System.out.println(comprador);
    }  
}
