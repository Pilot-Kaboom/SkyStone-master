package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

public abstract class compiler extends LinearOpMode {
    public ElapsedTime time = new ElapsedTime();
    public ElapsedTime clawTime = new ElapsedTime();
    @Override
    public void runOpMode() throws InterruptedException {
        initiate();
        waitForStart();
        run();
    }
    public abstract void initiate();
    public abstract void run();
}
