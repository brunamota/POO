# Aula 5 - Herança: Generalização e Especialização

### Quais as características de um Triângulo?

- Lados: possui quatro lados iguais.
- Ângulos: os ângulos internos medem 90°, cuja soma deve sempre dar 360°.
- Diagonais: possui duas diagonais com a mesma medida. Elas se interceptam no ponto médio, ou seja, na metade de cada uma destas diagonais.

![Aula 5 - Quadrado](https://github.com/brunamota/POO/assets/66503956/ba752e49-738b-4dde-9ce2-d48e45be09ff)

### O que pode ser feito com essas caracteristicas?

- Calcular a Área
  - A = $lado^2$

# Exercício 4 - Quadrado
- Classe Principal

```Java
package poligono;

public class Principal {

    public static void main(String[] args) {
          //Quadrado
          Quadrado q1 = new Quadrado(5);
          
          System.out.println(q1);
          
          q1.setLado(6);
          
          System.out.println("Lado do triangulo: " + q1.getLado());
    }
}
```

- Classe Quadrado

```Java
package poligono;
//Quadrado é uma especifidade de Retangulo
//Reusabilidade da classe Retangulo
public class Quadrado extends Retangulo {

    Quadrado() {
    }

    //Construtor herdando os paramentros da Classe Mãe
    Quadrado(int lado) {
        super(lado, lado);
    }

    //set herdando o set da Classe Mãe
    public void setLado(int lado) {
        super.setAlturaRetangulo(lado);
        super.setBaseRetangulo(lado);
    }

    //get herdando o get da Classe Mãe
    public int getLado() {
        return super.getAlturaRetangulo();
    }

    @Override
    public String toString() {
        return super.toString() + " Tipo: Quadrado";
    }  
}
```
