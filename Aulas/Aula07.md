# Aula 07 - Composição e Agregação

### Quais as características de um Cilindro?

Um cilindro é uma figura geométrica tridimensional que consiste em duas bases paralelas e uma superfície curva que as une. As bases são círculos idênticos e a superfície curva, chamada de lateral, é formada por todos os pontos equidistantes das duas bases.

- Altura: A altura de um cilindro é a distância entre as bases paralelas. É uma linha reta perpendicular às bases e que conecta um ponto de uma base ao ponto correspondente da outra base.

- Raio: O raio é a distância do centro de uma base até qualquer ponto da sua circunferência. Como as bases do cilindro são círculos, elas têm um raio comum.

![cilindro-elementos-ilustracao (1)](https://github.com/brunamota/POO/assets/66503956/18d56357-c578-4465-84e0-7fee4a626a50)

### O que pode ser feito com essas características?

- Calcular a Área
  - $A = \pi * raio^2 + 2 * \pi * raio * altura$

# Exercício 6 - Cilindro

```Java
package poligono;

public class Principal {

    public static void main(String[] args) {
            //Cilindro
            Cilindro c1 = new Cilindro(new Circunferencia(2), 5);
            
            System.out.println("Objeto Circulo: "+c1.getCirculo() + ", Altura: " + c1.getAltura());
            System.out.println(c1);
            Circunferencia circulo = new Circunferencia(5);
            
            c1.setCirculo(circulo);
            c1.setAltura(2);      
            
            System.out.println("Objeto Circulo: "+c1.getCirculo() + ", Altura: " + c1.getAltura());
            System.out.println(c1);                   
    }   
}
```
- Cilindro
``` Java

package poligono;

public class Cilindro {
    //atributos
    private Circunferencia circulo;
    private double altura;
     
    //Construtores
    public Cilindro(){
    }
    
    public Cilindro(Circunferencia circulo, double altura) {
        this.circulo = circulo;
        this.altura = altura;
    }
    
    public Circunferencia getCirculo() {
        return circulo;
    }

    public double getAltura() {
        return altura;
    }

    public void setCirculo(Circunferencia circulo) {
        this.circulo = circulo;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    public double areaCilindro(){
        return (2 * this.circulo.areaCircunferencia()) + 2 * Math.PI * this.circulo.getRaioCircunferencia() * altura;
    }

    @Override
    public String toString() {
        return "Cilindro{" + "Raio: " + circulo.getRaioCircunferencia() + ", Altura: " + altura + ", Area: "+areaCilindro() + '}';
    }
}
```