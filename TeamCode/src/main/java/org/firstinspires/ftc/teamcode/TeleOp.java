package org.firstinspires.ftc.teamcode;


import java.util.concurrent.BlockingDeque;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOp",group = "teleop1")
public class TeleOp extends TeleBot {
    @Override
    public void run(){
        while(opModeIsActive()){
            if(gamepad1.dpad_down){
                drive.teledrive(-.1,gamepad1.left_stick_x,gamepad1.right_trigger-gamepad1.left_trigger);
            }
            else if(gamepad1.dpad_up){
                drive.teledrive(.1,gamepad1.left_stick_x,gamepad1.right_trigger-gamepad1.left_trigger);
            }
            else if(gamepad1.dpad_left){
                drive.teledrive(gamepad1.left_stick_y,-.1,gamepad1.right_trigger-gamepad1.left_trigger);
            }
            else if(gamepad1.dpad_right){
                drive.teledrive(gamepad1.left_stick_y,.1,gamepad1.right_trigger-gamepad1.left_trigger);
            }
            else {
                drive.teledrive(-gamepad1.left_stick_y,gamepad1.left_stick_x,gamepad1.right_trigger-gamepad1.left_trigger);

            }

            intake.intake(gamepad2.left_stick_y);
            if(gamepad2.right_trigger>.1 && clawTime.seconds()> 2){
                clawTime.reset();
            }
            else if(clawTime.seconds()<1) {
                intake.lift(true,false,false);
            }
            else if (clawTime.seconds()<1.5){
                arm.clawcon(false,false, true);
            }
            else if (gamepad2.x){
                arm.cap();
                arm.clawcon(gamepad2.left_bumper,false,  false);
                //lift.manual(gamepad2.left_stick_y, arm.elbowPosition()<.5);
                lift.manualmanual(gamepad2.right_stick_y);
            }
            else{
                lift.manualmanual(gamepad2.right_stick_y);
                //lift.manual(gamepad2.right_stick_y, arm.elbowPosition()<.5);
                arm.clawcon(gamepad2.left_bumper,false, false);
                arm.elbowcon(gamepad2.right_bumper,lift.echight()>500, false, false, false);
                arm.wristcon(false,lift.echight()>500, false, gamepad1.left_bumper, gamepad1.right_bumper);

                intake.lift(gamepad1.right_stick_y<-.5,gamepad1.right_stick_x<-.5,gamepad1.right_stick_x>.5);
            }
            /*
            else if(gamepad2.left_trigger>.2){
                lift.grab(gamepad2.left_trigger>.2,arm.elbowPosition()<.5);
                if(lift.echight()<350){
                    arm.clawcon(gamepad2.left_bumper,false, false);
                    arm.elbowcon(gamepad2.right_bumper,lift.echight()>500, false, false,false);
                    //arm.wristcon(false,lift.echight()>500, false, gamepad1.left_bumper, gamepad1.right_bumper);

                }
                else{
                    arm.clawcon(false,true,false);
                    arm.elbowcon(false,false,true, false, false);
                    //arm.wristcon(false,false,true, false, false);
                }

            }
            else{

            }*/
            //lift.manualmanual(gamepad2.right_stick_y);
            arm.telemetry();
            sensor.telem();
            drive.ECtelem();
            lift.telem();
            intake.telemetry();
            telemetry.update();
        }
    }
}
