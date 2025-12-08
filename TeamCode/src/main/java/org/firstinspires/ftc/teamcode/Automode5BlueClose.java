package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Automode5BlueClose")
public class Automode5BlueClose extends LinearOpMode {

    private final ElapsedTime runtime = new ElapsedTime();

    private DcMotor leftFrontDrive;
    private DcMotor rightFrontDrive;

    private DcMotorEx thrower;

    CRServo rightStopper;

    CRServo leftStopper;
    Servo rightLED;
    Servo leftLED;
    @Override
    public void runOpMode() {

        leftFrontDrive = hardwareMap.get(DcMotor.class, "FL");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "FR");
        thrower = hardwareMap.get(DcMotorEx.class, "T");
        rightStopper = hardwareMap.get(CRServo.class, "RS");
        leftStopper = hardwareMap.get(CRServo.class, "LS");
        rightLED = hardwareMap.get(Servo.class,"RLED");
        leftLED = hardwareMap.get(Servo.class,"LLED");
        thrower.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        waitForStart();
        //turn the motors on.
        rightLED.setPosition(0);
        leftLED.setPosition(0);

        startThrower();

        sleep(7300);
        fire();
        sleep(3600);
        fire();
        sleep(2500);
        fire();
        sleep(2500);
        fire();
        sleep(2500);

        backMotors();

        sleep(950);

        backMotorLeft();

        sleep(450);

        backMotors();

        sleep(1000);

        stopMotors();

    }



    private void startMotors() {
        leftFrontDrive.setPower(-0.5);
        rightFrontDrive.setPower(0.5);
        return;
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
        thrower.setVelocity(1150);
        return;
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