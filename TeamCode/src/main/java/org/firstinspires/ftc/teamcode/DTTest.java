package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp(name = "DTTest",group = "teleop1")
public class DTTest extends OpMode {


    private DcMotor FLM;
    private DcMotor FRM;
    private DcMotor BLM;
    private DcMotor BRM;
    @Override
    public void init() {
        FLM = hardwareMap.get(DcMotor.class, "FLM");
        FRM = hardwareMap.get(DcMotor.class, "FRM");
        BLM = hardwareMap.get(DcMotor.class, "BLM");
        BRM = hardwareMap.get(DcMotor.class, "BRM");
    }

    @Override
    public void loop() {


        teledrive(gamepad1.left_stick_y, gamepad1.left_stick_x,gamepad1.right_trigger,gamepad1.left_trigger);
    }
    private void teledrive(double forward, double right, double turnCC, double turnC){
        FLM.setPower(-forward + right - turnC + turnCC);
        FRM.setPower(forward + right - turnC + turnCC);
        BLM.setPower(-forward - right  -turnC + turnCC);
        BRM.setPower(forward - right - turnC + turnCC);
    }
}
