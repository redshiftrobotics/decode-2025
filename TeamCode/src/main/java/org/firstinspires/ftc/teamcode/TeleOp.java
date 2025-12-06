package org.firstinspires.ftc.teamcode;

import androidx.core.math.MathUtils;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants.TeleOpConstants;
@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "hunter5")
public class TeleOp extends LinearOpMode {

    DcMotor leftFrontDrive;
    DcMotor rightFrontDrive;
    DcMotor thrower;
    CRServo leftStopper;
    CRServo rightStopper;
    Servo rightLED;
    Servo leftLED;
    public boolean firing = false;
    private int previousThrowerTicks = 0;
    private long previousTime = System.currentTimeMillis();
    public double getVelocity(DcMotor motor) {
        int currentTicks = motor.getCurrentPosition();
        long currentTime = System.currentTimeMillis();

        // Calculate time difference in seconds
        double dt = (currentTime - previousTime) / 1000.0;

        // Calculate ticks change since the last check
        double ticksChange = currentTicks - previousThrowerTicks; // or rightMotor for right velocity

        // Update previous values for the next calculation
        previousThrowerTicks = currentTicks;
        previousTime = currentTime;

        // Assuming motor is set to a known conversion factor for your robot
        double ticksPerRevolution = motor.getMotorType().getTicksPerRev(); // Replace with actual ticks per revolution for your motor
        double wheelCircumference = Math.PI * 3.78; // Replace with your wheel diameter in inches
        double velocity = (ticksChange / ticksPerRevolution) * wheelCircumference / dt; // Velocity in inches/sec

        return velocity;
    }
    @Override
    public void runOpMode() {

        telemetry.addData("Status:", "Initializing");
        telemetry.update();

        leftFrontDrive = hardwareMap.get(DcMotor.class, "FL");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "FR");
        thrower = hardwareMap.get(DcMotorEx.class, "T");
        leftStopper = hardwareMap.get(CRServo.class, "LS");
        rightStopper = hardwareMap.get(CRServo.class,"RS");
        rightLED = hardwareMap.get(Servo.class,"RLED");
        leftLED = hardwareMap.get(Servo.class,"LLED");

        leftFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        thrower.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData("Status:", "Initialized");
        telemetry.update();
        VelocityPID velocityPID = new VelocityPID(0, 0, 0);

        waitForStart();
        long startTime = System.currentTimeMillis();
        float throwerSpeed;
        float rightSpeed;
        float leftSpeed;
        boolean slowMode = false;
        throwerSpeed = TeleOpConstants.THROWER_POWER + 0.03F;
        leftLED.setPosition(0);
        rightLED.setPosition(0);
        while (opModeIsActive()) {
            double setpoint = 2000; // Example desired velocity
            double actualVelocity = getVelocity(thrower); // Replace this with actual sensor reading
            throwerSpeed = (float)velocityPID.calculate(setpoint, actualVelocity);

            rightSpeed = (gamepad1.right_trigger*gamepad1.right_trigger) - (gamepad1.left_trigger*gamepad1.left_trigger);
            leftSpeed = (gamepad1.right_trigger*gamepad1.right_trigger) - (gamepad1.left_trigger*gamepad1.left_trigger);
            if (gamepad1.left_stick_x > 0){
                rightSpeed = rightSpeed - gamepad1.left_stick_x;
            }
            if (gamepad1.left_stick_x < 0){
                leftSpeed = leftSpeed + gamepad1.left_stick_x;
            }
            if (gamepad1.xWasPressed()){
                throwerSpeed = TeleOpConstants.THROWER_POWER + 0.03F;
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
            telemetry.update();
            if (System.currentTimeMillis() - startTime > 119500){
                break;
            }

        }
    }
    public void fire() {
        firing = true;
        rightStopper.setPower(-1);
        leftStopper.setPower(1);
        sleep(TeleOpConstants.STOPPER_DELAY);
        rightStopper.setPower(0);
        leftStopper.setPower(0);
        firing = false;
    }
}
