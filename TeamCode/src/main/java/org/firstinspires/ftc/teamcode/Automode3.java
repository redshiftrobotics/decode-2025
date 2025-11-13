package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Automode3")
public class Automode3 extends LinearOpMode {

    private final ElapsedTime runtime = new ElapsedTime();

    private DcMotor leftFrontDrive;
    private DcMotor rightFrontDrive;

    DcMotor thrower;
    CRServo leftStopper;
    CRServo rightStopper;

    public boolean firing = false;


    @Override
    public void runOpMode() {

        leftFrontDrive = hardwareMap.get(DcMotor.class, "FL");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "FR");
        thrower = hardwareMap.get(DcMotor.class, "T");
        leftStopper = hardwareMap.get(CRServo.class, "LS");
        rightStopper = hardwareMap.get(CRServo.class,"RS");

        // Wait for motors to start
        waitForStart();

        fire1();
        double targetEnd = runtime.milliseconds() + 200;
        while (runtime.milliseconds() < targetEnd) {
            fire2();

            fire2();

            fire2();
        }


        // turn the motors on.
        BackMotors();


        // go forward for 1 seconds.
        targetEnd = runtime.milliseconds() + 550;
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

    private void BackMotors() {
        leftFrontDrive.setPower(0.5);
        rightFrontDrive.setPower(-0.5);
        return;
    }

    private void stopMotors() {
        leftFrontDrive.setPower(0.0);
        rightFrontDrive.setPower(0.0);
        return;
    }

    public void fire1(){
        thrower.setPower(1.8);
    }
    public void fire2() {
        firing = true;
        rightStopper.setPower(-1);
        leftStopper.setPower(1);
        sleep(Constants.TeleOpConstants.STOPPER_DELAY);
        rightStopper.setPower(0);
        leftStopper.setPower(0);
        firing = false;
    }

}




