package org.firstinspires.ftc.teamcode;

import androidx.core.math.MathUtils;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "hunter3")
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
        while (opModeIsActive()) {

            rightSpeed = (gamepad1.right_trigger*gamepad1.right_trigger) - (gamepad1.left_trigger*gamepad1.left_trigger);
            leftSpeed = (gamepad1.right_trigger*gamepad1.right_trigger) - (gamepad1.left_trigger*gamepad1.left_trigger);

            telemetry.addData("rightSpeed:", rightSpeed);
            telemetry.addData("leftSpeed", leftSpeed);
            telemetry.update();

            if(gamepad1.xWasPressed()){
                if(throwerSpeed != 0) {
                    throwerSpeed = 0;
                }
                else{
                    throwerSpeed = 0.8F;
                }
                
            }
            //
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
        }
    }
}
