package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Arm {

    private final Servo wrist;
    private final Servo elbow;
    private final Servo claw;
    private boolean openclaw;
    private boolean elbowback;
    private boolean wristside;
    private double elbowcalibration;
    private double wristcalibration;
    private ElapsedTime time = new ElapsedTime();
    private ElapsedTime elbowtime= new ElapsedTime();
    private ElapsedTime wristtime= new ElapsedTime();
    private final LinearOpMode arm;

    public Arm(LinearOpMode arm){
        wrist = arm.hardwareMap.servo.get("wrist");
        elbow = arm.hardwareMap.servo.get("elbow");
        claw = arm.hardwareMap.servo.get("claw");

        this.arm=arm;
    }
// Wrist Wrist Wrist Wrist Wrist Wrist Wrist Wrist Wrist Wrist Wrist Wrist Wrist
    public void wristcon(boolean side, boolean highenough, boolean init, boolean increase, boolean decrease){
        if(increase&& wristtime.seconds()>.1){
            wristcalibration=wristcalibration+.05;
            wristtime.reset();
        }
        else if(decrease&& wristtime.seconds()>.1){
            wristcalibration=wristcalibration-.05;
            wristtime.reset();
        }
        if(elbowPosition()>.5){
            wrist.setPosition(.45+wristcalibration);
        }
        else{
            wrist.setPosition(.45);
        }
        if (init){
            wrist.setPosition(.45);
        }
    }
    public void cap(){
        elbow.setPosition(.75);
        wrist.setPosition(.37);
    }
    //Elbow Elbow Elbow Elbow Elbow Elbow Elbow Elbow Elbow Elbow Elbow Elbow Elbow
    public void elbowcon(boolean back, boolean highenough, boolean init, boolean increase, boolean decrease){
        if(back&& elbowtime.seconds()>.5){
            elbowback =!elbowback;
            elbowtime.reset();
        }
        else if (back){
            elbowtime.reset();
        }
        if(increase && elbowtime.seconds()>.1){
            elbowcalibration=elbowcalibration+.01;
            elbowtime.reset();
        }
        else if(decrease && elbowtime.seconds()>.1){
            elbowcalibration=elbowcalibration-.01;
            elbowtime.reset();
        }
        if(elbowback && back){
            elbow.setPosition(.95);
        }
        else if (elbowback) {
            elbow.setPosition(.71);
        } else {
            elbow.setPosition(0);
        }
        if(init){
            elbow.setPosition(0);
        }
    }
    public double elbowPosition(){
        return(elbow.getPosition());
    }
    //Claw Claw Claw Claw Claw Claw Claw Claw Claw Claw Claw Claw Claw Claw Claw
    public void clawcon(boolean open, boolean init, boolean autoinit){
        if(open && time.seconds()>.25){
            openclaw = !openclaw;
            time.reset();
        }
        if(openclaw){
            claw.setPosition(.25);
        }
        else{
            claw.setPosition(0);
        }
        if(init){
            openclaw=true;
        }
        else if (autoinit){
            openclaw=false;
        }
    }
    public double clawPosition(){
        return(claw.getPosition());
    }
    public void telemetry(){
        arm.telemetry.addData("wrist position",wrist.getPosition());
        arm.telemetry.addData("elbow position",elbow.getPosition());
        arm.telemetry.addData("claw position",claw.getPosition());

    }

}
