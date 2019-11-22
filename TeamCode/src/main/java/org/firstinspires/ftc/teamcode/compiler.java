package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public abstract class compiler extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        initiate();
        waitForStart();
        run();
    }
    public abstract void initiate();
    public abstract void run();
}
