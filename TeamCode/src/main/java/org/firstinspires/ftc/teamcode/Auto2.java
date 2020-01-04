package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name ="autoBackward", group = "autonomous1")
public class Auto2 extends AutoBot {
    @Override
    public void run() {
        time.reset();
        while(opModeIsActive() && time.seconds()<.5){
            intake.intake(1);
        }
        intake.intake(0);
        drive.resetEC();
        while(opModeIsActive() && drive.bect()<400){
            drive.teledrive(-.5,0,0);
        }
        drive.StopMotors();

    }
}
