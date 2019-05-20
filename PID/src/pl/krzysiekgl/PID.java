package pl.krzysiekgl;

public final class PID {
    private int Ts; //sample time in milliseconds
    private double Kp;  //proportional gain
    private double Ki;  //integral gain
    private double Kd;  //derivative gain
    
    private double prevError;
    private double integralVal;
    
    public PID(int sampleTime, double proportionalGain, double integralGain, double derivativeGain) {
        this.Ts = sampleTime;
        this.Kp = proportionalGain;
        this.Ki = integralGain;
        this.Kd = derivativeGain;
        
        prevError = 0;
        integralVal = 0;
    }
    
    public PID(int sampleTime) {
        this(sampleTime, 0, 0, 0);
    }
    
    //PID tuning
    public void setKp(double kp) {
        Kp = kp;
    }
    
    public void setKi(double ki) {
        Ki = ki;
    }
    
    public void setKd(double kd) {
        Kd = kd;
    }
    
    //PID algorithm
    public double calculate(double setPoint, double processValue) { //returns Control Variable
        double controlVariable = 0;
        double error = setPoint - processValue;
        
        //calculations
        integralVal += error;
        double derivative = (error - prevError) / Ts;
        controlVariable = Kp * error + Ki * integralVal + Kd * derivative;
        
        prevError = error;
        return controlVariable;
    }
}
