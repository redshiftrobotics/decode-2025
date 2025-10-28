package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Automode1")
public class AutomodeAhh2 extends LinearOpMode {

    private final ElapsedTime runtime = new ElapsedTime();

    private DcMotor leftFrontDrive;
    private DcMotor rightFrontDrive;


    @Override
    public void runOpMode() {

        leftFrontDrive = hardwareMap.get(DcMotor.class, "FL");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "FR");

        // Wait for motors to start
        waitForStart();

        // turn the motors on.
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

        turnMotorsLeft();

        targetEnd = runtime.milliseconds() + 1000;
        while (runtime.milliseconds() < targetEnd) {
            // do nothing.
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
        leftFrontDrive.setPower(-0.5);
        rightFrontDrive.setPower(0.0);
        return;
    }
    private void turnMotorsLeft() {
        leftFrontDrive.setPower(0.0);
        rightFrontDrive.setPower(0.5);
        return;
    }
}



