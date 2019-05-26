package objects.mathfunctions;

import objects.GlobalSettings;

public final class Integral implements GlobalSettings {
    private double Ts;                 //sample time in milliseconds
    private double integralVal;
    
    public Integral(double sampleTime, double initialCondition) {
        setSampleTime(sampleTime);
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
    
    //Interface
    @Override
    public void setSampleTime(double Ts) {
        this.Ts = Ts;
    }
}
