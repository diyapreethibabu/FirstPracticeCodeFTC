package org.firstinspires.ftc.teamcode;

// Import necessary classes
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.hardware.rev.RevTouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;

@TeleOp
public class RunMotorTask7 extends LinearOpMode {

    @Override
    public void runOpMode() {
        // Map hardware devices to their names in the Robot Configuration
        DcMotor motor = hardwareMap.get(DcMotor.class, "motorTest");
        DigitalChannel touchTest = hardwareMap.get(DigitalChannel.class, "touchTest");
        touchTest.setMode(DigitalChannel.Mode.INPUT);

        // Set the digital channel to input mode for the touch sensor
        // touchTest.isPressed();

        // Send telemetry message to signify robot waiting
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            if (touchTest.getState()) {
                // If touch sensor is pressed, run motor forward at full power
                motor.setPower(1);
            } else {
                // If touch sensor not pressed, run motor backward at full power
                motor.setPower(-1);
            }

            // Optionally send telemetry to monitor sensor state and motor power
            telemetry.addData("Touch Pressed", touchTest.getState() );
            telemetry.addData("Motor Power", motor.getPower());
            telemetry.update();
        }

    }
}

/*
    Map the touch sensor, and the motor

    Wait until someone presses start to begin the program
    Stop when person presses end program

    If the touch sensor is pressed,
    then you need to move the motor forward at speed 1

    ELSE
    Turn the motor backward at speed -1

    End program
    Explore the magnetic switch
 */
