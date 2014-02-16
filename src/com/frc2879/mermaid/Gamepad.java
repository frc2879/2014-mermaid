package com.frc2879.mermaid;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * Contains functions for use with the Logitech F310 controller.
 *
 * @author floogulinc
 */
public class Gamepad extends Joystick {

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
    public final int Button_LEFT_STICK = 11;
    public final int Button_RIGHT_STICK = 12;
    public final int Button_MODE = -1;
    public final int Button_LOGITECH = -1;
    // Joystick axis(s)
    public final int Stick_LEFT_Y = 2;
    public final int Stick_LEFT_X = 1;
    public final int Stick_RIGHT_X = 4;
    public final int Stick_RIGHT_Y = 5;
    public final int Axis_TRIGGER = 3;
    public final int Axis_DPAD = 6;

    public Gamepad(int port) {
        super(port);
    }

    /**
     * Returns the X position of the left stick.
     */
    public double getLeftX() {
        return getRawAxis(Stick_LEFT_X);
    }

    /**
     * Returns the X position of the right stick.
     */
    public double getRightX() {
        return getRawAxis(Stick_RIGHT_X);
    }

    /**
     * Returns the Y position of the left stick.
     */
    public double getLeftY() {
        return getRawAxis(Stick_LEFT_Y);
    }

    /**
     * Returns the Y position of the right stick.
     */
    public double getRightY() {
        return getRawAxis(Stick_RIGHT_Y);
    }

    /**
     * Checks whether Button A is being pressed and returns true if it is.
     */
    public boolean getButtonStateA() {
        return getRawButton(Button_A);
    }

    /**
     * Checks whether Button B is being pressed and returns true if it is.
     */
    public boolean getButtonStateB() {
        return getRawButton(Button_B);
    }

    /**
     * Checks whether Button X is being pressed and returns true if it is.
     */
    public boolean getButtonStateX() {
        return getRawButton(Button_X);
    }

    /**
     * Checks whether Button Y is being pressed and returns true if it is.
     */
    public boolean getButtonStateY() {
        return getRawButton(Button_Y);
    }

    public boolean getButtonStateLeftBumper() {
        return getRawButton(Button_LEFT_BUMPER);
    }

    public boolean getButtonStateRightBumper() {
        return getRawButton(Button_RIGHT_BUMPER);
    }

    /**
     * Returns an object of Button A.
     */
    public JoystickButton getButtonA() {
        return new JoystickButton(this, Button_A);
    }

    /**
     * Returns an object of Button B.
     */
    public JoystickButton getButtonB() {
        return new JoystickButton(this, Button_B);
    }

    /**
     * Returns an object of Button X.
     */
    public JoystickButton getButtonX() {
        return new JoystickButton(this, Button_X);
    }

    /**
     * Returns an object of Button Y.
     */
    public JoystickButton getButtonY() {
        return new JoystickButton(this, Button_Y);
    }

    /**
     * Return the DPad axis positions.
     */
    public double getDPadX() {
        return getRawAxis(Axis_DPAD);
    }

    /**
     * DPad Left and Right only WPILIB cannot access the vertical axis of the
     * Logitech Game Controller Dpad
     */
    public boolean getDPadLeft() {
        double x = getDPadX();
        return (x < -0.5);
    }

    public boolean getDPadRight() {
        double x = getDPadX();
        return (x > 0.5);
    }

    /**
     * Gets the state of the Start button
     *
     * @return the state of the Start button
     */
    public JoystickButton getStartButton() {
        return new JoystickButton(this, Button_START);
    }

    public JoystickButton getBackButton() {
        return new JoystickButton(this, Button_BACK);
    }

    /**
     * Gets the state of the left shoulder
     *
     * @return the state of the left shoulder
     */
    public JoystickButton getLeftBumper() {
        return new JoystickButton(this, Button_LEFT_BUMPER);
    }

    /**
     * Gets the state of the right shoulder
     *
     * @return the state of the right shoulder
     */
    public JoystickButton getRightBumper() {
        return new JoystickButton(this, Button_RIGHT_BUMPER);
    }

    public JoystickButton getLeftStickClick() {
        return new JoystickButton(this, Button_LEFT_STICK);
    }

    public JoystickButton getRightStickClick() {
        return new JoystickButton(this, Button_RIGHT_STICK);
    }

    public JoystickButton getLeftTriggerClick() {
        return new JoystickButton(this, Button_LEFT_TRIGGER);
    }

    public JoystickButton getRightTriggerClick() {
        return new JoystickButton(this, Button_RIGHT_TRIGGER);
    }

}
