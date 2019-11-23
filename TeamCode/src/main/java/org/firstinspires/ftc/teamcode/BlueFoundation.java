package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name ="auto", group = "autonomousBlue")
public class BlueFoundation extends TeleBot {
    @Override
    public void run() {
        while(opModeIsActive()){
            while (drive.rect() > -500) {
                drive.teledrive(0,drive.rcontrolp(-500,.0075),0);
            }
            drive.StopMotors();
            drive.resetEC();
            while(drive.fect()<2000){
                drive.teledrive(drive.fcontrolp(2000,.0075),0,0);

            }
            drive.StopMotors();
            drive.resetEC();
            time.reset();
            while(time.seconds()<1){
                intake.intake(1);
            }
            while(gyro.cutout(-90,5)){
                drive.teledrive(-1,0,-1);
            }

        }

    }
}