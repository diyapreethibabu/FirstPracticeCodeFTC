package org.firstinspires.ftc.teamcode;

// Import necessary classes
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class ColorSensorsTask6 extends LinearOpMode {
    @Override
    public void runOpMode() {
        // Connect each hardware part to its configuration name in the Driver Hub
        DcMotor motorTest = hardwareMap.get(DcMotor.class, "motorTest");
        Servo servoTest = hardwareMap.get(Servo.class, "servoTest");
        LED redLED = hardwareMap.get(LED.class, "redLED");
        LED greenLED = hardwareMap.get(LED.class, "greenLED");
        DistanceSensor distanceSensor = hardwareMap.get(DistanceSensor.class, "distanceTest");
        ColorSensor colorTest = hardwareMap.get(ColorSensor.class, "colorTest");

        // Display "Initialized" message on the Driver Station
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for driver to press the START button
        waitForStart();

        // This loop runs as long as the program is active (until STOP is pressed)
        while (opModeIsActive()) {
            // Read red and green values from the color sensor
            int red = colorTest.red();
            int green = colorTest.green();

            // If red is stronger than green and not too weak
            if (red > green && red > 200) {
                redLED.enable(true);   // Turn on red LED
                greenLED.enable(false); // Turn off green LED
            }
            // If green is stronger than red and not too weak
            else if (green > red && green > 200) {
                greenLED.enable(true);  // Turn on green LED
                redLED.enable(false);   // Turn off red LED
            }
            // If no strong color is detected
            else {
                redLED.enable(false);   // Turn off both LEDs
                greenLED.enable(false);
            }

            // Show color values on the Driver Station screen
            telemetry.addData("Red", red);
            telemetry.addData("Green", green);
            telemetry.update();
        }

        // After STOP is pressed: turn off all LEDs to end the program
        redLED.enable(false);
        greenLED.enable(false);
    }
}
