package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

//@Autonomous(name ="BlueStone", group = "autonomousBlue")
public class BlueStone extends AutoBot {
    private int blockposition;
    @Override
    public void run() {
        /*
        while(opModeIsActive()){
            while(drive.fect()<2000){
                drive.teledrive(drive.fcontrolp(2000, .0075),0,0);
            }
            drive.StopMotors();
            while(sensor.lc()<1000 || sensor.rc()<1000){
                drive.teledrive(.15,0,0);
            }
            drive.StopMotors();
            blockposition=sensor.blockposition();
            drive.resetEC();
            while (drive.fect()>-200){
                drive.teledrive(drive.fcontrolp(-200,.05),0,0);
            }
            drive.StopMotors();
            drive.resetEC();
            while (blockposition==1 && drive.rect()>-500){
                intake.intake(1);
                drive.teledrive(0,drive.rcontrolp(-500,.02),0);
            }
            while (blockposition==2 && drive.rect()>-500){
                intake.intake(1);
                drive.teledrive(0,drive.rcontrolp(100,.02),0);
            }
            while (blockposition==3 && drive.rect()>-500){
                intake.intake(1);
                drive.teledrive(0,drive.rcontrolp(600,.02),0);
            }
            drive.StopMotors();

        }*/


    }
}
