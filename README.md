Control system simulations made in Java
--------------------------
WIP project where user should be able to design (currently) simple control systems and test them in aspects of stability, setting time, overshoot and so on. 

Current state of this project is very-alpha, but in the future I'm looking forward to add the following features:
- [ ] 	GUI
- [ ]	(Real Time) Graphs/Charts
- [ ] 	Autotune methods
- [ ] 	Real Time handling
- 	More system models

As soon as I come up with something more, I'll add it to this list. 

As for now (2019-05-19) there is only an option to fiddle around with PID controller.

Update (2019-05-26):
First simulation model was added. There is a First Order Lag object which was implemented as a digital filter made upon Z-transform using Tustin method(/bilinear method/trapezoidal integration method). Description of usage is in "Small docs" section.

Small docs:
----
Curently there are no advance methods for numerical analysis.
Integral numerical analysis is just a simple rectangle method for both PID and Integral block.
Derivative is calculated by substraction of current and previos value, and the result is divided by the sample time.
