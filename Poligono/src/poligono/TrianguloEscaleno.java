
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
