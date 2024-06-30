# Aula 15 - Relação entre objetos e classes – Threads Exemplo: uso do pacote gráfico Graphics na criação de animações

![Captura de tela 2024-06-30 192027](https://github.com/brunamota/POO/assets/66503956/ceae45a5-d07c-4db4-a1d5-16ea575762ec)

:white_check_mark:Criando o primeiro projeto - Gráfico2
  - Criando um pequeno relógio digital
  -  Conhecendo Threads
  -  Explorando a interface Runnable
  -  Conhecendo o método start (Thread().start())
  -  Conhecendo o método run

- Classe Desenho
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
- Classe Janela
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
- Classe Principal
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

- Classe Desenho
```Java

package exgraficot3;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

public class Desenho extends JComponent implements Runnable{
    
    private int forma;
    private Color cor;
    private int px = 5, py = 5;
    private int direcao = 1;

    public Desenho(int forma, Color cor) {
        this.forma = forma;
        this.cor = cor;
        new Thread(this).start();
       
    }

    public void setForma(int forma) {
        this.forma = forma;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public void setPx(int px) {
        this.px = px;
    }

    public void setPy(int py) {
        this.py = py;
    }
    
    @Override
    public void paint (Graphics g){
       g.setColor(cor);
       
       if (forma == 1){
           g.fillRect(px, py, 20, 20);
       }else if(forma == 2){
           g.fillOval(px, py, 20, 20);
       }
    }
    
    private void movimenta(){
        if(px > this.getWidth() - 25){
            direcao = 2;
        }
        if(px < 6){
            direcao = 1;
        }
        
        
        if(direcao == 1){
            px += 1;
        }else if(direcao == 2){
            px -= 1;
        }  
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(10);
                movimenta();
                repaint();
            } catch (InterruptedException ex) {
                Logger.getLogger(Desenho.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
```
- Classe Janela
```Java
package exgraficot3;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Janela extends JFrame implements KeyListener{

    private Desenho desenho;
    
    Janela() {
        
        desenho = new Desenho(1, Color.red);
        
        this.add(desenho);
        
        this.addKeyListener(this);

        this.setTitle("Desenho");
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            desenho.setForma(2);
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            desenho.setForma(1);
        }
        
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            desenho.setCor(Color.blue);
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            desenho.setCor(Color.red);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}

```

- Classe Principal
``` Java

package exgraficot3;

public class ExGraficoT3 {

    public static void main(String[] args) {
        new Janela().setVisible(true);
    }
    
}
```
