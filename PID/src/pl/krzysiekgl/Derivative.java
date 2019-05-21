package pl.krzysiekgl;

public final class Derivative {
    private double Ts;             //sample time in milliseconds
    private double prevValue;   //previous value necessary for calculations
    
    public Derivative(double sampleTime, double initialCondition) {
        this.Ts = sampleTime;
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
}
