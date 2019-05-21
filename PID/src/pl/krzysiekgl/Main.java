package pl.krzysiekgl;


import static java.lang.Math.pow;
import static java.lang.Math.sin;

public class Main {

    public static void main(String[] args) {
        
        Derivative S = new Derivative(0.1);
        Derivative S2 = new Derivative(0.1);
        
        double time = 0;
        //function f(t) = t
        
        while(true) {
            double functionVal = pow(time, 3);
            double result = S.differentiates(S2.differentiates(functionVal));
            System.out.println(time + ";" + functionVal + ";" + result);
            
            time+=0.1;
            if(time >= 10) System.exit(0);
        }
    }
}
