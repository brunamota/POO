# Aula 02 Introdução à Orientação à Objetos
## Conceitos Gerais (Abstração, Classes, Objetos, Encapsulamento, Polimorfismo e Herança)

### Quais as características de um retângulo?

- lados
- ângulos
- diagonais

### O que pode ser feito com essas caracteristicas?

- Calcular a area
- Calcular o perimetro

# Exercício 1 – Retângulo
- Classe Principal
```
package poligono;

public class Principal {

    public static void main(String[] args) {
       //instanciar um objeto - Retangulo(altura, base)
       Retangulo r1 = new Retangulo(10, 5);
       
       Retangulo r2 = new Retangulo();
       
       //r2 instanciado pelo construtor vazio
       System.out.println("Area: " + r2.calculaArea());
       
       //setar valores para r2
       r2.setAlturaRetangulo(20);
       r2.setBaseRetangulo(10);
       
       //mostrar area do r1 e r2;
       System.out.println("Area: " + r1.calculaArea());
       
       //alterou valores de r2
       System.out.println("Area: " + r2.calculaArea());
       //obteve valor da altura de r1
       System.out.println("Lado r1: " + r1.getAlturaRetangulo());
       
       System.out.println(r1);
    }
    
}
```
