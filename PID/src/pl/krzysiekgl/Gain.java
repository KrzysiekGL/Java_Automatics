package pl.krzysiekgl;

public final class Gain {
    private double gain;
    
    public Gain(double gain) {
        this.gain = gain;
    }
    
    //Calculations
    public double product(double value) {
        return value*gain;
    }
    
    //Getters
    public double getGain() {
        return gain;
    }
}
