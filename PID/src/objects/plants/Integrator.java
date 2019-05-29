package objects.plants;

import objects.GlobalSettings;

public class Integrator implements GlobalSettings {
    private Double Ts;          //sample time
    
    private Double k;           //static gain
    private Double Ti;          //integration time
    
    //signals
    private Double prevState;
    private Double prevInputSignal;
    
    //parameters of approximated function from Z-transform
    private Double af1;
    private Double bf0;
    private Double bf1;
    
    //constructors
    public Integrator(Double sampleTime, Double k, Double Ti) {
        setSampleTime(sampleTime);
        this.k = k;
        this.Ti = Ti;
    
        prevState = null;
        prevInputSignal = null;
        
        calculatePlantParametersAB();
    }
    
    public Integrator(Double k, Double Ti) {
        this(0.1, k, Ti);
    }
    
    //getters and setters
    public Double getTs() {
        return Ts;
    }
    
    public void setTs(Double ts) {
        Ts = ts;
        calculatePlantParametersAB();
    }
    
    public Double getK() {
        return k;
    }
    
    public void setK(Double k) {
        this.k = k;
        calculatePlantParametersAB();
    }
    
    public Double getTi() {
        return Ti;
    }
    
    public void setTi(Double ti) {
        Ti = ti;
        calculatePlantParametersAB();
    }
    
    //calculate parameters A & B
    private void calculatePlantParametersAB() {
        Double b0 = k;
        Double b1 = k;
        Double a0 = (2.0*Ti)/(Ts);
        Double a1 = (-2.0*Ti)/(Ts);
        
        af1 = -a1/a0;
        bf0 = b0/a0;
        bf1 = b1/a0;
    }
    
    //implemented interface
    @Override
    public void setSampleTime(Double Ts) {
        this.Ts = Ts;
    }
    
    //response
    public Double response(Double inputSignal) {
        if(prevInputSignal == null) {
            prevInputSignal = inputSignal;
            prevState = 0.0;
            return 0.0;
        }
    
        Double currState = af1 * prevState + bf0 * inputSignal + bf1 * prevInputSignal;
    
        prevState = currState;
        prevInputSignal = inputSignal;
    
        return currState;
    }
}
