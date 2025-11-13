package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Automode2")
public class AutomodeAhh2 extends LinearOpMode {

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
        startMotors();


        // go forward for 1 seconds.
        double targetEnd = runtime.milliseconds() + 1000;
        while (runtime.milliseconds() < targetEnd) {
            // do nothing.
        }
        // ElapsedTime endtime = runtime.
        // Duration additionalTime = Duration.ofMillis(3000);
        // turn the motors off.
        stopMotors();

        // turn Right for 1.3 seconds.
        turnMotorsRight();

        targetEnd = runtime.milliseconds() + 1100;
        while (runtime.milliseconds() < targetEnd) {
            // do nothing.
        }

        // go forward for 0.1 seconds.
        startMotors();

        targetEnd = runtime.milliseconds() + 100;
        while (runtime.milliseconds() < targetEnd) {
            // do nothing.
        }

        // turn left for 0.7 seconds.
        turnMotorsLeft();

        targetEnd = runtime.milliseconds() + 1100;
        while (runtime.milliseconds() < targetEnd) {
            // do nothing
        }

        // go forward for 150 milliseconds.
        startMotors();

        targetEnd = runtime.milliseconds() + 100;
        while (runtime.milliseconds() < targetEnd) {
            // do nothing
        }

        // start thrower for 2 seconds.
        startThrower();

        targetEnd = runtime.milliseconds() + 2200;
        while (runtime.milliseconds() < targetEnd) {
            // do nothing
        }
        // ElapsedTime endtime = runtime.
        // Duration additionalTime = Duration.ofMillis(3000);
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
        thrower.setPower(1.9);
    }

    private void turnRightAndLeftStopper() {
        rightStopper.setPower(1.0);
        leftStopper.setPower(1.0);
        return;
    }
}