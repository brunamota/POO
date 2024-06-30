# Aula 15 - Relação entre objetos e classes – Threads Exemplo: uso do pacote gráfico Graphics na criação de animações

![Captura de tela 2024-06-30 192027](https://github.com/brunamota/POO/assets/66503956/ceae45a5-d07c-4db4-a1d5-16ea575762ec)

:white_check_mark:Criando o primeiro projeto - Gráfico2
  - Criando um pequeno relógio digital
  -  Conhecendo Threads
  -  Explorando a interface Runnable
  -  Conhecendo o método start (Thread().start())
  -  Conhecendo o método run

``` Java
package exgraficot2;

import java.awt.Font;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

public class Desenho extends JComponent implements Runnable{
    
    private Calendar hora;
    
    Desenho(){
        new Thread(this).start();
    }
    
    public void paint (Graphics g){
        g.setFont(new Font("Calibri",Font.BOLD, 19));
        g.drawString(horas(), 25, 25);
    }
    
    private String horas(){
        hora = Calendar.getInstance();
        int hh = hora.get(Calendar.HOUR_OF_DAY);
        int mm = hora.get(Calendar.MINUTE);
        int ss = hora.get(Calendar.SECOND);
        
        return ((hh < 10)? "0":"")+ hh +":"+
               ((mm < 10)? "0":"")+ mm +":"+
               ((ss < 10)? "0":"")+ ss;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
                repaint();
            } catch (InterruptedException ex) {
                Logger.getLogger(Desenho.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    }
    
}
```

```Java

package exgraficot2;

import javax.swing.JFrame;

public class Janela extends JFrame{
    
    Janela(){
        
        this.add(new Desenho());
        
        this.setSize(80,80);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    }
}
```

```Java

package exgraficot2;

public class ExGraficoT2 {

    public static void main(String[] args) {
        new Janela().setVisible(true);
    }
    
}
```
 
:white_check_mark: Criando uma aplicação animada e interativa
  -  Criando os atributos Forma, Cor, Posição e Direção
  -  Criando um método para movimentação
  -  Usando Threads
