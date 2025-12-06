package org.firstinspires.ftc.teamcode;

    public class VelocityPID {
        private double kp; // Proportional gain
        private double ki; // Integral gain
        private double kd; // Derivative gain
        private double integral; // Integral sum
        private double previousError; // Previous error
        private long previousTime; // Previous time

        public VelocityPID(double kp, double ki, double kd) {
            this.kp = kp;
            this.ki = ki;
            this.kd = kd;
            this.integral = 0;
            this.previousError = 0;
            this.previousTime = System.currentTimeMillis();
        }

        public double calculate(double setpoint, double actualVelocity) {
            long currentTime = System.currentTimeMillis();
            double dt = (currentTime - previousTime) / 1000.0; // Delta time in seconds

            // Calculate error
            double error = setpoint - actualVelocity;

            // Calculate integral
            integral += error * dt;

            // Calculate derivative
            double derivative = (error - previousError) / dt;

            // Calculate PID output
            double output = (kp * error) + (ki * integral) + (kd * derivative);

            // Save error and time for next calculation
            previousError = error;
            previousTime = currentTime;

            return output;
        }

        public void reset() {
            integral = 0;
            previousError = 0;
            previousTime = System.currentTimeMillis();
        }
    }

