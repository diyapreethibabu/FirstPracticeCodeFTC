package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp
public class DistanceTask5 extends LinearOpMode {
    @Override
    public void runOpMode() {
        DcMotor motorTest = hardwareMap.get(DcMotor.class, "motorTest");
        Servo servoTest = hardwareMap.get(Servo.class, "servoTest");
        LED redLED = hardwareMap.get(LED.class, "redLED");
        LED greenLED = hardwareMap.get(LED.class, "greenLED");
        DistanceSensor distanceSensor = hardwareMap.get(DistanceSensor.class, "distanceTest");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // Here we are making the motor run forward
            if (distanceSensor.getDistance(DistanceUnit.CM) >= 30 && distanceSensor.getDistance(DistanceUnit.CM) <= 40) {
                motorTest.setPower(0);
                greenLED.enableLight(false);
                redLED.enableLight(false);
                telemetry.addData("Status", "The object is 30-40 cm away");
                telemetry.update();
            } else if (distanceSensor.getDistance(DistanceUnit.CM) < 30) {
                motorTest.setPower(-1);
                redLED.enableLight(true);
                greenLED.enableLight(false);
                telemetry.addData("Status", "The object is less than 30 cm away");
                telemetry.update();
            }
            else{
                motorTest.setPower(0);
                greenLED.enableLight(true);
                redLED.enableLight(false);
                telemetry.addData("Status", "The object is farther than 40 cm away");
                telemetry.update();
            }
        }
    }
}
