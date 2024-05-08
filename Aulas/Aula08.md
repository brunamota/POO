# Aula 8 - Modificadores de acesso, métodos e atributos estáticos, objetos como parâmetros, métodos que retornam objetos

### Modificadores de acesso

Os modificadores de acesso são palavras-chave que definem o nível de acesso aos membros (atributos e métodos) de uma classe. Os três principais modificadores de acesso são:
- public: os membros públicos podem ser acessados de qualquer lugar, tanto dentro como fora da classe.
- private: os membros privados só podem ser acessados de dentro da própria classe. Eles não são visíveis para outras classes.
- protected: os membros protegidos têm um nível de acesso intermediário. Eles podem ser acessados dentro da própria classe, em subclasses (herança) e em classes no mesmo pacote.

### Modificadores de Método
- abstract: Um método abstrato não possui implementação na classe em que é declarado. Ele deve ser implementado nas subclasses.
- final: Um método final não pode ser sobrescrito em subclasses. Ele mantém a implementação definida na classe em que é declarado.
- static: Atributos e métodos estáticos pertencem à classe em vez de pertencerem a instâncias individuais (objetos) da classe. Eles podem ser acessados diretamente usando o nome da classe, sem a necessidade de criar uma instância.
    - Atributo estático: É compartilhado por todas as instâncias da classe. Pode ser acessado usando o nome da classe, seguido pelo nome do atributo.
    - Método estático: Não requer uma instância da classe para ser invocado. Pode ser acessado usando o nome da classe, seguido pelo nome do método.

# Autoincremento

- Classe Cliente
``` Java


package clientes;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Clientes {
    
    //atributo estatico
    static List<Cadastro>clientes = new ArrayList<Cadastro>();
    
    //metodo estatico
    static void inserirCliente(String nome){
        Cadastro c = new Cadastro(nome);
        clientes.add(c);
    }
    
    public static void main(String[] args) {
        //Aparecer janela para digitar nome
        for(int i = 0; i < 5; i++){
            inserirCliente(JOptionPane.showInputDialog("Nome:"));
        }
        //Aparecer janela nomes digitados
        for(Cadastro cliente: clientes){
            JOptionPane.showMessageDialog(null, cliente);
        }
        
        System.out.println(clientes);
       
      //metodo anteriormente aprendido para instanciar um objeto
//    Cadastro c1 = new Cadastro("Bruna");
//    Cadastro c2 = new Cadastro("Marcos");
//    Cadastro c3 = new Cadastro("Wagner");
//
//    System.out.println(c1);
//    System.out.println(c2);
//    System.out.println(c3);
        
        
    }
    
}

```
- Classe Cadastro
```Java

package clientes;

public class Cadastro {
    
    //atributos
    private int codCliente;
    private String nomeCliente;
    
    //metodo estatico 
    static int codClienteStatic = 0;

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
        return "Cadastro{" + "Codigo: " + codCliente + ", Nome: " + nomeCliente + '}';
    }
    
    
    
}
```
