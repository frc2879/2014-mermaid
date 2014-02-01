/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package com.frc2879.bender;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author floogulinc
 */
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends SimpleRobot {

    RobotDrive drivetrain = new RobotDrive(1, 2);
    Gamepad gp = new Gamepad(1);

    public final String name = "Bender Bot";
    public final String version = "v1.07";
    public final String fullname = name + " " + version;

    // CONFIG VALUES
    int DriveSensitivity = 100;
    int TurnSensitivity = 100;
    boolean SquaredInputs = true;

    DSOutput dsout;

    //Called exactly 1 time when the competition starts.
    protected void robotInit() {
        dsout = new DSOutput();
        System.out.println("Loading " + fullname);
        dsout.say(1, "Welcome to");
        dsout.say(2, fullname);

    }

    boolean pbuttonRB = false;
    boolean pbuttonLB = false;
    boolean pbuttonY = false;
    boolean pbuttonX = false;
    boolean pbuttonDPADL = false;
    boolean pbuttonDPADR = false;

    boolean bumpertoggle = false; //true is turn sensitivity, false for drive

    public void saydrivesensitivity() {
        if (bumpertoggle) {
            dsout.say(2, "DSensitivity: " + Integer.toString(DriveSensitivity));
        } else {
            dsout.say(2, "*DSensitivity: " + Integer.toString(DriveSensitivity));
        }

    }

    public void sayturnsensitivity() {
        if (bumpertoggle) {
            dsout.say(3, "*TSensitivity: " + Integer.toString(TurnSensitivity));
        } else {
            dsout.say(3, "TSensitivity: " + Integer.toString(TurnSensitivity));
        }

    }

    public void saysquaredinputs() {
        dsout.say(4, "Squared Inputs: " + SquaredInputs);
    }

    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        if (isAutonomous()) {
            dsout.clearOutput();
            dsout.say(1, fullname);
            dsout.say(2, "Autonomous Mode");
            Timer time = new Timer();
            time.start();
            while ( time.get() < 1 && isEnabled() && isAutonomous()) {
                drivetrain.drive(-0.3, 0); //Negative goes forward for some reason
                dsout.say(3, "Time: " + time.get());
                Timer.delay(0.01);
            }
            time.stop();
            dsout.say(3, "Time: " + time.get() + " DONE");
            time.reset();
        }
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        drivetrain.setSafetyEnabled(true);
        dsout.clearOutput();
        dsout.say(1, fullname);
        saydrivesensitivity();
        sayturnsensitivity();
        saysquaredinputs();
        while (isOperatorControl() && isEnabled()) {

            // Update joystick values:
            double moveL = (gp.getLeftY() * ((double) (DriveSensitivity) / 100));
            double spinL = (gp.getLeftX() * ((double) (TurnSensitivity) / 100));

            if (gp.getButtonStateRightBumper()) {
                pbuttonRB = true;
            } else if (pbuttonRB && !gp.getButtonStateRightBumper()) {
                if (bumpertoggle) {
                    TurnSensitivity = (TurnSensitivity) + (10);
                    sayturnsensitivity();
                } else {
                    DriveSensitivity = (DriveSensitivity) + (10);
                    saydrivesensitivity();
                }
                pbuttonRB = false;
            }

            if (gp.getButtonStateLeftBumper()) {
                pbuttonLB = true;
            } else if (pbuttonLB && !gp.getButtonStateLeftBumper()) {
                if (bumpertoggle) {
                    TurnSensitivity = (TurnSensitivity) - (10);
                    sayturnsensitivity();
                } else {
                    DriveSensitivity = (DriveSensitivity) - (10);
                    saydrivesensitivity();
                }
                pbuttonLB = false;
            }

            if (gp.getButtonStateY()) {
                pbuttonY = true;
            } else if (pbuttonY && !gp.getButtonStateY()) {
                bumpertoggle = !bumpertoggle;
                saydrivesensitivity();
                sayturnsensitivity();
                pbuttonY = false;
            }

            if (gp.getButtonStateX()) {
                pbuttonX = true;
            } else if (pbuttonX && !gp.getButtonStateX()) {
                SquaredInputs = !SquaredInputs;
                saysquaredinputs();
                pbuttonX = false;
            }

            // Drive da robot:
            drivetrain.arcadeDrive(moveL, spinL, SquaredInputs);

            Timer.delay(0.01);
        }
        
    }
    
    protected void disabled(){
        if(isDisabled()){
            dsout.clearOutput();
            dsout.say(1, fullname);
            dsout.say(2, "Robot Disabled");
        }
    }
    

    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {

    }
}
