
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
