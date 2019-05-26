package pl.krzysiekgl;


public class Main {

    public static void main(String[] args) {
        
        Derivative S = new Derivative(0.1);
        Integral I = new Integral(0.1);
        
        Gain kp = new Gain(0.2);
        Gain ki = new Gain(0.1);
        Gain kd = new Gain(0);
        
        double time = 0;
        
        double foo = 1;
        double procV = 0;
        
        while(true) {
            double err = foo - procV;
            procV = kp.product(err) + ki.product(I.add(err)) + kd.product(S.differentiates(err));
            
            System.out.println(time + ";" + procV);
            
            time+=0.1;
            if(procV >= 0.9 && procV <= 1.1 && time >= 10) System.exit(0);
        }
    }
}
