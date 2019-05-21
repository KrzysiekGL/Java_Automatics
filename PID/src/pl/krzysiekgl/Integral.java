package pl.krzysiekgl;

public final class Integral {
    private double Ts;                 //sample time in milliseconds
    private double integralVal;
    
    public Integral(double sampleTime, double initialCondition) {
        this.Ts = sampleTime;
        this.integralVal = initialCondition;
    }
    
    public Integral(double sampleTime) {
        this(sampleTime, 0);
    }
    
    public void resetIntegral() {
        integralVal = 0;
    }
    
    public void resetIntegral(int newSampleTime) {
        this.Ts = newSampleTime;
        integralVal = 0;
    }
    
    //Calculations
    public double add(double value) {
        integralVal += value * Ts;
        return integralVal;
    }
    
    //Getters
    public double getIntegralVal() {
        return integralVal;
    }
    
    public double getTs() {
        return Ts;
    }
}
