# Aula 16 - Relação entre objetos e classes – Threads Exemplo: uso do pacote gráfico Graphics na criação de jogos

Desenvolvendo um jogo da velha utilizando orientação a objetos.

![Captura de tela 2024-07-07 211654](https://github.com/brunamota/POO/assets/66503956/c5af8374-a1fd-4037-b551-8994237b9dc0)

:white_check_mark: Criar um projeto chamado JogoDaVelha
   - Criara as classes:
     - Computador
     - Humano
     - Janela
     - Jogador
     - Logica do Jogo
     - Tabuleiro
     - Criar um pacoce chamado img
         - [Imagens do X e do O](https://github.com/user-attachments/files/16121475/TicTacToe.zip)


Computador:
```Java
package jogodavelha;

public class Computador extends Jogador{

    public Computador(int jogador) {
        super(jogador);
    }

    @Override
    public void jogar(int pos, Tabuleiro tabuleiro, int simbolo) {
        tabuleiro.marcaTabuleiro(pos, 2, simbolo);
    }
    
}

```

Humano:
```Java
package jogodavelha;

public class Humano extends Jogador{

    public Humano(int jogador) {
        super(jogador);
    }

    @Override
    public void jogar(int pos, Tabuleiro tabuleiro, int simbolo) {
        tabuleiro.marcaTabuleiro(pos, 1, simbolo);
    }
}
```

Jogador:
```Java
package jogodavelha;

public abstract class Jogador {
    
    protected int jogador;

    public Jogador(int jogador) {
        this.jogador = jogador;
    }

    public abstract void jogar(int pos, Tabuleiro tabuleiro, int simbolo);
    
}
```

Logica do Jogo
```Java

package jogodavelha;

import java.util.Random;
import javax.swing.JOptionPane;

public class LogicaDoJogo {
    
    private Tabuleiro tabuleiro;
    private int rodadaJogo;
    private Jogador jogadorEscolhido, jogador1, jogador2;
    private boolean iniciado;
    private int simbolo;

    public LogicaDoJogo(Jogador jogador1, Jogador jogador2) {
        tabuleiro = new Tabuleiro();
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        
        this.rodadaJogo = 1;
        this.iniciado = true;
        
        this.simbolo = new Random().nextInt(2);
        
        jogadorEscolhido = jogador1;
        if(jogadorEscolhido instanceof Computador){
            acionaComputador();
        }
    
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public int getRodadaJogo() {
        return rodadaJogo;
    }

    public Jogador getJogadorEscolhido() {
        return jogadorEscolhido;
    }

    public Jogador getJogador1() {
        return jogador1;
    }

    public Jogador getJogado2() {
        return jogador2;
    }
    
    public boolean isIniciado(){
        return iniciado;
    }
    
    public void geraRodada(int i){
        marcaPosicao(i);
        if(this.iniciado){
            this.rodadaJogo++;
            jogadorEscolhido = ((jogadorEscolhido == jogador2)? jogador1:jogador2);
            verficaVez();
        }
    }
    
    public void verficaVez(){
        if(jogadorEscolhido instanceof Computador){
            acionaComputador();
        }
    }
        
    private void acionaComputador() {
        if(this.iniciado){
            int pos = new Random().nextInt(9);
            while(!tabuleiro.posicaoLivre(pos)){
                pos = new Random().nextInt(9);
            }
            marcaPosicao(pos);
            this.rodadaJogo++;
            jogadorEscolhido = ((jogadorEscolhido == jogador2)? jogador1:jogador2);
            verficaVez();
        }
    }    

    private void marcaPosicao(int pos) {
          if(jogadorEscolhido instanceof Humano){
              jogadorEscolhido.jogar(pos, tabuleiro, simbolo);
          }else if(jogadorEscolhido instanceof Computador){
              jogadorEscolhido.jogar(pos, tabuleiro, simbolo);
          }
          
          simbolo = Math.abs(simbolo - 1);
          
          if(verificaVencedor() || verificaEmpate()){
              this.iniciado = false;
          }
    }

    private boolean verificaVencedor() {
        if(tabuleiro.verificaVencedor()){
            if(jogadorEscolhido  == jogador1){
                JOptionPane.showMessageDialog(null, "Jogador 1 ganhou.");
                return true;
            }else if(jogadorEscolhido  == jogador2){
                JOptionPane.showMessageDialog(null, "Jogador 2 ganhou.");
                return true;
            }
        }
        return false;
        
    }

    private boolean verificaEmpate() {
        if(tabuleiro.tabuleiroCompleto()){
            JOptionPane.showMessageDialog(null, "Jogo empatado.");
            return true;
        }
        return false;
        
    }
    
}
```

Tabuleiro
```Java

package jogodavelha;

public class Tabuleiro {
    public int[] tabJogador = new int[9];
    public int[] tabSimbolo = new int[9];
    
    public Tabuleiro(){
        zerarTabuleiro();
    }

    private void zerarTabuleiro() {
        for(int i = 0; i < 9; i++){
            tabJogador[i] = 0;
            tabSimbolo[i] = -1;
        }
    }
    
    public void marcaTabuleiro(int pos, int jogador, int simbolo){
        this.tabJogador[pos] = jogador;
        this.tabSimbolo[pos] = simbolo;
    }
    
    public boolean posicaoLivre(int pos){
        
        if(tabJogador[pos] == 0){
            return true;
        }
        return false;
    }
    
    public boolean verificaVencedor(){
        if(verificaLinhas() || verificaColunas() || verificaDiagonais()){
            return true;
        }
        return false;
    }

    private boolean verificaLinhas() {
        return verificaConjunto(0,1,2,3,4,5,6,7,8);
    }

    private boolean verificaColunas() {
        return verificaConjunto(0,3,6,1,4,7,2,5,8);
    }

    private boolean verificaDiagonais() {
        return verificaConjunto(0,4,8,2,4,6,0,4,8);
    }

    private boolean verificaConjunto(int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if(tabJogador[i1] == 1 && tabJogador[i2] == 1 && tabJogador[i3] == 1){
            return true;
        }else if(tabJogador[i1] == 2 && tabJogador[i2] == 2 && tabJogador[i3] == 2){
            return true;
        }else if(tabJogador[i4] == 1 && tabJogador[i5] == 1 && tabJogador[i6] == 1){
            return true;
        }else if(tabJogador[i4] == 2 && tabJogador[i5] == 2 && tabJogador[i6] == 2){
            return true;
        }else if(tabJogador[i7] == 1 && tabJogador[i8] == 1 && tabJogador[i9] == 1){
            return true;
        }else if(tabJogador[i7] == 2 && tabJogador[i8] == 2 && tabJogador[i9] == 2){
            return true;
        }
        
        return false;
    
    }
    
    public boolean tabuleiroCompleto(){
        for(int i = 0; i<9; i++){
            return false;
        }
        
        return true;
    }
    
}  
```

Janela
```Java

package jogodavelha;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Janela extends JFrame implements ActionListener, Runnable{
    
    private Jogador jogador1, jogador2;
    private LogicaDoJogo logica;
    
    private ImageIcon icon;
    
    private final String caminho1 = "./src/img/o.png";
    private final String caminho2 = "./src/img/x.png";
    
    private JRadioButton rbHumano1, rbHumano2, rbComputador1, rbComputador2;
    
    private JPanel painelJogador1, painelJogador2, painelDesenho, painelBotoes, painelDados;
    
    private JLabel lbBarraT, lbBarraS;
    
    private JButton btIniciar;
    
    private JButton[] bts;
    
    private ButtonGroup gbJogador1, gbJogador2;
    
    Janela(){
        
        this.setSize(200,200);
        this.setLayout(new BorderLayout());
        
        painelDados = new JPanel(new GridLayout(3,1));
        painelBotoes = new JPanel(new GridLayout(3,3));
        painelDesenho = new JPanel(new BorderLayout());
        
        bts = new JButton[9];
        for(int i = 0; i< 9; i++){
            bts[i] = new JButton();
            painelBotoes.add(bts[i]);
        }
        
        lbBarraT = new JLabel("Jogador ===>");
        lbBarraS = new JLabel("Bom jogo");
        
        painelDesenho.add(lbBarraT,BorderLayout.NORTH);
        painelDesenho.add(painelBotoes,BorderLayout.CENTER);
        painelDesenho.add(lbBarraS,BorderLayout.SOUTH);
        
        painelJogador1 = new JPanel();
        painelJogador1.setBorder(BorderFactory.createTitledBorder("Jogador 1"));
        
        painelJogador2 = new JPanel();
        painelJogador2.setBorder(BorderFactory.createTitledBorder("Jogador 2"));
        
        gbJogador1 = new ButtonGroup();
        gbJogador2 = new ButtonGroup();
        
        rbHumano1 = new JRadioButton("Humano", true);
        rbHumano2 = new JRadioButton("Humano");
        
        rbComputador1 = new JRadioButton("Computador");
        rbComputador2 = new JRadioButton("Computador", true);
        
        gbJogador1.add(rbHumano1);
        gbJogador1.add(rbComputador1);
        
        gbJogador2.add(rbHumano2);
        gbJogador2.add(rbComputador2);
        
        btIniciar = new JButton("Iniciar");
        
        painelJogador1.add(rbHumano1);
        painelJogador1.add(rbComputador1);
        
        painelJogador2.add(rbHumano2);
        painelJogador2.add(rbComputador2);
        
        painelDados.add(painelJogador1);
        painelDados.add(painelJogador2);
        painelDados.add(btIniciar);
        
        this.add(painelDados, BorderLayout.WEST);
        this.add(painelDesenho);
        
        btIniciar.addActionListener(this);
        
        for(int i=0; i<9;i++){
            bts[i].addActionListener(this);
        }
        
        
        this.setTitle("Jogo da Velha");
        this.setSize(500,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == btIniciar){
             iniciarJogares();
             logica = new LogicaDoJogo(jogador1, jogador2);
             btIniciar.setText("Reiniciar");
             new Thread(this).start();
        }
         
        for(int i=0; i<9;i++){
            if(e.getSource() == bts[i]){
                if(logica == null){
                    JOptionPane.showMessageDialog(null, "Clique em inicar para começar o jogo");
                }else if(!logica.isIniciado()){
                    JOptionPane.showMessageDialog(null, "Clique em reinicar para começar o jogo");
                }else{
                    if(bts[i].getIcon() == null){
                        logica.geraRodada(i);
                    }
                }
            }
        }
    }

    private void iniciarJogares() {
        if (rbHumano1.isSelected()) {
            this.jogador1 = new Humano(1);
            lbBarraT.setText("Jogadores: Humano x ");
        }else{
            this.jogador1 = new Computador(1);
            lbBarraT.setText("Jogadores: Computador x ");
        }
        
        if (rbHumano2.isSelected()) {
            this.jogador2 = new Humano(2);
            lbBarraT.setText(lbBarraT.getText() + "Humano");
        }else{
            this.jogador2 = new Computador(2);
            lbBarraT.setText(lbBarraT.getText() + "Computador");
        }
        
    }
    
    public void reiniciaBotoes(){
        for(int i=0; i<9;i++){
            bts[i].setIcon(null);
        }
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(500);
                for(int i=0; i<9;i++){
                    if(logica.getTabuleiro().tabSimbolo[i] == 0){
                        icon = new ImageIcon(caminho1);
                        bts[i].setIcon(icon);
                    }else if(logica.getTabuleiro().tabSimbolo[i] == 1){
                        icon = new ImageIcon(caminho2);
                        bts[i].setIcon(icon);
                    }else{
                        bts[i].setIcon(null);
                    }        
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
```

Principal
```Java
package jogodavelha;

public class Principal {

    public static void main(String[] args) {
       new Janela().setVisible(true);
    }
}
```
