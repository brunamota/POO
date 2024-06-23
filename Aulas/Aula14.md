# Aula 14 - Relação entre objetos e classes - Modulos Exemplo: uso do pacote gráfico Graphics na criação de gráficos

Aplicação desenvolvida em sala para conhecer a classe Graphics e conseguir desenhar na tela.

![Captura de tela 2024-06-23 202933](https://github.com/brunamota/POO/assets/66503956/5a5e7fb0-1114-4c45-8a01-e5041ea8a008)
![Captura de tela 2024-06-23 202944](https://github.com/brunamota/POO/assets/66503956/0a09ab3d-54de-4815-b886-ea240d1a90a3)

:white_check_mark: Criando o projeto Grafico1 com as classes:
  - Grafico1
  - Janela
  - Desenho
    
:white_check_mark: Explorando o componente JComponent

:white_check_mark: Explorando o método paint de JComponent

:white_check_mark: Conhecendo e usando a classe Graphics

:white_check_mark: Criando os atributos forma (retângulo - circunferência - triângulo) e cor (vermelhor - verde - azul)

:white_check_mark: Criando setters/getters para forma e cor

:white_check_mark: Adicionando um Componente Gráfico na janela

:white_check_mark: Criando um PopupMenu para escolha de opções

## Codigo desenvolvido

Clasee principal

``` java

package graficot1;

public class GraficoT1 {

    public static void main(String[] args) {
        new Janela();
    }
    
}
```

Classe Janela

```Java
package graficot1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class Janela extends JFrame implements ActionListener, MouseListener {
    
    private JPopupMenu puMenu;

    private JMenu menuForma;
    private JMenu menuCor;

    private JMenuItem itemForma1;
    private JMenuItem itemForma2;
    private JMenuItem itemForma3;

    private JMenuItem itemCor1;
    private JMenuItem itemCor2;
    private JMenuItem itemCor3;
    
    private int tipoForma;
    private int tipoCor;
    private Desenho desenho;
    
    Janela() {
        
        puMenu = new JPopupMenu();
        menuForma = new JMenu("Forma");
        menuCor = new JMenu("Cor");
        
        itemForma1 = new JMenuItem("Triangulo");
        itemForma2 = new JMenuItem("Retangulo");
        itemForma3 = new JMenuItem("Circulo");
        
        itemCor1 = new JMenuItem("Vermelho");
        itemCor2 = new JMenuItem("Azul");
        itemCor3 = new JMenuItem("Verde");

        menuForma.add(itemForma1);
        menuForma.add(itemForma2);
        menuForma.add(itemForma3);

        menuCor.add(itemCor1);
        menuCor.add(itemCor2);
        menuCor.add(itemCor3);

        puMenu.add(menuForma);
        puMenu.add(menuCor);
        
        this.addMouseListener(this);
        itemForma1.addActionListener(this);
        itemForma2.addActionListener(this);
        itemForma3.addActionListener(this);
        
        itemCor1.addActionListener(this);
        itemCor2.addActionListener(this);
        itemCor3.addActionListener(this);

        desenho = new Desenho(tipoForma, tipoCor);
        this.add(desenho);

        this.setTitle("Desenho");
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == itemForma1){
            tipoForma = 1;
        }
        else if(e.getSource() == itemForma2){
            tipoForma = 2;
        }
        else if(e.getSource() == itemForma3){
            tipoForma = 3;
        }
        if(e.getSource() == itemCor1){
            tipoCor = 1;
        }        
        else if(e.getSource() == itemCor2){
            tipoCor = 2;
        }       
        else if(e.getSource() == itemCor3){
            tipoCor = 3;
        }
        
        desenho.setTipoForma(tipoForma);
        desenho.setTipoCor(tipoCor);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON3){
            puMenu.show(this, e.getX(), e.getY());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
```

Classe Desenho

```Java

package graficot1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JComponent;

public class Desenho extends  JComponent{
    
    private int tipoForma;
    private int tipoCor;

    public Desenho(int tipoForma, int tipoCor) {
        this.tipoForma = tipoForma;
        this.tipoCor = tipoCor;
    }

    public int getTipoForma() {
        return tipoForma;
    }

    public int getTipoCor() {
        return tipoCor;
    }

    public void setTipoForma(int tipoForma) {
        this.tipoForma = tipoForma;
        repaint();
    }

    public void setTipoCor(int tipoCor) {
        this.tipoCor = tipoCor;
        repaint();
    }
    
    @Override
    public void paint(Graphics g){
        
        switch (this.tipoCor) {
            case 1:
                g.setColor(Color.red);
                break;
            case 2:
                g.setColor(Color.blue);
                break;
            case 3:
                g.setColor(Color.green);
                break;
            default:
                break;
        }
        
        switch (this.tipoForma) {
            case 1:
                Polygon p = new Polygon();
                p.addPoint(25, 10);
                p.addPoint(10, 40);
                p.addPoint(40, 40);
                g.fillPolygon(p);
                break;
            case 2:
                g.fillRect(10, 10, 30, 30);
                break;
            case 3:
                g.fillOval(10, 10, 30, 30);
                break;
            default:
                break;
        }
        
    }
    
}
```

