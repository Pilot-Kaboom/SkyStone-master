package org.firstinspires.ftc.teamcode;

public abstract class TeleBot extends compiler {
    public Arm arm;
    public Lift lift;
    public Drive drive;
    public Intake intake;
    public Sensors sensor;
    @Override
    public void initiate(){
        arm = new Arm(this);
        lift=new Lift(this);
        drive=new Drive(this);
        intake=new Intake(this);
        sensor=new Sensors(this);
        drive.RunInPower();
        while(!opModeIsActive()){
            lift.resetEC();
            arm.clawcon(false,true);
            arm.elbowcon(false,false,true, false, false);
            arm.wristcon(false,false,true, false,false);

        }
    }
}
