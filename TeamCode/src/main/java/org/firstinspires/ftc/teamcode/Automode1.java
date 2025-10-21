package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.util.ElapsedTime;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Autonomous(name = "Automode1")
public class Automode1 extends LinearOpMode {

    private final ElapsedTime runtime = new ElapsedTime();

    private DcMotor leftFrontDrive;
    private DcMotor rightFrontDrive;



    @Override
     public void runOpMode() {

        leftFrontDrive = hardwareMap.get(DcMotor.class, "FL");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "FR");

        // turn the motors on.
        startMotors();


        // go forward for 3 seconds.
        double targetEnd = runtime.milliseconds() + 3000;
        while (runtime.milliseconds() < targetEnd) {
            // do nothing.
        }
       // ElapsedTime endtime = runtime.
               // Duration additionalTime = Duration.ofMillis(3000);

        // turn the motors off.
        stopMotors();

        }


    public static void waitSeconds(double seconds) {
        try {
            Thread.sleep(Math.round(seconds * 1000.0));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

        private void startMotors() {
        leftFrontDrive.setPower(1.0);
        rightFrontDrive.setPower(1.0);
            return;
        }
        private void stopMotors() {
            leftFrontDrive.setPower(0.0);
            rightFrontDrive.setPower(0.0);
            return;
        }

    }




