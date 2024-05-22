![Captura de tela 2024-05-22 190408](https://github.com/brunamota/POO/assets/66503956/d331cd6c-4bc2-4721-ba4d-02a574eb60bc)

- Código feito em sala
  - Interface
``` Java  
package clientes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Interface extends JFrame implements ActionListener{
    
    //atributos graficos da tela
    private JPanel pnDados, pnBotoes;
    private JLabel lbCodico, lbNome;
    private JTextField tfCodigo, tfNome;
    private JButton btCriar, btMostrar, btSair;
    private Container tela;
    
    Interface(){        
        
        //Criação do que vai conter na tela
        tela = this.getContentPane();
        tela.setLayout(new BorderLayout());
        
        //Instanciar Paineis
        pnDados = new JPanel();
        pnBotoes = new JPanel();
        
        //Adicionar paineis na tela
        tela.add(pnDados, BorderLayout.CENTER);
        tela.add(pnBotoes, BorderLayout.SOUTH);
       
        //mudar o fundo do painel
        pnBotoes.setBackground(Color.GRAY);
        
        //Configurando componentes
        lbCodico = new JLabel("Código do Cliente:");
        lbNome = new JLabel("Nome do Cliente:");
        
        tfCodigo = new JTextField(10);
        tfNome = new JTextField(30);
        
        btCriar = new JButton("Criar");
        btMostrar = new JButton("Mostrar");
        btSair = new JButton("Sair");
        
        pnDados.setLayout(new GridLayout(2,2));
        
        pnDados.add(lbCodico);
        pnDados.add(tfCodigo);

        pnDados.add(lbNome);
        pnDados.add(tfNome);
        
        pnBotoes.setLayout(new GridLayout(1,3));
        
        pnBotoes.add(btCriar);
        pnBotoes.add(btMostrar);
        pnBotoes.add(btSair);
        
        //Criação da tela
        this.setTitle("Cadastro de Clientes");
        this.setSize(400,120);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
                
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //quem realiza a ação
        if(e.getSource() == btSair){
            System.exit(0);
        }
    }
    
}
```
  - Cliente
``` Java
package clientes;

import java.util.ArrayList;
import java.util.List;

public class Clientes {
    
    static List<Cadastro>clientes = new ArrayList<Cadastro>();
    
    static void inserirCliente(String nome){
        Cadastro c = new Cadastro(nome);
        clientes.add(c);
    }

    public static void main(String[] args) {
          new Interface();
    }
}
```
  - Cadastro
```Java

package clientes;

public class Cadastro {
    
    //atributo da classe
    static int codClienteStatic = 1;
    
    //atributo objeto
    private int codCliente;
    private String nomeCliente;

    public Cadastro(){}
    
    public Cadastro(String nomeCliente) {
        this.codCliente = codClienteStatic++;
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
```
