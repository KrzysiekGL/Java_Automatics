#inlcude <ctime>

class PID {
//PID settings values
  float Ti;
  float Td;
  float kp;

//variables
  float SP; //Set Point - reference value
  float PV; //Process Variable - current value of process which is being monitored
  float CV; //Controll Variable - error ie. SP - PV

//needed variables
  float Ts; //sample time
  float integralValue;

public:
  PID(float Ts, float Ti, float Td, float kp);
  PID(flaot Ts);

  ~PID() {}

  void setPointValue();

  //calculation - return current error
  float runPID();

protected:
  float derivative(float previousError, flaot error);
  float integral(float error);
};
