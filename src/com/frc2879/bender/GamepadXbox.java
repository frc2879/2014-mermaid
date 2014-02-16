package com.frc2879.bender;

/**
 *
 * @author floogulinc
 */
public class GamepadXbox extends XboxController{

    public GamepadXbox(int port) {
        super(port);
    }
    
    // Defining Joystick Mappings:
    public final int Button_X = 3;
    public final int Button_Y = 4;
    public final int Button_A = 1;
    public final int Button_B = 2;
    public final int Button_START = 8;
    public final int Button_BACK = 7;
    public final int Button_RIGHT_BUMPER = 6;
    //public final int Button_RIGHT_TRIGGER = 8;
    public final int Button_LEFT_BUMPER = 5;
   // public final int Button_LEFT_TRIGGER = 7;
    public final int Button_LEFT_STICK = 11;
    public final int Button_RIGHT_STICK = 12;

    // Joystick axis(s)
    public final int Stick_LEFT_Y = 2;
    public final int Stick_LEFT_X = 1;
    public final int Stick_RIGHT_X = 4;
    public final int Stick_RIGHT_Y = 5;
    public final int Axis_TRIGGER = 3;
    public final int Axis_DPAD = 6;


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
    
    
    public boolean getButtonStateSTART() {
        return getRawButton(Button_START);
    }
    public boolean getButtonStateBACK() {
        return getRawButton(Button_BACK);
    }

    public boolean getButtonStateLeftBumper() {
        return getRawButton(Button_LEFT_BUMPER);
    }

    public boolean getButtonStateRightBumper() {
        return getRawButton(Button_RIGHT_BUMPER);
    }



    /**
     * Return the DPad axis positions.
     */
    public double getDPadX() {
        return getRawAxis(Axis_DPAD);
    }

    
    //Stuff from old logitech class
    
    
    /**
     * DPad Left and Right only WPILIB cannot access the vertical axis of the
     * Logitech Game Controller Dpad
     */
  //  public boolean getDPadLeft() {
   //     double x = getDPadX();
   //     return (x < -0.5);
   // }

    //public boolean getDPadRight() {
   //     double x = getDPadX();
   //     return (x > 0.5);
  //  }


}
