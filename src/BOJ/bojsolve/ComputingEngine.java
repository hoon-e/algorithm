package BOJ.bojsolve;

public class ComputingEngine 
{ 
    public static void main(String[] args) 
    { 
        ComputingEngine engine = new ComputingEngine();
        Computation computation = new Computation(65);
        engine.changeComputedValue(computation);
         
        System.out.println("The value of x after passing by reference "+ computation.x);
    } 

    public void changeComputedValue(Computation computation)
    {
        computation = new Computation();
        computation.x = 40;
    }
}
 
class Computation 
{ 
    int x; 
    Computation(int i) { x = i; } 
    Computation()      { x = 1; } 
}
