package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import static android.os.SystemClock.sleep;

@TeleOp
public class PurpleTeamTeleOp extends OpMode {

    //---------DRIVE TRAIN MOTORS-------------------------------------------------------------------
    DcMotor fl; //Front Left Motor
    DcMotor fr; //Front Right Motor
    DcMotor bl; //Back Left Motor
    DcMotor br; //Back Right Motor

    //---------INTAKE MOTORS------------------------------------------------------------------------
    DcMotor in; //Compliant Wheel Intake Motor
    DcMotor car; //Carousel Motor
    DcMotor sl; //Linear Slide Extend Motor
    DcMotor sp; //Linear Slide Pivot Motor

    //---------SERVOS-------------------------------------------------------------------------------
    Servo box;

    double flPower, frPower, blPower, brPower;

    @Override
    public void init() {

        // CALLING DRIVE TRAIN MOTORS
        fl = hardwareMap.dcMotor.get("fl");
        fr = hardwareMap.dcMotor.get("fr");
        bl = hardwareMap.dcMotor.get("bl");
        br = hardwareMap.dcMotor.get("br");

        // CALLING INTAKE MOTORS
        in = hardwareMap.dcMotor.get("in");
        car = hardwareMap.dcMotor.get("car");
        sl = hardwareMap.dcMotor.get("sl");
        sp = hardwareMap.dcMotor.get("sp");

        // CALLING SERVOS
        box = hardwareMap.servo.get("box");

        //Setting the right motors to reverse, because they are flipped on the robot.
        fr.setDirection(DcMotorSimple.Direction.REVERSE);
        br.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    @Override
    public void loop() {
        //WHEN THE START BUTTON IS CLICKED, RUN THIS.
        //box.setPosition(.5);
        //DRIVETRAIN CODE---------------------------------------------------------------------------

        //VARIABLES NEEDED FOR DRIVETRAIN
        double y = -gamepad1.left_stick_y; // Y-Axis power to left analog stick.
        double x = gamepad1.left_stick_x * 1.1; // X-Axis power to left analog stick.
        double rx = gamepad1.right_stick_x; // X-Axis power to right analog stick.


        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1); // Math, Math, Math...
        double frontLeftPower = (y + x + rx) / denominator; //Power values of Front Left Motor
        double backLeftPower = (y - x + rx) / denominator; //Power values of Back Left Motor
        double frontRightPower = (y - x - rx) / denominator; //Power values of Front Right Motor
        double backRightPower = (y + x - rx) / denominator; //Power values of Back Right Motor

        fl.setPower(frontLeftPower); //fl is set to frontLeftPower
        bl.setPower(backLeftPower); //bl is set to backLeftPower
        fr.setPower(frontRightPower); //fr is set to frontRightPower
        br.setPower(backRightPower); //br is set to backRightPower

        //INTAKE CODE-------------------------------------------------------------------------------

        // CODE FOR COMPLIANT WHEEL INTAKE
        if (gamepad2.right_trigger > .5) { // If the right trigger is pulled more than halfway, the intake wheel will spin the cargo in
            in.setPower(-1);
        } else if (gamepad2.left_trigger > .5) { // If the left trigger is pulled more than halfway, the intake wheel will spin the cargo out
            in.setPower(1);
        } else { // If neither inputs are pressed more than halfway, the wheel will remain still
            in.setPower(0);
        }
        
        // CODE FOR COMPLIANT WHEEL CAROUSEL
        if (gamepad2.right_bumper == true){ // If the right bumper is pressed, the carousel wheel will spin right
            car.setPower(0.25);
        } else if(gamepad2.left_bumper == true){ // If the left bumper is pressed, the carousel wheel will spin left
            car.setPower(-0.25);
        } else { // If neither inputs are pressed, the carousel wheel will remain still
            car.setPower(0);
        }
        // mohawk warriors purple 8790

        // CODE FOR MOVING THE LINEAR SLIDE UP OR DOWN
        if(gamepad2.dpad_up == true){ //If the dpad up is pressed, the slide will move up
            sl.setPower(0.75);
        } else if(gamepad2.dpad_down == true){ //If the dpad down is pressed, the slide will move down
            sl.setPower(-0.75);
        } else{ // If neither inputs are pressed, the slide will remain still
            sl.setPower(0);
        }

        // CODE FOR PIVOTING THE LINEAR SLIDE
        if(gamepad2.dpad_right == true){ // If the dpad right is pressed, the slide will pivot right
            sp.setPower(0.75);
        } else if(gamepad2.dpad_left == true){ // If the dpad left is pressed, the slide will pivot left
            sp.setPower(-0.75);
        } else{ // If neither inputs are pressed, the slide will remain still
            sp.setPower(0);
           }






        //CODE FOR ROTATING THE BOX
        if(gamepad2.a == true){ // If the A button is pressed, the box will deposit (180 degrees)
            box.setPosition(1);
        }
        else if(gamepad2.b == true) { // If the B button is pressed, the box will return to its original position (0 degrees)
            box.setPosition(0);
        }
            else if(gamepad2.x){ // psbl
                box.setPosition(0.6);
            }
         else if(gamepad2.y == true){ // If the Y button is pressed, the box will be position at 45 degress
            box.setPosition(0.55);
        }

        if(gamepad1.a == true){ // If the A button is pressed, the box will deposit (180 degrees)
            box.setPosition(.8);
        } else if(gamepad1.b == true) { // If the B button is pressed, the box will return to its original position (0 degrees)
            box.setPosition(.2);
        }
        else if(gamepad1.x){
            box.setPosition(0.4);
        }
        else if(gamepad1.y == true){ // If the Y button is pressed, the box will be position at 45 degress
            box.setPosition(0.3);
        }




        // TELEMETRY OUTPUT FOR DRIVETRAIN MOTORS-----------------------
        telemetry.addData("fl", fl.getCurrentPosition());
        telemetry.addData("fr", fr.getCurrentPosition());
        telemetry.addData("bl", bl.getCurrentPosition());
        telemetry.addData("br", br.getCurrentPosition());
        telemetry.update();
    }
}