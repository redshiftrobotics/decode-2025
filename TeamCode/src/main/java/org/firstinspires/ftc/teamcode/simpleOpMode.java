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


    leftFrontDrive = hardwareMap.get(DcMotor.class, "leftFrontDrive");

    leftBackDrive = hardwareMap.get(DcMotor.class, "leftBackDrive");

    rightFrontDrive = hardwareMap.get(DcMotor.class, "rightFrontDrive");

    rightBackDrive = hardwareMap.get(DcMotor.class, "rightBackDrive");
}

}
