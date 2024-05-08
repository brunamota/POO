
package poligono;

public class Principal {

    public static void main(String[] args) {
        Retangulo r1 = new Retangulo(10, 5);
        Retangulo r2 = new Retangulo(20, 2);
        
        System.out.println("Area: " + r2.areaRetangulo());
        //r1.alturaRetangulo = 10;
        //r1.baseRetangulo = 5;
        
        r2.setAlturaRetangulo(50);
        r2.setBaseRetangulo(2);
        
        System.out.println("Area: " + r2.areaRetangulo());
        System.out.println("Altura r1: " + r1.getAlturaRetangulo());
        
        //Circunferencia
        
        Circunferencia c1 = new Circunferencia();
      
        c1.setRaioCircunferencia(4);
        
        System.out.println(c1.getRaioCircunferencia());
        
        Circunferencia c2 = new Circunferencia(5);
        
        System.out.println("Area: " + c2.areaCircunferencia());

        //Quadrado
        Quadrado q1 = new Quadrado(5);
        
        System.out.println("Lado: " + q1.getLado());
        
        q1.setLado(6);
        
        System.out.println("Lado: " + q1.getLado());
        
        System.out.println("Area: " + q1.areaRetangulo());
        
        System.out.println(q1);

        //Herança Triangulo
        //Generalização: Triangulo Especialização: Equilatero, Isoceles e Escaleno
        Triangulo t1 = new TrianguloEquilatero(10);
        Triangulo t2 = new TrianguloIsosceles(10,12);
        Triangulo t3 = new TrianguloEscaleno(9,10,11);

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
         

        //Cilindro
        //Agregação
        Cilindro c3 = new Cilindro(new Circunferencia(2), 5);

        System.out.println("Objeto Circulo: "+c3.getCirculo() + ", Altura: " + c3.getAltura());
        System.out.println(c1);
        Circunferencia circulo = new Circunferencia(5);

        c3.setCirculo(circulo);
        c3.setAltura(2);      

        System.out.println("Objeto Circulo: "+c3.getCirculo() + ", Altura: " + c3.getAltura());
        System.out.println(c1);           
            
    }   
}
