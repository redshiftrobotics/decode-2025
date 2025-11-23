package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Autonomous(name = "Automode3BlueFar")
public class Automode3BlueFar extends LinearOpMode {

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


        // turn the motors on.
        startMotors();


        // go forward for 1 seconds.
        sleep(2700);

        turnMotorsLeft();

        sleep(650);

        startMotors();

        sleep(150);

        startThrower();
        stopMotors();
        sleep(2500);
        fire();
        sleep(2500);
        fire();
        sleep(2500);
        fire();
        sleep(1000);
        fire();
        sleep(1000);

        backMotors();

        sleep(650);

        backMotorLeft();

        sleep(400);

        backMotors();

        sleep(1250);

        // turn the motors off.
        stopMotors();

    }



    private void startMotors() {
        leftFrontDrive.setPower(-0.5);
        rightFrontDrive.setPower(0.5);
    }

    private void stopMotors() {
        leftFrontDrive.setPower(0.0);
        rightFrontDrive.setPower(0.0);
    }
    private void turnMotorsRight() {
        leftFrontDrive.setPower(-0.8);
        rightFrontDrive.setPower(0.0);
    }

    private void turnMotorsLeft() {
        leftFrontDrive.setPower(0.0);
        rightFrontDrive.setPower(0.8);
    }

    private void startThrower() {
        thrower.setPower(Constants.TeleOpConstants.THROWER_POWER);
    }

    private void backMotorLeft() {
        leftFrontDrive.setPower(0.0);
        rightFrontDrive.setPower(-0.8);
    }
    private void backMotorRight() {
        leftFrontDrive.setPower(0.8);
        rightFrontDrive.setPower(0.0);
    }
    private void backMotors() {
        leftFrontDrive.setPower(0.5);
        rightFrontDrive.setPower(-0.5);
    }
    public void fire() {
        rightStopper.setPower(-1);
        leftStopper.setPower(1);
        sleep(Constants.TeleOpConstants.STOPPER_DELAY);
        rightStopper.setPower(0);
        leftStopper.setPower(0);
    }

}




