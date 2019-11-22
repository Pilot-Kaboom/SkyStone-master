package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Drive {

    private final DcMotor BRM;
    private final DcMotor FLM;
    private final DcMotor BLM;
    private final DcMotor FRM;
    private final LinearOpMode adrive;

    public Drive(LinearOpMode adrive){
        BRM = adrive.hardwareMap.dcMotor.get("brm");
        BLM = adrive.hardwareMap.dcMotor.get("blm");
        FRM = adrive.hardwareMap.dcMotor.get("frm");
        FLM = adrive.hardwareMap.dcMotor.get("flm");

        this.adrive=adrive;

    }

    public void resetEC(){
        FLM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BLM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BRM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FRM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        adrive.idle();
        FLM.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BLM.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BRM.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FRM.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        adrive.idle();
    }
    public void RunInPower(){
        FLM.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        BLM.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        BRM.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        FRM.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        adrive.idle();
    }
    public void goForward(double power){
        FLM.setPower(-power);
        FRM.setPower(power);
        BLM.setPower(-power);
        BRM.setPower(power);
    }
    public void goRight(double power){
        FLM.setPower(-power);
        FRM.setPower(-power);
        BLM.setPower(power);
        BRM.setPower(power);
    }
    public void turnClockwise(double power){
        FLM.setPower(-power);
        FRM.setPower(-power);
        BLM.setPower(-power);
        BRM.setPower(-power);
    }
    public void StopMotors(double stop){
        FLM.setPower(stop);
        FRM.setPower(stop);
        BLM.setPower(stop);
        BRM.setPower(stop);
    }
    public void teledrive(double forward, double right, double turnC, double turnCC){
        FLM.setPower(-forward + right + turnC - turnCC);
        FRM.setPower(forward + right + turnC - turnCC);
        BLM.setPower(-forward - right  +turnC - turnCC);
        BRM.setPower(forward - right + turnC - turnCC);
    }
    public void diaginalFRtoBL(double power){
        FRM.setPower(power);
        BLM.setPower(power);
        FLM.setPower(0);
        BRM.setPower(0);
    }
    public void diaginalFLtoBR(double power){
        FLM.setPower(power);
        BRM.setPower(power);
        FRM.setPower(0);
        BLM.setPower(0);
    }
    /*
     FLM.setPower(gamepad1.left_stick_y + -gamepad1.left_stick_x +(gamepad1.right_stick_y*.35 + -gamepad1.right_stick_x*.35)+ (gamepad1.left_trigger + -gamepad1.right_trigger* .5));
     FRM.setPower(-gamepad1.left_stick_y + -gamepad1.left_stick_x +(-gamepad1.right_stick_y*.35 + -gamepad1.right_stick_x*.35)+ (gamepad1.left_trigger + -gamepad1.right_trigger* .5));
     BRM.setPower(-gamepad1.left_stick_y + gamepad1.left_stick_x +(-gamepad1.right_stick_y*.35 + gamepad1.right_stick_x*.35)+ (gamepad1.left_trigger + -gamepad1.right_trigger* .5));
     BLM.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x +(gamepad1.right_stick_y*.35 + gamepad1.right_stick_x*.35)+ (gamepad1.left_trigger + -gamepad1.right_trigger* .5));

    */

    public int fect(){
        return( FRM.getCurrentPosition()/4 + BRM.getCurrentPosition()/4 + -FLM.getCurrentPosition()/4 +  -BLM.getCurrentPosition() / 4);
    }
    public int bect(){
        return( FLM.getCurrentPosition()/4 +  BLM.getCurrentPosition()/4 + -FRM.getCurrentPosition()/4 + -BRM.getCurrentPosition() / 4);
    }
    public int rect(){
        return( -FLM.getCurrentPosition()/4 +  BLM.getCurrentPosition()/4 + -FRM.getCurrentPosition()/4 + BRM.getCurrentPosition() / 4);
    }
    public int lect(){
        return( FLM.getCurrentPosition()/4 +  -BLM.getCurrentPosition()/4 + FRM.getCurrentPosition()/4 + -BRM.getCurrentPosition() / 4);
    }
    public void ECforward(double distance, double power){
        while(fect() < distance){
            goForward(power);
        }
    }
    public void ECbackward(double distance, double power){
        while(bect() < distance){
            goForward(-power);
        }
    }
    public void ECright(double distance, double power){
        while(rect() < distance){
            goRight(power);
        }
    }
    public void ECleft(double distance, double power){
        while(lect() < distance){
            goRight(-power);
        }
    }
    public void ECtelem() {
        adrive.telemetry.addData("FEC", fect());
        adrive.telemetry.addData("BEC", bect());
        adrive.telemetry.addData("REC", rect());
        adrive.telemetry.addData("LEC", lect());
        adrive.telemetry.addData("FLM", FLM.getCurrentPosition());
        adrive.telemetry.addData("BLM", BLM.getCurrentPosition());
        adrive.telemetry.addData("BRM", BRM.getCurrentPosition());
        adrive.telemetry.addData("FRM", FRM.getCurrentPosition());
        //telemetry.addData("ods", ODS.getLightDetected());
    }
}
