
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
