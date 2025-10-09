package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp(name = "hunter2")
public class simpleOpMode extends LinearOpMode {

    DcMotor leftFrontDrive;
//    DcMotor leftBackDrive;
    DcMotor rightFrontDrive;
//    DcMotor rightBackDrive;


@Override
public void runOpMode() {

    telemetry.addData("Status:", "Initializing");
    telemetry.update();

    leftFrontDrive = hardwareMap.get(DcMotor.class, "FL");

//    leftBackDrive = hardwareMap.get(DcMotor.class, "BL");

    rightFrontDrive = hardwareMap.get(DcMotor.class, "FR");

//    rightBackDrive = hardwareMap.get(DcMotor.class, "BR");
    telemetry.addData("Status:", "Initialized");
    telemetry.update();
waitForStart();

while (opModeIsActive()) {

    float speed;
    if (gamepad1.right_trigger > 0) {
        speed = gamepad1.right_trigger;
        telemetry.addData("Speed:", speed);
        telemetry.update();
        leftFrontDrive.setPower(speed);
//     leftBackDrive.setPower(speed);
        rightFrontDrive.setPower(speed);
//     rightBackDrive.setPower(speed);

    }
    else if (gamepad1.left_trigger > 0);
        speed = -gamepad1.left_trigger;
        telemetry.addData("Speed:", speed);
        telemetry.update();
        leftFrontDrive.setPower(speed);
//     leftBackDrive.setPower(speed);
        rightFrontDrive.setPower(speed);
//     rightBackDrive.setPower(speed);
}






}

}
