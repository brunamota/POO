# Aula 09 - Relacionamentos entre classes: composição, agregação e associação. Atribuição entre objetos, comparação de objetos

### Composição
Um trem **é formado por** 1 locomotivas e n vagões. Relacionamento tem-um. A classe trem precisa ter pelo menos 1 locomotiva para existir.
Para orientação a objeto, uma composição seria uma classe composta por outras. 

![composição](https://github.com/brunamota/POO/assets/66503956/ab2e5e19-1fd7-4375-bccd-88c9a35bc400)

### Agregação
Uma locomotiva (todo) **tem** um farol (parte), mas não deixa de existir caso não tenha o farol.
Para orientação a objeto, classe não depende de outra para existir.

![agregação](https://github.com/brunamota/POO/assets/66503956/23475506-fd40-4e08-985a-8e7e627d3727)

### Associação
Um trem **usa** uma estrada de ferro. A estrada não faz parte de trem, mas depende dela para funcionar.
Para orientação a objeto, o funcionamento da classe trem depende da classe estrada estar funcionando/liberada.

![associação](https://github.com/brunamota/POO/assets/66503956/7a6f5bf7-eb31-4ccc-baee-b6f8e50d2afa)

# Exercício 8 - Venda

# Composição 9 - Banco

# Associação 10 - Carro
``` Java

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
```
