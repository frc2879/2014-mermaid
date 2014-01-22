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
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends SimpleRobot {
    
    RobotDrive drivetrain = new RobotDrive(1,2);
    Joystick controllerthing = new Joystick(1);
    
    // Defining Joystick Mappings:
	public final int Button_X = 1;
	public final int Button_Y = 4;
	public final int Button_A = 2;
	public final int Button_B = 3;
	public final int Button_START = 10;
	public final int Button_BACK = 9;
	public final int Button_RIGHT_BUMPER = 6;
	public final int Button_RIGHT_TRIGGER = 8;
	public final int Button_LEFT_BUMPER = 5;
	public final int Button_LEFT_TRIGGER = 7;
	// Joystick axis(s)
	public final int Stick_LEFT_Y = 2;
	public final int Stick_LEFT_X = 1;
	public final int Stick_RIGHT_X = 4; 
	public final int Stick_RIGHT_Y = 5;
	
	// CONFIG VALUES ~~~~~~~~~
	// ~~~~~~~~~~~~~~~~~~~~~~~
	int HANDICAP = 1;
	boolean SquaredInputs = true;
	// ~~~~~~~~~~~~~~~~~~~~~~~
	// CONFIG VALUES ~~~~~~~~~
	
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        drivetrain.setSafetyEnabled(true);
        while (isOperatorControl() && isEnabled()) {
		
			// Update joystick values:
			float moveL = ((controllerthing.GetRawAxis(Stick_LEFT_Y)) / HANDICAP);
			float spinL = ((controllerthing.GetRawAxis(Stick_LEFT_X)) / HANDICAP);
			
			// Drive da robot:
            drivetrain.arcadeDrive(moveL, spinL, SquaredInputs);
			
            Timer.delay(0.01);
        }
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    
    }
}
