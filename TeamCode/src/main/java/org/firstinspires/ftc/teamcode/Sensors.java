package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Sensors {

    private final DistanceSensor rd;
    private final DistanceSensor ld;
    private final DistanceSensor fd;
    private final DistanceSensor bd;
    private final ColorSensor rc;
    private final ColorSensor lc;
    private final LinearOpMode sensor;

    public Sensors (LinearOpMode sensor){
        bd = sensor.hardwareMap.get(DistanceSensor.class, "bd");
        fd = sensor.hardwareMap.get(DistanceSensor.class, "bd");
        rd = sensor.hardwareMap.get(DistanceSensor.class, "bd");
        ld = sensor.hardwareMap.get(DistanceSensor.class, "bd");
        rc= sensor.hardwareMap.get(ColorSensor.class, "rc");
        lc= sensor.hardwareMap.get(ColorSensor.class, "lc");
        this.sensor=sensor;
    }

    public void telem(){
        sensor.telemetry.addData("front distance", fd.getDistance(DistanceUnit.INCH));
        sensor.telemetry.addData("back distance", bd.getDistance(DistanceUnit.INCH));
        sensor.telemetry.addData("right distance", rd.getDistance(DistanceUnit.INCH));
        sensor.telemetry.addData("left distance", ld.getDistance(DistanceUnit.INCH));
        sensor.telemetry.addData("right red color", rc.red());
        sensor.telemetry.addData("left red color", lc.red());
        sensor.telemetry.addData("right color alpha", (rc.alpha()));
        sensor.telemetry.addData("left color alpha", rc.alpha());
    }


}
