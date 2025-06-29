package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp
public class DistanceSensor extends LinearOpMode {
    private LED redLED;
    private LED greenLED;
    private DcMotor motorTest;
    private com.qualcomm.robotcore.hardware.DistanceSensor distanceSensor;
    private Servo servoTest;

    @Override
    public void runOpMode() {
        motorTest = hardwareMap.get(DcMotor.class, "motorTest");
        servoTest = hardwareMap.get(Servo.class, "servoTest");
        redLED = hardwareMap.get(LED.class, "redLED");
        greenLED = hardwareMap.get(LED.class, "greenLED");
        distanceSensor = hardwareMap.get(com.qualcomm.robotcore.hardware.DistanceSensor.class, "distanceTest");
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            if(distanceSensor.getDistance(DistanceUnit.CM) <= 35) {
                redLED.enableLight(true);
                greenLED.enableLight(false);
            }
            else {
                redLED.enableLight(false);
                greenLED.enableLight(true);
            }
        }
    }
}