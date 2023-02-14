import task1.ArcCosFunction;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        double r = Math.round(ArcCosFunction.arcCos(0.5) * 100.0)/100.0;
        System.out.println(r);
    }
}