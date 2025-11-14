package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Automode3Blue")
public class AutomodeAhhhhhh3BlueT extends LinearOpMode {

    private final ElapsedTime runtime = new ElapsedTime();

    private DcMotor leftFrontDrive;
    private DcMotor rightFrontDrive;

    private DcMotor thrower;

    CRServo leftStopper;
    CRServo rightStopper;



    @Override
    public void runOpMode() {

        leftFrontDrive = hardwareMap.get(DcMotor.class, "FL");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "FR");
        thrower = hardwareMap.get(DcMotor.class, "T");
        leftStopper = hardwareMap.get(CRServo.class, "LS");
        rightStopper = hardwareMap.get(CRServo.class,"RS");

        // Wait for motors to start
        waitForStart();

        // turn the motors on.
        startMotors();


        // go forward for 1 seconds.
        double targetEnd = runtime.milliseconds() + 1500;
        while (runtime.milliseconds() < targetEnd) {
            // do nothing.
        }

        turnMotorsLeft();

        targetEnd = runtime.milliseconds() + 1000;
        while (runtime.milliseconds() < targetEnd) {
            // do nothing.
        }

        startMotors();

        targetEnd = runtime.milliseconds() + 650; // change this at the last second. Need to test
        while (runtime.milliseconds() < targetEnd) {
            // do nothing.
        }

        startThrower();

        targetEnd = runtime.milliseconds() + 2500;
        while (runtime.milliseconds() < targetEnd) {
           fire();
           fire();
           fire();
        }

        backMotors();

        targetEnd = runtime.milliseconds() + 600;
        while (runtime.milliseconds() < targetEnd) {
            // do nothing.
        }

        backMotorLeft();

        targetEnd = runtime.milliseconds() + 600;
        while (runtime.milliseconds() < targetEnd) {
            // do nothing.
        }

        backMotors();

        targetEnd= runtime.milliseconds() + 1000;
        while (runtime.milliseconds() < targetEnd) {
            // do nothing.
        }

        // turn the motors off.
        stopMotors();   

    }


    public static void waitSeconds(double seconds) {
        try {
            Thread.sleep(Math.round(seconds * 1000.0));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void startMotors() {
        leftFrontDrive.setPower(-0.5);
        rightFrontDrive.setPower(0.5);
        return;
    }

    private void stopMotors() {
        leftFrontDrive.setPower(0.0);
        rightFrontDrive.setPower(0.0);
        return;
    }
    private void turnMotorsRight() {
        leftFrontDrive.setPower(-0.8);
        rightFrontDrive.setPower(0.0);
        return;
    }

    private void turnMotorsLeft() {
        leftFrontDrive.setPower(0.0);
        rightFrontDrive.setPower(0.8);
        return;
    }

    private void startThrower() {

        thrower.setPower(0.63);
        return;
    }

    private void backMotorLeft() {
        leftFrontDrive.setPower(0.0);
        rightFrontDrive.setPower(-0.8);
        return;
    }
    private void backMotorRight() {
        leftFrontDrive.setPower(0.8);
        rightFrontDrive.setPower(0.0);
        return;
    }
    private void backMotors() {
        leftFrontDrive.setPower(0.5);
        rightFrontDrive.setPower(-0.5);
        return;

    }

    private void fire() {
        rightStopper.setPower(-1);
        leftStopper.setPower(1);
    }

}




