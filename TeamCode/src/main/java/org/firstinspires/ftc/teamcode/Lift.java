package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.sql.Time;

public class Lift {

    private final DcMotor left;
    private final DcMotor right;
    private final LinearOpMode lift;
    private int level;
    private int manual;
    private boolean down;
    private boolean dTimeOp;
    private double dCount1;
    private double dCount2;
    private ElapsedTime armreallyready = new ElapsedTime();
    private ElapsedTime highttime = new ElapsedTime();
    private ElapsedTime manualtime= new ElapsedTime();
    private ElapsedTime grabtime = new ElapsedTime();
    private ElapsedTime Dtime = new ElapsedTime();

    public Lift (LinearOpMode lift){
        left = lift.hardwareMap.dcMotor.get("leftlift");
        right = lift.hardwareMap.dcMotor.get("rightlift");
        this.lift=lift;
    }
    public void manualmanual(double power){
        right.setPower(-power);
        left.setPower(power);
    }
    public void manual(double input, boolean inside){
        if(input>.1 && manualtime.seconds()>.05){
            manual = manual-75;
            manualtime.reset();
        }
        else if(input<-.1&& manualtime.seconds()>.05){
            manual = manual+75;
            manualtime.reset();
        }
        if(manual<-150){
            manual=-150;
        }
        driver(manual, false, inside);
    }
    public void hight(boolean up, boolean down){
        if(up && highttime.seconds()>.25){
            level = level+1;
            highttime.reset();
        }
        else if(down && highttime.seconds()>.25){
            level = level-1;
            highttime.reset();
        }
        //controller(level);

    }
    private void driver(double goal, boolean reset, boolean inside){
        if(pControl(goal)>1){
            left.setPower(-1);
            right.setPower(1);
        }
        else if(reset && pControl(goal)<-.5){
            left.setPower(.5);
            right.setPower(-.5);
        }
        else if(inside && pControl(goal)<-.4){
            left.setPower(.4);
            right.setPower(-.4);
        }
        else if(!inside && pControl(goal)<-.1){
            left.setPower(.1);
            right.setPower(-.1);
        }
        else{
            left.setPower(-1*(pControl(goal)));
            right.setPower(pControl(goal));
        }
    }
    private double pControl(double goal){
        return((goal-right.getCurrentPosition())*.0075);
    }
    private double dControl(){
        if (right.getCurrentPosition()>dCount1||right.getCurrentPosition()<dCount1){
            dCount2=((right.getCurrentPosition()-dCount1)/Dtime.seconds()*-.0005);
            dCount1=right.getCurrentPosition();
            Dtime.reset();
        }
        else{
            dCount2=0;
        }
        return(dCount2);
    }
    /*
    private void controller(int high){
        if(high == 1){
            driver(2);
        }
        else if(high==2){
            driver(17);
        }

    }*/
    public void grab(boolean close, boolean armready){
        if(!armready) {
            driver(450, true, false);
            manual=450;
            armreallyready.reset();
        }
        else if(armreallyready.seconds()>1){
            driver(150, true, false);
            manual=150;
        }
        else{
            driver(450, true, false);
            manual=450;
        }
    }
    public void resetEC(){
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lift.idle();
        right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public double echight(){
        return (right.getCurrentPosition());
    }
    public void telem(){
        lift.telemetry.addData("velocity", dControl());
        lift.telemetry.addData("manual delta", manual-right.getCurrentPosition());
        lift.telemetry.addData("lift hight",right.getCurrentPosition());
    }


}
