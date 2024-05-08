
package poligono;

public class Retangulo {
    
    int baseRetangulo;
    int alturaRetangulo;
    
    //construtor vazio
    Retangulo(){
        
    }
    
    //construtor valor
    Retangulo(int baseRetangulo, int alturaRetangulo){
        this.alturaRetangulo = alturaRetangulo;
        this.baseRetangulo = baseRetangulo;
    }
    
    //alterar objeto
    public void setAlturaRetangulo(int alturaRetangulo){
        this.alturaRetangulo = alturaRetangulo;
    }
    
    public void setBaseRetangulo(int baseRetangulo){
        this.baseRetangulo = baseRetangulo;
    }
    
    //obter
    public int getAlturaRetangulo(){
        return this.alturaRetangulo;
    }
    
    public int getBaseRetangulo(){
        return this.baseRetangulo;
    }

    @Override
    public String toString() {
        return "Retangulo{" + "baseRetangulo=" + baseRetangulo + ", alturaRetangulo=" + alturaRetangulo + ", areaRetangulo=" + areaRetangulo()+'}';
    }
    
    
    int areaRetangulo(){
        return baseRetangulo * alturaRetangulo;
    }
}
