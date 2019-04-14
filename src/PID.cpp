#include "PID.hpp"

PID::PID(float Ts, float Ti, float Td, float kp) {
  this->Ts = Ts;
  this->Ti = Ti;
  this->Td = Td;
  this->kp = kp;

  error = 0;
  integral = 0;

  SP = 0;
  PV = 0;
}

PID::PID(float Ts) {
  this->Ts = Ts;

  error = 0;
  integral = 0;

  SP = 0;
  PV = 0;
}

void PID::setPointValue(float SP) {
  this->SP = SP;
}

void PID::setProcessVariableValue(float PV) {
  this->PV = PV;
}

void PID::tunePID(float Ti, float Td, float kp) {
  this->Ti = Ti;
  this->Td = Td;
  this->kp = kp;
}

float PID::runPID() {
  
}

float PID::derivative(float previousError, flaot error) {
  return ((error - previousError)/Ts);
}

void PID::integral(float error) {
  integral += error * Ts;
}
