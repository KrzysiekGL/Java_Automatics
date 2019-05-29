package objects.pidcontrollers;

import objects.GlobalSettings;

public final class PID_IND implements GlobalSettings {
    private Double Ts;  //sample time
    private Double Kp;  //proportional gain
    private Double Ki;  //integral gain
    private Double Kd;  //derivative gain
    
    private Double prevError;
    private Double integralVal;
    
    public PID_IND(Double sampleTime, Double proportionalGain, Double integralGain, Double derivativeGain) {
        setSampleTime(sampleTime);
        this.Kp = proportionalGain;
        this.Ki = integralGain;
        this.Kd = derivativeGain;
        
        prevError = 0.0;
        integralVal = 0.0;
    }
    
    public PID_IND(Double sampleTime) {
        this(sampleTime, 0.0, 0.0, 0.0);
    }
    
    //PID_IND tuning
    public void setKp(Double kp) {
        Kp = kp;
    }
    
    public void setKi(Double ki) {
        Ki = ki;
    }
    
    public void setKd(Double kd) {
        Kd = kd;
    }
    
    //PID_IND algorithm
    public Double calculate(Double setPoint, Double processValue) { //returns Control Variable
        Double controlVariable = 0.0;
        Double error = setPoint - processValue;
        
        //calculations
        integralVal += error * Ts;
        Double derivative = (error - prevError) / Ts;
        controlVariable = Kp * error + Ki * integralVal + Kd * derivative;
        
        prevError = error;
        return controlVariable;
    }
    
    //Interface
    
    @Override
    public void setSampleTime(Double Ts) {
        this.Ts = Ts;
    }
}
