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
