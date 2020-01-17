package org.firstinspires.ftc.teamcode;

public abstract class AutoBot extends compiler {
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
        while(!isStarted() && !isStopRequested()){
            lift.resetEC();
            drive.resetEC();
            intake.lift(false,false,false);
            arm.clawcon(false, false,true);
            arm.elbowcon(false,false,true, false, false);
            arm.wristcon(false,false,true, false,false);
            sensor.telem();
            arm.telemetry();
            drive.ECtelem();
            lift.telem();
            intake.telemetry();
            telemetry.update();
        }
    }
}
