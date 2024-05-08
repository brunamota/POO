
package poligono;

public class Circunferencia {
    
    private double raio;
    
    Circunferencia(){
    
    }
    
    Circunferencia(double raio){
        this.raio = raio;
    }
    
    public double getRaioCircunferencia(){
       return this.raio;
    }
    
    public void setRaioCircunferencia(double raio){
        this. raio = raio;
    }

    @Override
    public String toString() {
        return "Circunferencia{" + "raio = " + raio + ", areaCircunferencia = " + areaCircunferencia() + '}';
    }
    
    
    double areaCircunferencia(){
        return Math.PI * Math.pow(raio, 2);
    }
    
}
