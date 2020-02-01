package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Drive {

    private final DcMotor BRM;
    private final DcMotor FLM;
    private final DcMotor BLM;
    private final DcMotor FRM;
    private double startx;
    private double distance;
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
    public void StopMotors(){
        FLM.setPower(0);
        FRM.setPower(0);
        BLM.setPower(0);
        BRM.setPower(0);
    }

    public double odoHeadding(){
        return((FRM.getCurrentPosition()-FLM.getCurrentPosition())*.01);
    }
    public double odoForward(){
        return(((FRM.getCurrentPosition()+FLM.getCurrentPosition())*.5)*.01);
    }
    public double odoRight(){
        return(((BRM.getCurrentPosition())-(odoHeadding()*.5))*.01);
    }
    public double odoX(){
        return ((odoRight()*Math.cos(odoHeadding()))+(odoForward()*Math.sin(odoHeadding())))+startx;
    }
    public double odoY(){
        return((odoForward()*Math.cos(odoHeadding()))+(odoRight()*Math.sin(odoHeadding())));
    }
    public void odoDrive(double x, double y,double headding){
        distance=((Math.sqrt((x*x)+(y*y)))-(Math.sqrt((odoX()*odoX())+(odoY()*odoY()))));
        if(distance<10){

        }
        else{

        }
    }
    public void teledrive(double forward, double right, double turnC){
        FLM.setPower(forward + right + turnC);
        FRM.setPower(-forward + right + turnC);
        BLM.setPower(forward - right  +turnC);
        BRM.setPower(-forward - right + turnC);
    }
    public void ECtelem() {

        adrive.telemetry.addData("FLM", FLM.getCurrentPosition());
        adrive.telemetry.addData("BLM", BLM.getCurrentPosition());
        adrive.telemetry.addData("BRM", BRM.getCurrentPosition());
        adrive.telemetry.addData("FRM", FRM.getCurrentPosition());
        /*adrive.telemetry.addData("FEC", fect());
        adrive.telemetry.addData("BEC", bect());
        adrive.telemetry.addData("REC", rect());
        adrive.telemetry.addData("LEC", lect());
        adrive.telemetry.addData("TEC",tect());*/
        //telemetry.addData("ods", ODS.getLightDetected());
    }
    /*
     FLM.setPower(gamepad1.left_stick_y + -gamepad1.left_stick_x +(gamepad1.right_stick_y*.35 + -gamepad1.right_stick_x*.35)+ (gamepad1.left_trigger + -gamepad1.right_trigger* .5));
     FRM.setPower(-gamepad1.left_stick_y + -gamepad1.left_stick_x +(-gamepad1.right_stick_y*.35 + -gamepad1.right_stick_x*.35)+ (gamepad1.left_trigger + -gamepad1.right_trigger* .5));
     BRM.setPower(-gamepad1.left_stick_y + gamepad1.left_stick_x +(-gamepad1.right_stick_y*.35 + gamepad1.right_stick_x*.35)+ (gamepad1.left_trigger + -gamepad1.right_trigger* .5));
     BLM.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x +(gamepad1.right_stick_y*.35 + gamepad1.right_stick_x*.35)+ (gamepad1.left_trigger + -gamepad1.right_trigger* .5));

    */
/*
    public int bect(){
        return( FRM.getCurrentPosition()/4 + BRM.getCurrentPosition()/4 + -FLM.getCurrentPosition()/4 +  -BLM.getCurrentPosition() / 4);
    }
    public int fect(){
        return( FLM.getCurrentPosition()/4 +  BLM.getCurrentPosition()/4 + -FRM.getCurrentPosition()/4 + -BRM.getCurrentPosition() / 4);
    }
    public int lect(){
        return( -FLM.getCurrentPosition()/4 +  BLM.getCurrentPosition()/4 + -FRM.getCurrentPosition()/4 + BRM.getCurrentPosition() / 4);
    }
    public int rect(){
        return( FLM.getCurrentPosition()/4 +  -BLM.getCurrentPosition()/4 + FRM.getCurrentPosition()/4 + -BRM.getCurrentPosition() / 4);
    }
    public int tect(){
        return( (FLM.getCurrentPosition()/4 +  BLM.getCurrentPosition()/4) + (FRM.getCurrentPosition()/4 +BRM.getCurrentPosition() / 4));

    }
    public double fcontrolp(double goal, double tune){
        if(goal-(rect())*tune>1){
            return 1;
        }
        else if(goal-(rect())*tune<-1){
            return -1;
        }
        else{
            return ((goal-rect())*tune);
        }
    }
    public double rcontrolp(double goal, double tune){
        if((goal-fect())*tune>1){
            return 1;
        }
        else if((goal-fect())*tune<-1){
            return -1;
        }
        else{
            return ((goal-fect())*tune);
        }
    }*/
    /*
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
    }*/

}
