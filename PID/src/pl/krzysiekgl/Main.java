package pl.krzysiekgl;


import objects.plants.FirstOrderLag;

public class Main {
    
    private static final double TS = 0.1;

    public static void main(String[] args) {
        FirstOrderLag firstOrderLag = new FirstOrderLag(0.1, 3, 3, 1);
        
        int step = 0;
        while(true) {
            Double response = firstOrderLag.response(1.0);
            System.out.println(step + ";" + step*TS + ";" + response);
            
            step++;
            if(step == 100) break;
        }
    }
    
}
