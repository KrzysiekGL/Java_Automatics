package pl.krzysiekgl;


import objects.pidcontrollers.PID_IND;
import objects.plants.Integrator;

public class Main {
    
    private static final double TS = 0.1;

    public static void main(String[] args) {
        Integrator integrator = new Integrator(TS, 1.0, 2.0);
        PID_IND pid = new PID_IND(TS, 2.5, 0.1, 0.0);
        
        int step = 0;
        Double inputSignal = 1.0;
        Double response = 0.0;
        
        while(true) {
            
            Double pidResponse = pid.calculate(inputSignal, response);
            response = integrator.response(pidResponse);
            
            System.out.println(step + ";" + step*TS + ";" + response);
            
            step++;
            if(step == 100) break;
        }
    }
    
}
