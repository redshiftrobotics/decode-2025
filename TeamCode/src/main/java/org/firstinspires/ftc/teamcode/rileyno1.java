package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gyroscope;

public class rileyno1 extends LinearOpMode {
    Gyroscope gro;



@Override
public void runOpMode() {
    gro = hardwareMap.get(Gyroscope.class,"gro");
}





}
