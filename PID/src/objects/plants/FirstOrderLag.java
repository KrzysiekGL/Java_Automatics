package objects.plants;

import objects.GlobalSettings;

import java.util.zip.DeflaterOutputStream;

public class FirstOrderLag implements GlobalSettings {
    private Double Ts;      //sample time
    
    private Double k;       //static gain
    private Double alpha;
    private Double Tb;      //lag time
    
    //signals
    private Double prevState;
    private Double prevInputSignal;
    
    //parameters of approximated function from Z-transform
    private Double af1;
    private Double bf0;
    private Double bf1;
    
    //constructors
    public FirstOrderLag(double sampleTime, double k, double alpha, double Tb) {
        setSampleTime(sampleTime);
        this.k = k;
        this.alpha = alpha;
        this.Tb = Tb;
        
        prevState = null;
        prevInputSignal = null;
        
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
    
    public double getTs() {
        return Ts;
    }
    
    public void setTs(double ts) {
        Ts = ts;
        calculatePlantParametersAB();
    }
    
    private void calculatePlantParametersAB() {
        Double b0 = k;
        Double b1 = k;
        Double a0 = (Tb*2.0)/Ts + alpha;
        Double a1 = alpha - (Tb*2.0)/Ts;
        
        af1 = -a1/a0;
        bf0 = b0/a0;
        bf1 = b1/a0;
    }
    
    //Interface
    @Override
    public void setSampleTime(double Ts) {
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
