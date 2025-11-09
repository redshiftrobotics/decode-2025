package org.firstinspires.ftc.teamcode;

import androidx.core.math.MathUtils;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import org.firstinspires.ftc.teamcode.Constants.TeleOpConstants;
@TeleOp(name = "hunter5")
public class simpleOpMode extends LinearOpMode {

    DcMotor leftFrontDrive;
    DcMotor rightFrontDrive;
    DcMotor thrower;
    CRServo leftStopper;
    CRServo rightStopper;


    @Override
    public void runOpMode() {

        telemetry.addData("Status:", "Initializing");
        telemetry.update();

        leftFrontDrive = hardwareMap.get(DcMotor.class, "FL");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "FR");
        thrower = hardwareMap.get(DcMotor.class, "T");
        leftStopper = hardwareMap.get(CRServo.class, "LS");
        rightStopper = hardwareMap.get(CRServo.class,"RS");

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
        boolean slowMode = false;
        while (opModeIsActive()) {
            throwerSpeed = TeleOpConstants.THROWER_POWER;
            rightSpeed = (gamepad1.right_trigger*gamepad1.right_trigger) - (gamepad1.left_trigger*gamepad1.left_trigger);
            leftSpeed = (gamepad1.right_trigger*gamepad1.right_trigger) - (gamepad1.left_trigger*gamepad1.left_trigger);
            if (gamepad1.left_stick_x > 0){
                rightSpeed = rightSpeed - gamepad1.left_stick_x;
            }
            if (gamepad1.left_stick_x < 0){
                leftSpeed = leftSpeed + gamepad1.left_stick_x;
            }

            if(gamepad1.bWasPressed()){
                throwerSpeed = 0;
            }
            if (gamepad1.yWasPressed()){
                slowMode = true;
            }
            if (gamepad1.aWasPressed()){
                slowMode = false;
            }
            if(gamepad1.rightBumperWasPressed()){
                fire();
                firing = true;
            }
            else if (gamepad1.rightBumperWasReleased()){
                firing = false;
            }

            if (leftSpeed < 0) {
                leftSpeed = (float)-MathUtils.clamp(leftSpeed, -1, 0.98);
            }
            else{
                leftSpeed = (float)-MathUtils.clamp(Math.abs(leftSpeed), 0.02, 1);
            }

            if (rightSpeed < 0) {
                rightSpeed = (float)MathUtils.clamp(rightSpeed, -1, 0.98);
            }
            else{
                rightSpeed = (float)MathUtils.clamp(Math.abs(rightSpeed), 0.02, 1);
            }
            if (!slowMode) {
                leftFrontDrive.setPower(leftSpeed);
                rightFrontDrive.setPower(rightSpeed);
            }
            else{
                leftFrontDrive.setPower(leftSpeed * TeleOpConstants.SLOW_MODE);
                rightFrontDrive.setPower(rightSpeed * TeleOpConstants.SLOW_MODE);
            }
            thrower.setPower(throwerSpeed);
            telemetry.addData("throwerSpeed", throwerSpeed);
            telemetry.addData("rightSpeed:", rightSpeed);
            telemetry.addData("leftSpeed:", leftSpeed);
            telemetry.addData("direction:", gamepad1.left_stick_x);
            telemetry.addData("firing", firing);
        }
    }
    public void fire() {
        rightStopper.setPower(-1);
        leftStopper.setPower(1);
        sleep(TeleOpConstants.STOPPER_DELAY);
        rightStopper.setPower(0);
        leftStopper.setPower(0);
    }
}
