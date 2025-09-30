package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class simpleOpMode extends LinearOpMode {

    DcMotor leftFrontDrive;
    DcMotor leftBackDrive;
    DcMotor rightFrontDrive;
    DcMotor rightBackDrive;


@Override
public void runOpMode() {


    leftFrontDrive = hardwareMap.get(DcMotor.class, "FL");

    leftBackDrive = hardwareMap.get(DcMotor.class, "BL");

    rightFrontDrive = hardwareMap.get(DcMotor.class, "FR");

    rightBackDrive = hardwareMap.get(DcMotor.class, "BR");



waitForStart();

while (opModeIsActive()) {

   int speed;
   if(gamepad1.left_stick_button) {
       speed = 1;
   }
    else {
        speed = 0;
   }
    leftFrontDrive.setPower(speed);
    leftBackDrive.setPower(speed);
    rightFrontDrive.setPower(speed);
    rightBackDrive.setPower(speed );
}






}

}
