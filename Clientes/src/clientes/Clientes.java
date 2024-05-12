
package clientes;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Clientes {
    
    static List<Cadastro>clientes = new ArrayList<Cadastro>();
    
    static void inserirCliente(String nome){
        Cadastro c = new Cadastro(nome);
        clientes.add(c);
    }
    
    public static void main(String[] args) {
       
        for(int i=0; i<3; i++){
            inserirCliente(JOptionPane.showInputDialog("Nome:"));
        }
       
        for(Cadastro cliente: clientes){
            JOptionPane.showMessageDialog(null, cliente);
        }
        
        System.out.println(clientes);
    }
    
}
