package trainproject;


public class Engine {
    
    private String name;
    private Boxcar boxcar;
    
    public Engine(String n) {
        name = n;
        boxcar = null;
    }
    
    public void setBoxcar(Boxcar bcar) {
        boxcar = bcar;
    }
    
    public Boxcar getBoxcar() {
        return boxcar;
    }
    
    public String toString() {
        return "Engine " + name;
    }
 }
