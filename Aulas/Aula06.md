# Aula 6 - Herança: Generalização e Especialização

### Quais os tipos de triângulos existem?
### - Triangulo Equilátero

![Triangulo-equilatero-600x482 (1)](https://github.com/brunamota/POO/assets/66503956/86f55e57-a8df-487a-b3cb-0241dace8dcf)

  - Calcular a Área
    - $A =$ $lado^2 \sqrt{3} \over 4$
### - Triangulo Isoceles

![diagrama-de-dois-triangulos-isosceles-480x239](https://github.com/brunamota/POO/assets/66503956/447b6137-5601-4754-b088-a8675d9ed00d)

  - Calcular a Área
    - Altura:
      - $altura^2 = lado^2$ + $($ $base \over 2$ $)$ $^2$
    - $A =$ $(base * altura)\over 2$

### - Triangulo Escaleno

![diagrama-de-um-triangulo-escaleno-1-300x252_1](https://github.com/brunamota/POO/assets/66503956/0480d5a7-1345-4f93-946e-0e232ab93886)

  - Calcular a Área
    - Semiperímetro: 
      - $p =$ $a+b+c \over 2$
    - $A =$ $\sqrt{p(p-a)(p-b)(p-c)}$
  
# Exercício 6 - Triângulos
- Principal
```Java
package poligono;

public class Principal {

    public static void main(String[] args) {
          Triangulo t1 = new TrianguloEquilatero(10);
          Triangulo t2 = new TrianguloIsoceles(10,12);
          Triangulo t3 = new TrianguloEscaleno(9,10,11);
          
          System.out.println(t1);
          System.out.println(t2);
          System.out.println(t3);
         
    }   
}
```

- Triângulo
```Java
package poligono;



public class Triangulo {

    //atributos
    protected int base;
    protected int lado1, lado2;

    //Contrutor vazio
    public Triangulo() {

    }
    

    //Contrutor com parametros
    public Triangulo(int base, int lado1, int lado2) {
        this.base = base;
        this.lado1 = lado1;
        this.lado2 = lado2;
    }
    public int getBaseTriangulo() {    
        return base;
    }

    public int getLado1() {
        return lado1;
    }

    //Acessar os metodos
    //obter dados do objetos
    public int getLado2() {    
        return lado2;
    }

    //alterar dados do objetos

    public void setBase(int base) {
        this.base = base;
    }

    public void setLado1(int lado1) {
        this.lado1 = lado1;
    }

    public void setLado2(int lado2) {
        this.lado2 = lado2;
    }

    @Override
    public String toString() {
        return "Triangulo{" + "base: " + base + ", lado1: " + lado1 + ", lado2: " + lado2 + ", areaTriangulo: " + areaTriangulo();
    }

    //Comportamento do triangulo
    public double areaTriangulo() {
        if(this instanceof TrianguloEquilatero){
            //(lado^2 * raiz de 3)/4
            return (Math.pow(this.lado1, 2)* Math.sqrt(3))/4;
        }else if(this instanceof TrianguloEscaleno){
            double altura = (Math.sqrt(Math.pow(lado1, 2) - Math.pow(base/2, 2)));
            return base * altura/2;
        }else{
            double p = (base + lado1 + lado2)/2;
            return Math.sqrt(p*(p-base)*(p-lado1)*(p-lado2));
        }
    }
}
```

- Triângulo Equilátero
```Java
package poligono;

public class TrianguloEquilatero extends Triangulo{

    public TrianguloEquilatero() {
    }

    public TrianguloEquilatero(int base) {
        super(base, base, base);
    }

    public int getLadoEquilatero() {
        return super.base;
    }

    public void setLadoEquilatero(int base) {
        super.base = base;
        super.lado1 = base;
        super.lado2 = base;
    }  
    
    @Override
    public String toString() {
        return super.toString() + ", Tipo - Equilatero}";
    }
     
}
```

- Triângulo Isoceles
```Java
package poligono;

public class TrianguloIsoceles extends Triangulo{

    public TrianguloIsoceles() {
    }
    
    public TrianguloIsoceles(int base, int lado1) {
        super(base, lado1, lado1);
    }
    
    public int getBaseIsoceles() {
        return super.base;
    }
    
     public int getLadoIsoceles() {
        return super.lado1;
    }

    public void setBaseIsoceles(int base) {
        super.base = base;
    } 
    
    public void setLadoIsoceles(int lado) {
        super.lado1 = lado;
        super.lado2 = lado;
    }  
    
    @Override
    public String toString() {
        return super.toString() + ", Tipo - Isoceles}";
    }
    
}
```

- Triângulo Escaleno
```Java
package poligono;

public class TrianguloEscaleno extends Triangulo{

    public TrianguloEscaleno() {
    }

    public TrianguloEscaleno(int base, int lado1, int lado2) {
        super(base, lado1, lado2);
    }

    public int getBase() {
        return super.base;
    }

    public int getLado1() {
        return super.lado1;
    }

    public int getLado2() {
        return super.lado2;
    }

    public void setBase(int base) {
        super.base = base;
    }

    public void setLado1(int lado1) {
        super.lado1 = lado1;
    }

    public void setLado2(int lado2) {
        super.lado2 = lado2;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Tipo - Equilatero}";
    }
}
```
### Quais as características de um Cilindro?

### O que pode ser feito com essas características?

- Calcular a Área
  - A =

# Exercício 5 - Cilindro

```Java
código
```
