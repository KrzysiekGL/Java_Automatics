package pl.krzysiekgl;

public final class Derivative {
    private int Ts;             //sample time in milliseconds
    private double prevValue;   //previous value necessary for calculations
    
    public Derivative(int sampleTime, double initialCondition) {
        this.Ts = sampleTime;
        prevValue = initialCondition;
    }
    
    public Derivative(int sampleTime) {
        this(sampleTime, 0);
    }
    
    //Calculations
    public double differentiates(double currentValue) {
        double derivative = (currentValue-prevValue)/Ts;
        prevValue = currentValue;
        return derivative;
    }
    
    //Getters
    public int getTs() {
        return Ts;
    }
    
    public double getPrevValue() {
        return prevValue;
    }
}
