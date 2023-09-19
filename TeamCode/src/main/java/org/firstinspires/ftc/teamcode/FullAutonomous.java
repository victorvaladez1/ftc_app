package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class FullAutonomous extends LinearOpMode {

    private DcMotor fl = null;
    private DcMotor bl = null;
    private DcMotor fr = null;
    private DcMotor br = null;

    private DcMotor in;
    private DcMotor car;
    private DcMotor sl;
    private DcMotor sp;


    private Servo box = null;


    public void runOpMode() throws InterruptedException {

        fl = hardwareMap.dcMotor.get("fl"); //This is the front left motor of the robot
        bl = hardwareMap.dcMotor.get("bl"); //This is the back left motor of the robot
        fr = hardwareMap.dcMotor.get("fr"); //This is the front right motor of the robot
        br = hardwareMap.dcMotor.get("br"); //This is the back right motor of the robot

        car = hardwareMap.dcMotor.get("in"); //This is the motor for the intake
        car = hardwareMap.dcMotor.get("car"); //This is the motor for the carousel
        car = hardwareMap.dcMotor.get("sl"); //This is the motor for the linear slide extension
        car = hardwareMap.dcMotor.get("sp"); //This is the motor for the linear slide pivot

        box = hardwareMap.servo.get("box");


        waitForStart();

        drive(-1,-1,1200); // Drive backwards
        drive(0,0,1200); // Stop Driving
        extend(1,1200); // Extend
        extend(0,1200); // Stop Extending
        setServoPosition(-1); // Deploy Box
        extend(-1,1200); // Retract slide
        extend(0,1200); // Stop Retracting



        int motorTicks = 1200;


    }

    public void extend(double power, long time) throws InterruptedException {
        sl.setPower(power);
        Thread.sleep(time);
    }

    public void drive(double drive, double driveTwo, long time) throws InterruptedException {
        fl.setPower(driveTwo);
        bl.setPower(driveTwo);
        fr.setPower(drive);
        br.setPower(drive);
        Thread.sleep(time);
    }

    public void driveBackwards(double drive, double driveTwo, long time) throws InterruptedException {
        fl.setPower(drive);
        bl.setPower(drive);
        fr.setPower(driveTwo);
        br.setPower(driveTwo);
        Thread.sleep(time);
    }

    public void strafeRight(double drive, double driveTwo, long time) throws InterruptedException {
        fl.setPower(drive);
        bl.setPower(driveTwo);
        fr.setPower(driveTwo);
        br.setPower(drive);
        Thread.sleep(time);
    }


    public void strafeLeft(double drive, double driveTwo, long time) throws InterruptedException {
        fl.setPower(driveTwo);
        bl.setPower(drive);
        fr.setPower(drive);
        br.setPower(driveTwo);
        Thread.sleep(time);
    }

    public void spinCarousel(double power, long time) throws InterruptedException {
        car.setPower(power);
        Thread.sleep(time);
    }

    public void setMotorPowerDriveTrain(double power1, double power2) {
        fr.setPower(power1);
        br.setPower(power1);
        fl.setPower(power2);
        bl.setPower(power2);

    }

    public void setMotorPowerIntake(double power1){
        car.setPower(power1);
    }

    public void  setServoPosition(int servoPosition){
        box.setPosition(servoPosition);
    }

}
