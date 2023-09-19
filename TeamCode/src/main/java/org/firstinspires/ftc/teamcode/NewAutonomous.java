package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class NewAutonomous extends LinearOpMode {

    private DcMotor fl = null;
    private DcMotor bl = null;
    private DcMotor fr = null;
    private DcMotor br = null;

    private DcMotor car = null;

    private Servo box = null;


    public void runOpMode() throws InterruptedException {

        fl = hardwareMap.dcMotor.get("fl"); //Front right motor
        bl = hardwareMap.dcMotor.get("bl"); //Back left motor
        fr = hardwareMap.dcMotor.get("fr"); //Front right motor
        br = hardwareMap.dcMotor.get("br"); //Back right motor

        car = hardwareMap.dcMotor.get("car"); //Carousel contraption motor

        box = hardwareMap.servo.get("box"); //Box intake pivot servo


        waitForStart();

        //Test autonomous code: go forward, spin carousel, go backward, go right, go left
        drive(-.65, .65, 1200); //Move forwards
        drive(0,0, 1200); // Stand Still
        drive(-.25,.25,300);
        drive(0,0, 150); // Stand Still
        drive(.5,.5,350);
        drive(0,0,500);
        spinCarousel(-.5, 5200); // Spin Wheel Thingy
        drive(-.2,.2,5200);
        drive(0,0,300);
        driveBackwards(-1, 1, 5200); // Drive backwards

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
