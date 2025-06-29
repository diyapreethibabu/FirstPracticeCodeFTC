/*
    Map the magnetic sensor, and the motor

    Wait until someone presses start to begin the program
    Stop when person presses end program

    If the switch is sensed,
    Then you need to move the motor forward at speed 1

    ELSE
    Turn the motor backward at speed -1

 */
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;

@TeleOp
public class MagneticSensorTask8 extends LinearOpMode {
    @Override
    public void runOpMode() { //Its like the main
        // Mapping
        //DcMotor is the class
        //motor is the object
        //motorTest is the object irl
        //hardwareMap is the function and it is telling which on is the one irl. And it is mapping it
        DcMotor motor = hardwareMap.get(DcMotor.class, "motorTest");
        DigitalChannel magnetTest = hardwareMap.get(DigitalChannel.class, "magnetTest");

        // Set magnetic switch as input, showing that it needs to read from that, and not try to give
        //it any signals
        //magnetTest.setMode(DigitalChannel.Mode.INPUT);

        // Wait for start button to be pressed
        waitForStart();

        // Keep running while the program is active
        while (opModeIsActive()) {
            if (!magnetTest.getState()) {
                motor.setPower(1);
            } else {
                motor.setPower(-1);
            }
        }

        // Stop motor when program ends
        motor.setPower(0);
    }
}
