package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name ="RedFoundation", group = "autonomousRed")
public class RedFoundation extends AutoBot {
    @Override
    public void run() {
        /*
        while (drive.rect() < 350 && opModeIsActive()) {
            intake.intake(1);
            drive.teledrive(0,drive.rcontrolp(500,.0005),0);
        }
        intake.intake(0);
        drive.StopMotors();
        drive.resetEC();
        while(drive.fect()<750&& opModeIsActive()){
            intake.lift(true, false,false);
            drive.teledrive(.5*drive.fcontrolp(750,.0005),0,0);
        }
        drive.StopMotors();
        drive.resetEC();
        time.reset();
        while (time.seconds()<1){
            drive.teledrive(.15,0,0);
        }
        drive.StopMotors();
        drive.resetEC();
        time.reset();
        intake.lift(false, false,false);
        sleep(350);
        while(drive.tect()<400 && opModeIsActive()){
            drive.teledrive(-.67,-.67,.5);
        }
        while(drive.tect()<750 && opModeIsActive()){
            drive.teledrive(-.25,-.5,.7);
        }
        drive.StopMotors();
        drive.resetEC();
        time.reset();
        while(drive.fect()<550 && opModeIsActive()){
            drive.teledrive(.75,.5,0);
        }
        while(time.seconds() < .5&& opModeIsActive()){
            drive.teledrive(1,0,0);
        }
        intake.lift(true,false,false);
        drive.StopMotors();
        drive.resetEC();
        time.reset();
        sleep(350);
        while (drive.rect()<1150 && opModeIsActive()){
            drive.teledrive(0,.75,0);
        }
        intake.lift(false,false,false);
        drive.StopMotors();
        drive.resetEC();
        time.reset();
        while (drive.bect()<800&& opModeIsActive()){
            drive.teledrive(-.75,0,0);
        }
        drive.StopMotors();*/
    }
}