package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class DiyaFirstProject extends LinearOpMode {
    private LED ledTest;
    private DcMotor motorTest;
    private Servo servoTest;

    @Override
    public void runOpMode() {
        motorTest = hardwareMap.get(DcMotor.class, "motorTest");
        servoTest = hardwareMap.get(Servo.class, "servoTest");
        ledTest = hardwareMap.get(LED.class, "ledTest");
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            motorTest.setPower(1);
            telemetry.addData("Status", "Running");
            telemetry.update();
            motorTest.setPower(1);
            while (opModeIsActive()) {
                ledTest.enableLight(true);
                waitOneSecond();  // This waits 1 second
                ledTest.enableLight(false);
                waitOneSecond();  // This waits 1 second
            }
        }
    }

    public static void waitOneSecond() {
        try {
            Thread.sleep(1000); // Waits for 1000 milliseconds (1 second)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupted status
            System.out.println("Thread was interrupted.");
        }
    }
}