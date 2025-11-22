package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Autonomous(name = "Automode4RedFar")
public class Automode4RedFar extends LinearOpMode {

    private static final Logger log = LoggerFactory.getLogger(Automode4RedFar.class);
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

        stopMotors();

        double targetEnd = runtime.milliseconds() + 1100;
        while (runtime.milliseconds() < targetEnd) {
            // do nothing.
        }

        // turn the motors on.
        startMotors();


        // go forward for 1 seconds.
        targetEnd = runtime.milliseconds() + 2400;
        while (runtime.milliseconds() < targetEnd) {
            // do nothing.
        }

        turnMotorsRight();

        targetEnd = runtime.milliseconds() + 650;
        while (runtime.milliseconds() < targetEnd) {
            // do nothing.
        }

        startMotors();

        targetEnd = runtime.milliseconds() + 150;
        while (runtime.milliseconds() < targetEnd) {
            // do nothing.
        }

        startThrower();

        targetEnd = runtime.milliseconds() + 2500;
        while (runtime.milliseconds() < targetEnd) {
            sleep(250);

            fire();

            waitfire();

            fire();

            waitfire();

            fire();
        }

        backMotors();

        targetEnd = runtime.milliseconds() + 660;
        while (runtime.milliseconds() < targetEnd) {
            // do nothing.
        }

        backMotorRight();

        targetEnd = runtime.milliseconds() + 400;
        while (runtime.milliseconds() < targetEnd) {
            // do nothing.
        }

        backMotors();

        targetEnd= runtime.milliseconds() + 1250;
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
        thrower.setPower(0.61);
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
    public void fire() {
        rightStopper.setPower(-1);
        leftStopper.setPower(1);
    }
    public void waitfire() {
        rightStopper.setPower(0);
        leftStopper.setPower(0);
        return;
    }

}




