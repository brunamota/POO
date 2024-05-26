# Aula 11 - Interfaces Gráficas de gerenciamento de dados

Alteração na interface de cadastro para que ela fique mais para o cliente e os cadastros comece a armazená-los.

![Captura de tela 2024-05-26 173719](https://github.com/brunamota/POO/assets/66503956/2aa310c9-872c-4254-93d5-ecac620c71d2)

:white_check_mark: Excluímos o botão Criar

:heavy_check_mark: Foi acrescentado o botão Novo para que ele limpe os campos preenchidos quando for adicionar um novo cliente.

:heavy_check_mark: Foi acrescentado o botão Inserir para a criação de objetos, substituiu o Criar.

:heavy_check_mark: Foi implementado um método inserirClientes() para armazená-los em uma lista.

:heavy_check_mark: Foi implementado um método mostrarClientes() para visualizá-los de forma individual.

:heavy_check_mark: Ajustamos o campo Código Cliente para não ser alterado pelo usuário e ele seja mostrado em todo objeto criado.

## Código desenvolvido
Obs.: Os códigos desenvolvidos em sala estão utilizando o GUI (Graphical User Interface) do NetBeans, os códigos abaixo são para a criação da mesma tela, mas de forma manual apenas usando os pacotes AWT e SWING. Outras IDEs tem a mesma ferramenta, só precisam ser configuradas.
- Inteface 
```Java

package clientes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Interface extends JFrame implements ActionListener{
    
    //atributos graficos da tela
    private JPanel pnDados, pnBotoes;
    private JLabel lbCodico, lbNome;
    private JTextField tfCodigo, tfNome;
    private JButton btNovo, btMostrar, btSair, btInserir;
    private Container tela;
    
    private List<Cadastro> clientes = new ArrayList<>();
    
    private Cadastro cadastro = new Cadastro();
    
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
        
        btNovo = new JButton("Novo");
        btInserir = new JButton("Inserir");
        btMostrar = new JButton("Mostrar");
        btSair = new JButton("Sair");  
        
        pnDados.setLayout(new GridLayout(2,2));
        
        pnDados.add(lbCodico);
        pnDados.add(tfCodigo);

        pnDados.add(lbNome);
        pnDados.add(tfNome);
        
        pnBotoes.setLayout(new GridLayout(1,4));
        
        pnBotoes.add(btNovo);
        pnBotoes.add(btInserir);
        pnBotoes.add(btMostrar);
        pnBotoes.add(btSair);
        
        //Evento dos botoes
        btSair.addActionListener(this);
        btMostrar.addActionListener(this);
        btNovo.addActionListener(this);
        btInserir.addActionListener(this);

        //impede o usuário a alterar o campo Código Cliente
        tfCodigo.setEditable(false);
        
        //Criação da tela
        this.setTitle("Cadastro de Clientes");
        this.setSize(400,120);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
                
    }
    
    private void inserirClientes(){
        clientes.add(cadastro);
    }
    
    private void mostrarCliente(Cadastro cadastro){
        for(Cadastro cliente: clientes){
            JOptionPane.showMessageDialog(null, cliente);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //quem realiza a ação
        if(e.getSource() == btSair){
            System.exit(0);
        }
        if(e.getSource() == btNovo){
            tfCodigo.setText("");
            tfNome.setText("");
        }
        if(e.getSource() == btMostrar){
            mostrarCliente(cadastro);
        }      
        if(e.getSource() == btInserir){
            tfCodigo.setText(Integer.toString(cadastro.getCodCliente()));
            JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso");
            cadastro = new Cadastro(tfNome.getText());
            inserirClientes();
        }
    }
}
```

- Cliente (main)
```Java
package clientes;

public class Clientes {
    
    public static void main(String[] args) {

          new Interface();

    }
    
}
```
- Cadastro (nada da última aula foi alterado nele)
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
