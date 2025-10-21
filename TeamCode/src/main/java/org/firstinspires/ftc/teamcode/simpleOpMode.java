package org.firstinspires.ftc.teamcode;

import androidx.core.math.MathUtils;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "hunter4")
public class simpleOpMode extends LinearOpMode {

    DcMotor leftFrontDrive;
    DcMotor rightFrontDrive;
    DcMotor thrower;
    Servo leftStopper;
    Servo rightStopper;


    @Override
    public void runOpMode() {

        telemetry.addData("Status:", "Initializing");
        telemetry.update();

        leftFrontDrive = hardwareMap.get(DcMotor.class, "FL");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "FR");
        thrower = hardwareMap.get(DcMotor.class, "T");
        leftStopper = hardwareMap.get(Servo.class, "LS");
        rightStopper = hardwareMap.get(Servo.class,"RS");

//        leftStopper = hardwareMap.get(Servo.class, "LS");
//        rightStopper = hardwareMap.get(Servo.class, "RS");

        telemetry.addData("Status:", "Initialized");
        telemetry.update();

        leftFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        thrower.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        float throwerSpeed = 0;
        float rightSpeed = 0;
        float leftSpeed = 0;
        boolean firing = false;
        while (opModeIsActive()) {

            rightSpeed = (gamepad1.right_trigger*gamepad1.right_trigger) - (gamepad1.left_trigger*gamepad1.left_trigger);
            leftSpeed = (gamepad1.right_trigger*gamepad1.right_trigger) - (gamepad1.left_trigger*gamepad1.left_trigger);
            if (gamepad1.left_stick_x > 0){
                rightSpeed = rightSpeed - gamepad1.left_stick_x;
            }
            if (gamepad1.left_stick_x < 0){
                leftSpeed = leftSpeed + gamepad1.left_stick_x;
            }

            if(gamepad1.x){
                throwerSpeed = gamepad1.right_stick_y;
            }
            if(gamepad1.b){
                throwerSpeed = 0;
            }
            if(gamepad1.rightBumperWasPressed()){
                fire();
                firing = true;
            }
            else if (gamepad1.rightBumperWasReleased()){
                firing = false;
            }

            if (leftSpeed < 0) {
                leftFrontDrive.setPower(-MathUtils.clamp(leftSpeed, 0.02, 1));
            }
            else{
                leftFrontDrive.setPower(-MathUtils.clamp(Math.abs(leftSpeed), 0.02, 1));
            }

            if (rightSpeed < 0) {
                rightFrontDrive.setPower(MathUtils.clamp(rightSpeed, 0.02, 1));
            }
            else{
                rightFrontDrive.setPower(MathUtils.clamp(Math.abs(rightSpeed), 0.02, 1));
            }
            thrower.setPower(throwerSpeed);
            telemetry.addData("rightSpeed:", rightSpeed);
            telemetry.addData("leftSpeed:", leftSpeed);
            telemetry.addData("direction:", gamepad1.left_stick_x);
            telemetry.addData("firing", firing);
            telemetry.update();
        }
    }
    public void fire() {
        if(leftStopper.getPosition() >1 | rightStopper.getPosition() <1){
            leftStopper.setPosition(0);
            rightStopper.setPosition(1);
        }
        else{
            leftStopper.setPosition(1);
            rightStopper.setPosition(0);
        }
    }
}
