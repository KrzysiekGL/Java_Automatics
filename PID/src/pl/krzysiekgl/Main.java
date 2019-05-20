package pl.krzysiekgl;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        
        PID_IND pidIND = new PID_IND(100, 0.5, 0.3, 0);
        
        double setValue = 1;
        double processVal = 0;
        int time = 0;
        while(true) {
            processVal = pidIND.calculate(setValue, processVal);
            System.out.println(time + ";" + processVal);
            
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                time+=100;
            }
            catch (InterruptedException exception) {
                System.out.println(time + " : " + exception);
            }
            
            if(time == 1000) setValue = 5;
            if(time == 3000) setValue = 1;
            if(time == 5000) setValue = 2;
            if(time == 6000) setValue = 4;
            if(time == 7000) setValue = 1;
            if(time == 8000) setValue = 0;
            if(time == 9000) setValue = 1;
            if(time == 30000) System.exit(0);
        }
    }
}
