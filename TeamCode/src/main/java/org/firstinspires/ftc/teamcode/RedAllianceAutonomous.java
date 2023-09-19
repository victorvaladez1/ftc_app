package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class RedAllianceAutonomous extends LinearOpMode {

    private DcMotor fl = null;
    private DcMotor bl = null;
    private DcMotor fr = null;
    private DcMotor br = null;

    private DcMotor car = null;

    private Servo box = null;


    public void runOpMode() throws InterruptedException {

        fl = hardwareMap.dcMotor.get("fl");
        bl = hardwareMap.dcMotor.get("bl");
        fr = hardwareMap.dcMotor.get("fr");
        br = hardwareMap.dcMotor.get("br");

        car = hardwareMap.dcMotor.get("car");

        box = hardwareMap.servo.get("box");


        waitForStart();

        //Test autonomous code: go forward, spin carousel, go backward, go right, go left
        drive(-1, 1, 1200); //Move forwards
        drive(0,0, 1200); // Stand Still
        spinCarousel(-.5, 5200); // Spin Wheel Thingy
        driveBackwards(-1, 1, 4500); // Drive backwards

        int motorTicks = 1200;


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