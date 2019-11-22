package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name ="auto", group = "autonomous1")
public class auto extends TeleBot {
          @Override
    public void run() {
        while(opModeIsActive() && drive.bect()>-300){
            drive.teledrive(.5,0,0,0);
        }
        drive.StopMotors(0);

    }
}
