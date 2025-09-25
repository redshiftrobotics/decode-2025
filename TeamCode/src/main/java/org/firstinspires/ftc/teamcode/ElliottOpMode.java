package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class ElliottOpMode extends LinearOpMode {
    private final DcMotor frontLeft;
    private final DcMotor frontRight;
    private final DcMotor backLeft;
    private final DcMotor backRight;
    @Override
    public void runOpMode() throws InterruptedException {
        frontLeft = hardwareMap.get(DcMotor.class,"frontLeft");

        frontRight = hardwareMap.get(DcMotor.class,"frontRight");

        backLeft = hardwareMap.get(DcMotor.class,"backLeft");

        backRight = hardwareMap.get(DcMotor.class,"backRight");
    }
}
