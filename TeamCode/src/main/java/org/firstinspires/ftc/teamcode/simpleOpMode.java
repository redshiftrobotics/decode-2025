package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "hunter2")
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
        waitForStart();
        float throwerSpeed = 0;
        float rightSpeed = 0;
        float leftSpeed = 0;
        while (opModeIsActive()) {

            if ((gamepad1.right_trigger > 0) || (gamepad1.left_trigger >0)) {
                rightSpeed = gamepad1.right_trigger;
                leftSpeed = gamepad1.left_trigger;
                telemetry.addData("rightSpeed:", rightSpeed);
                telemetry.addData("leftSpeed", leftSpeed);
                telemetry.update();
                updateMotors(rightSpeed, leftSpeed, throwerSpeed);


            }
            else{
                updateMotors(rightSpeed,leftSpeed,throwerSpeed);
            }
            if(gamepad1.x){
                if(throwerSpeed != 0) {
                    throwerSpeed = 0;
                }
                else{
                    throwerSpeed = 0.5F;
                }
                updateMotors(0,0,throwerSpeed);
            }
        }






}

    private void updateMotors(float rightSpeed, float leftSpeed, float throwerSpeed) {
        rightFrontDrive.setPower(rightSpeed);
        leftFrontDrive.setPower(leftSpeed);
        thrower.setPower(throwerSpeed);
    }


}
