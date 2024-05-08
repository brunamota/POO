
package poligono;

public class TrianguloIsosceles extends Triangulo{

    public TrianguloIsosceles() {
    }
    
    public TrianguloIsosceles(int base, int lado1) {
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
