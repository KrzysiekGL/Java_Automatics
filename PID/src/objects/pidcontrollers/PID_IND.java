package objects.pidcontrollers;

import objects.GlobalSettings;

public final class PID_IND implements GlobalSettings {
    private double Ts;  //sample time
    private double Kp;  //proportional gain
    private double Ki;  //integral gain
    private double Kd;  //derivative gain
    
    private double prevError;
    private double integralVal;
    
    public PID_IND(double sampleTime, double proportionalGain, double integralGain, double derivativeGain) {
        setSampleTime(sampleTime);
        this.Kp = proportionalGain;
        this.Ki = integralGain;
        this.Kd = derivativeGain;
        
        prevError = 0;
        integralVal = 0;
    }
    
    public PID_IND(double sampleTime) {
        this(sampleTime, 0, 0, 0);
    }
    
    //PID_IND tuning
    public void setKp(double kp) {
        Kp = kp;
    }
    
    public void setKi(double ki) {
        Ki = ki;
    }
    
    public void setKd(double kd) {
        Kd = kd;
    }
    
    //PID_IND algorithm
    public double calculate(double setPoint, double processValue) { //returns Control Variable
        double controlVariable = 0;
        double error = setPoint - processValue;
        
        //calculations
        integralVal += error * Ts;
        double derivative = (error - prevError) / Ts;
        controlVariable = Kp * error + Ki * integralVal + Kd * derivative;
        
        prevError = error;
        return controlVariable;
    }
    
    //Interface
    
    @Override
    public void setSampleTime(double Ts) {
        this.Ts = Ts;
    }
}
