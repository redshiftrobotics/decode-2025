package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Automode2")
public class Automode2 extends LinearOpMode {

    private final ElapsedTime runtime = new ElapsedTime();

    private DcMotor leftFrontDrive;
    private DcMotor rightFrontDrive;

    private DcMotor thrower;

    private CRServo rightStopper;

    private CRServo leftStopper;

    @Override
    public void runOpMode() {

        leftFrontDrive = hardwareMap.get(DcMotor.class, "FL");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "FR");
        thrower = hardwareMap.get(DcMotor.class, "T");
        rightStopper = hardwareMap.get(CRServo.class, "RS");
        leftStopper = hardwareMap.get(CRServo.class, "LS");

        //wait for motors to start.
        waitForStart();
        //turn the motors on.
        backMotors();


        // go forward for 1 seconds.
        double targetEnd = runtime.milliseconds() + 650;
        while (runtime.milliseconds() < targetEnd) {
            // do nothing.
        }
       

        

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
        thrower.setPower(1.9);
    }

    private void turnRightAndLeftStopper() {
        rightStopper.setPower(1.0);
        leftStopper.setPower(1.0);
        return;
    }
    private void backMotors() {
        rightFrontDrive.setPower(0.5);
        leftFrontDrive.setPower(-0.5);
        return;
    }
}