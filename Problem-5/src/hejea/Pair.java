package hejea;

public class Pair implements Functinon {
    private int a;
    private int b;
    
    public Pair() {
        a = 0;
        b = 0;
    }
    
    private Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
    
    public static Pair getInstace(int a, int b) {
        return new Pair(a, b);
    }
    
    public int getB() {
        return b;
    }
    
    public void setB(int b) {
        this.b = b;
    }
    
    public int getA() {
        return a;
    }
    
    public void setA(int a) {
        this.a = a;
    }

}
