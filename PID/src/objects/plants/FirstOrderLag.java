package objects.plants;

import objects.GlobalSettings;

public class FirstOrderLag implements GlobalSettings {
    private double Ts;      //sample time
    
    private double k;       //static gain
    private double alpha;
    private double Tb;      //lag time
    
    //parameters of approximated function from Z-transform
    private double af1;
    private double bf0;
    private double bf1;
    
    //constructors
    public FirstOrderLag(double sampleTime, double k, double alpha, double Tb) {
        setSampleTime(sampleTime);
        this.k = k;
        this.alpha = alpha;
        this.Tb = Tb;
        calculatePlantParametersAB();
    }
    
    public FirstOrderLag(double k, double alpha, double Tb) {
        this(0.1, k, alpha, Tb);
    }
    
    
    //getters and setters
    public double getK() {
        return k;
    }
    
    public void setK(double k) {
        this.k = k;
        calculatePlantParametersAB();
    }
    
    public double getAlpha() {
        return alpha;
    }
    
    public void setAlpha(double alpha) {
        this.alpha = alpha;
        calculatePlantParametersAB();
    }
    
    public double getTb() {
        return Tb;
    }
    
    public void setTb(double tb) {
        Tb = tb;
        calculatePlantParametersAB();
    }
    
    private void calculatePlantParametersAB() {
        double a0 = k*Ts;
        double a1 = k*Ts;
        double b0 = alpha*Ts + 2*Tb;
        double b1 = alpha*Ts - 2*Tb;
        
        af1 = -a1/a0;
        bf0 = b0/a0;
        bf1 = b1/a0;
    }
    
    //Interface
    @Override
    public void setSampleTime(double Ts) {
        this.Ts = Ts;
    }
}
