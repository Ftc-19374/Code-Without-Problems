package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;
@Autonomous(name="Color Sensing")
public class Color extends LinearOpMode {
    ColorSensor s1;
    DcMotor motor1;
    DcMotor motor2;
    DistanceSensor s2;

    @Override
    public void runOpMode() throws InterruptedException {
        // Motors defined
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
        //These sensors defined
        s1 = hardwareMap.get(ColorSensor.class, "ColorSense");
        waitForStart();
        while (opModeIsActive()) {
            // Move motor a little bit
            //Checking yellow value
            if (s1.red() > s1.blue() && s1.green() > s1.blue()) {
                //Moves motors forward
                telemetry.addLine("Yellow");
            }
            else {
                telemetry.addLine("Black");
            }
            telemetry.update();
        }
        motor1.setPower(0.00);
        motor2.setPower(0.00);
    }
}
