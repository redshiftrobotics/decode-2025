package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.concurrent.TimeUnit;

@Autonomous(name = "Automode1")
public class Automode1 extends LinearOpMode {

    private final ElapsedTime runtime = new ElapsedTime();

    private DcMotor leftFrontDrive;
    private DcMotor rightFrontDrive;
    private DcMotor leftBackDrive;
    private DcMotor rightBackDrive;

    //Function for driving forward
    public void DriveForward(double power, long durationMillis) {
    //Setting motor power
        leftFrontDrive.setpower(power);
        rightFrontDrive.setpower(power);
        leftBackDrive.setpower(power);
        rightBackDrive.setpower(power);

    try{
        Thread.sleep(durationMillis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Autonomous drive interrupted: " + e.getMessage());
        }

        // Stop the motors
        stopMotors();
    }
    //Function for stopping the motors
    private void StopMotors() {
        leftFrontDrive.setpower(0.0);
        rightFrontDrive.setpower(0.0);
        leftBackDrive.setpower(0.0);
        rightBackDrive.setpower(0.0);
    }

        public static class MotorBob{
            private string name;
            private double power;

            public Motor(string motorBob){
                this.name = Bob;
                this.power = 0.0;
            }
                public void setpower(double power){
                    this.currentpower = power1;
            }


        public double getPower() {
            return currentPower;
        }
    }
    //Making an array for all of the motors
     public static void main(String[] args) {
    
        Motor FL = new Motor("Front Left");
        Motor FR = new Motor("Front Right");
        Motor BL = new Motor("Back Left");
        Motor BR = new Motor("Back Right");

        FourWheelerAutonomous Robot = new FourWheelerAutonomous(FL, FR, BL, BR);

        // Drive forward at 30% power for 5 seconds
        Robot.DriveForward(0.3, 2000);
    }
}


    

   // @Override
    // public void runOpMode() {
    // leftFrontDrive = hardwareMap.get(DcMotor.class, "FL");
    //  rightFrontDrive = hardwareMap.get(DcMotor.class, "FR");


     //telemetry.addData("Status", "Initialized").setRetained(true);
       //telemetry.update();

      //waitForStart();
   //runtime.reset();

    //if (opModeIsActive()) {

            //telemetry.addData("Status", "Run Time: %s", runtime.toString());

            //New movement.
           //waitSeconds(10);

           //driveForwardInches(20);

        }
    }

    //public static void waitSeconds(double seconds) {
      //try {
        //  Thread.sleep(Math.round(seconds * 1000.0));
   //     } catch (InterruptedException e) {
           // Thread.currentThread().interrupt();
      //  }
 //   }


   // public void driveForwardInches(double inchesToGo) {

        // figure out what time it is.
  //  ElapsedTime time1 = new ElapsedTime();


        // turn on the motors.
       // leftFrontDrive.setPower(1);
        //rightFrontDrive.setPower(1);

        // when five seconds have elapsed, turn off motors.
        //double currentMillis = time1.milliseconds(); // Or a similar getter
        //double newMillis = currentMillis + (5 * 1000L); // Add 5 seconds (5000 milliseconds)
        //ElapsedTime time2 = new ElapsedTime(newMillis); // Or a similar setter

        //while (currentMillis < 5000) {
            // do nothing and wait till the 5 elapse
          //  currentMillis = time1.milliseconds();

            //telemetry.addData("Status", "Initialized");
            //telemetry.update();

        }
        //telemetry.addData("Status", "Finished waiting");
       // telemetry.update();

       // leftFrontDrive.setPower(0);
        //rightFrontDrive.setPower(0);



        //leftFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //rightFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        //telemetry.clear();
    }


    //public double ticksToInch(int ticks) {
        //return (ticks * Constants.OdometryConstants.tickInMM) / 25.4;
    }

}
