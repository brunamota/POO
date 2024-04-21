# Aula 03 - Estrutura de Classes e Instanciação de Objetos. Exercício 2 – Circunferência
## Conceitos Gerais (Abstração, Classes, Objetos, Encapsulamento, Polimorfismo e Herança)

### Quais as características de um Círculo?

- Raio: distância do centro a um ponto qualquer da circunferência.
- Diamêtro: segmento de reta que passa pelo centro do círculo e cujas extremidades estão sobre o círculo.

![Circunferencia](https://github.com/brunamota/POO/assets/66503956/5cbf2998-fd95-402d-a01f-83eb9c5fc5f9)

### O que pode ser feito com essas caracteristicas?

- Calcular a Área
  - A = $\pi$ * $raio^2$
- Perímetro
  - P = 2 * $\pi$ * raio

# Exercício 2 – Circunferência

- Classe Principal

- Classe Circunferencia
```
package poligono;

public class Circunferencia {
    //atributos - característica
    public double raioCirc;
    
    //Construtor vazio, sem parametro
    public Circunferencia() {
        
    }
    
    //Construtor com parâmetro
    public Circunferencia(double raioCirc) {
        this.raioCirc = raioCirc;
    }
    
    //Acessar os metodos
    //obter dados do objetos
    public double getRaioCirc() {
        return raioCirc;
    }

    //alterar dados do objetos
    public void setRaioCirc(double raioCirc) {
        this.raioCirc = raioCirc;
    }

    @Override
    public String toString() {
        return "Circ{" + "raioCirc = " + raioCirc + '}';
    }
    
    //métodos - comportamento do objeto
    public double areaCirc(){
        return  (Math.pow(raioCirc, 2) * Math.PI);
    }
}```
