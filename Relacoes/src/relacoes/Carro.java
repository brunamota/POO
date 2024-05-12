
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