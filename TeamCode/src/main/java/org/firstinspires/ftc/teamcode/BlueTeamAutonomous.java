package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous ( name = "Blue Auto", group = " Blue Team")
public class BlueTeamAutonomous extends LinearOpMode {
    private DcMotor motorLeft1 = null;
    private DcMotor motorLeft2 = null;
    private DcMotor motorRight1 = null;
    private DcMotor motorRight2 = null;

    private Servo blockClaw = null;
    private Servo foundationServoFront = null;
    private Servo foundationServoBack = null;


    public void runOpMode() throws InterruptedException {
        motorLeft1 = hardwareMap.dcMotor.get("motorLeft1");
        motorLeft2 = hardwareMap.dcMotor.get("motorLeft2");
        motorRight1 = hardwareMap.dcMotor.get("motorRight1");
        motorRight2 = hardwareMap.dcMotor.get("motorRight2");

        blockClaw = hardwareMap.servo.get("blockClaw");
        foundationServoFront = hardwareMap.servo.get("foundationServoFront");
        foundationServoBack = hardwareMap.servo.get("foundationServoBack");
        motorLeft1.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);

        waitForStart();
        foundationServoUp(100);
        drive(-1,1,1200);


        int motorTicks = 1200;
//oscar is gay :)


    }

    public void drive(double drive, double driveTwo, long time) throws InterruptedException {
        motorLeft1.setPower(driveTwo);
        motorLeft2.setPower(driveTwo);
        motorRight1.setPower(drive);
        motorRight2.setPower(drive);
        Thread.sleep(time);
    }

    public void driveBackwards(double drive, double driveTwo, long time) throws InterruptedException {
        motorLeft1.setPower(drive);
        motorLeft2.setPower(drive);
        motorRight1.setPower(driveTwo);
        motorRight2.setPower(driveTwo);
        Thread.sleep(time);
    }

    public void strafeRight(double drive, double driveTwo, long time) throws InterruptedException {
        motorLeft1.setPower(drive);
        motorLeft2.setPower(driveTwo);
        motorRight1.setPower(driveTwo);
        motorRight2.setPower(drive);
        Thread.sleep(time);
    }



    public void strafeLeft(double drive, double driveTwo, long time) throws InterruptedException {
        motorLeft1.setPower(driveTwo);
        motorLeft2.setPower(drive);
        motorRight1.setPower(drive);
        motorRight2.setPower(driveTwo);
        Thread.sleep(time);
    }

    public void blockClawDown(long time) throws InterruptedException {
        blockClaw.setPosition(0.9);
        Thread.sleep(time);
    }

    public void blockClawUp(long time) throws InterruptedException {
        blockClaw.setPosition(0.0);
        Thread.sleep(time);
    }

    public void foundationServosDown(long time) throws InterruptedException {
        foundationServoFront.setPosition(0.9);
        foundationServoBack.setPosition(0.9);
        Thread.sleep(time);
    }

    public void foundationServoUp(long time) throws InterruptedException {
        foundationServoFront.setPosition(0.0);
        foundationServoBack.setPosition(0.0);
        Thread.sleep(time);
    }

    public void foundationServoDown(long time) throws InterruptedException {
        foundationServoFront.setPosition(0.9);
        foundationServoBack.setPosition(0.9);
        Thread.sleep(time);
    }

    public void setMotorPower(double power1, double power2) {
        motorRight1.setPower(power1);
        motorRight2.setPower(power1);
        motorLeft1.setPower(power2);
        motorLeft2.setPower(power2);
    }

  /* public void drive(int distance1, int distance2, double power1, double power2) throws InterruptedException {
// resetting the encoders value

       motorRight1.setMode(DcMotor.RunMode.RESET_ENCODERS);
       motorLeft1.setMode(DcMotor.RunMode.RESET_ENCODERS);
       motorLeft2.setMode(DcMotor.RunMode.RESET_ENCODERS);
       motorRight2.setMode(DcMotor.RunMode.RESET_ENCODERS);

       /*Setting target posistion */
//        motorRight1.setTargetPosition(distance1);
//        motorRight2.setTargetPosition(distance1);
//        motorLeft1.setTargetPosition(distance2);
//        motorLeft2.setTargetPosition(distance2);
//
////Setting the mode to the run
//        motorRight1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        motorRight2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        motorLeft1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        motorLeft2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//// Setting motor power
//        setMotorPower(power1, power2);
//
//        //Checking if the motor r running
//        while(motorRight1.isBusy() && motorRight2.isBusy() && motorLeft1.isBusy() && motorLeft2.isBusy() &&opModeIsActive()) {
//            //Loop body can be empty
//        }

}
