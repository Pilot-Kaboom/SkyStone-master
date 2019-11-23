package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name ="BlueFoundation", group = "autonomousBlue")
public class BlueFoundation extends AutoBot {
    @Override
    public void run() {
        while (drive.rect() > -300 && opModeIsActive()) {
            drive.teledrive(0,drive.rcontrolp(-500,.0005),0);
        }
        drive.StopMotors();
        drive.resetEC();
        while(drive.fect()<750&& opModeIsActive()){
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
        while(time.seconds()<.5&& opModeIsActive()){
            intake.intake(1);
        }
        intake.intake(0);
        while(time.seconds()<.5&& opModeIsActive()){
            drive.teledrive(.5,0,0);
        }
        while(time.seconds()<2.5&& opModeIsActive()){
            drive.teledrive(-.33,0,-1);
        }
        drive.StopMotors();
        drive.resetEC();
        time.reset();
        while(time.seconds() < 1&& opModeIsActive()){
            drive.teledrive(1,0,0);
        }
        drive.StopMotors();
    }
}