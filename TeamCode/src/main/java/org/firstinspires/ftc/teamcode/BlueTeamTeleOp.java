package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp( name = "BlueTeleOP", group = "BlueTeleOP")

public class BlueTeamTeleOp extends LinearOpMode {

    private DcMotor motorLeftFront;
    private DcMotor motorLeftBack;
    private DcMotor motorRightFront;
    private DcMotor motorRightBack;

    private DcMotor slideMotorRight;
    private DcMotor slideMotorLeft;
    private DcMotor pinionMotor;

    private Servo intakeServo;
    private Servo foundationServoFront;
    private Servo foundationServoBack;



    @Override
    public void runOpMode() throws InterruptedException {
        motorLeftBack = hardwareMap.dcMotor.get("motorLeftBack");
        motorRightFront = hardwareMap.dcMotor.get("motorRightFront");
        motorRightBack = hardwareMap.dcMotor.get("motorRightBack");
        motorLeftFront = hardwareMap.dcMotor.get("motorLeftFront");
        slideMotorLeft = hardwareMap.dcMotor.get("slideMotorLeft");
        slideMotorRight = hardwareMap.dcMotor.get("slideMotorRight");
        pinionMotor = hardwareMap.dcMotor.get("pinionMotor");


        intakeServo = hardwareMap.servo.get("intakeServo");
        foundationServoFront = hardwareMap.servo.get("foundationServoFront");
        foundationServoBack = hardwareMap.servo.get("foundationServoBack");

        motorLeftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorLeftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorRightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorRightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slideMotorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slideMotorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        pinionMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        waitForStart();

        while (opModeIsActive()) {


            if (gamepad1.left_bumper) {
                motorRightFront.setPower(1);
                motorRightBack.setPower(-1);
                motorLeftFront.setPower(-1);
                motorLeftBack.setPower(1);
            }
            if (gamepad1.right_bumper) {
                motorRightFront.setPower(-1);
                motorRightBack.setPower(1);
                motorLeftFront.setPower(1);
                motorLeftBack.setPower(-1);
            }
            if (gamepad1.left_bumper && gamepad1.right_bumper) {
                motorRightFront.setPower(0);
                motorRightBack.setPower(0);
                motorLeftFront.setPower(0);
                motorLeftBack.setPower(0);
            }

            if (gamepad2.left_bumper) {
                slideMotorRight.setPower(-1);
                slideMotorLeft.setPower(1);
            } else if (gamepad2.right_bumper) {
                slideMotorRight.setPower(1);
                slideMotorLeft.setPower(-1);
            } else if (!gamepad2.left_bumper && !gamepad2.right_bumper) {
                slideMotorLeft.setPower(0);
                slideMotorRight.setPower(0);
            }

            if(gamepad2.right_bumper && gamepad2.left_bumper) {
                slideMotorLeft.setPower(0);
                slideMotorRight.setPower(0);
            }

            if (gamepad2.left_trigger < 0){
                pinionMotor.setPower(-1);
            }

            if (gamepad2.right_trigger < 0){
                pinionMotor.setPower(1);
            }

            if (gamepad2.right_trigger < 0 && gamepad2.left_trigger < 0 ){
                pinionMotor.setPower(0);
            }


            if (gamepad2.a == true) {
                intakeServo.setPosition(0.9);
            }

            if (gamepad2.b == true) {
                intakeServo.setPosition(0.0);
            }

            if(gamepad2.x == true){
                foundationServoFront.setPosition(0.9);
                foundationServoBack.setPosition(0.9);
            }

            if(gamepad2.y == true){
                foundationServoFront.setPosition(0.0);
                foundationServoBack.setPosition(0.0);
            }

            motorLeftFront.setPower((gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x));
            motorRightFront.setPower((-gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x));
            motorLeftBack.setPower((gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x));
            motorRightBack.setPower((-gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x));
        }

    }

}
