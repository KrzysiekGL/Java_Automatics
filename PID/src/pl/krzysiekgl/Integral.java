package pl.krzysiekgl;

public final class Integral {
    private int Ts;                 //sample time in milliseconds
    private double integralVal;
    
    public Integral(int sampleTime) {
        this.Ts = sampleTime;
        integralVal = 0;
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
    
    public int getTs() {
        return Ts;
    }
}
