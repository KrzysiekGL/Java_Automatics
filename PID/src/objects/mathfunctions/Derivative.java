package objects.mathfunctions;

import objects.GlobalSettings;

import java.util.zip.DeflaterOutputStream;

public final class Derivative implements GlobalSettings {
    private Double Ts;             //sample time in milliseconds
    private double prevValue;   //previous value necessary for calculations
    
    public Derivative(double sampleTime, double initialCondition) {
        setSampleTime(sampleTime);
        prevValue = initialCondition;
    }
    
    public Derivative(double sampleTime) {
        this(sampleTime, 0);
    }
    
    //Calculations
    public double differentiates(double currentValue) {
        double derivative = (currentValue-prevValue)/Ts;
        prevValue = currentValue;
        return derivative;
    }
    
    //Getters
    public double getTs() {
        return Ts;
    }
    
    public double getPrevValue() {
        return prevValue;
    }
    
    
    //Interface
    @Override
    public void setSampleTime(Double Ts) {
        this.Ts = Ts;
    }
}
