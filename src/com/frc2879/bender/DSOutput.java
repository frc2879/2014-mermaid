/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frc2879.bender;

import edu.wpi.first.wpilibj.DriverStationLCD;

/**
 * Utilities for managing the Driver Station output window.
 * <p/>
 * @author Chris Cheng
 * @author Ben
 * @version 2011
 */
public class DSOutput {

    static DriverStationLCD output;

    /**
     * Make a new DSOutput instance. Not hard.
     */
    public DSOutput() {
        output = DriverStationLCD.getInstance();
    }

    /**
     * Display a line of text without scrolling. Max 21 characters / line.
     * <p/>
     * @param ln Which line to print in
     * @param msg What message to display
     */
    public void say(int ln, String msg) {
        if (msg == null) {
            msg = "null message passed";
        }
                // DriverStationLCD.kLineLength=21
        // Add 21 spaces to clear the rest of the line
        msg += "                     ";
        // If the given message is too long, truncate it
        if (msg.length() > 21) {
            msg = msg.substring(0, 21);
        }

        switch (ln) {
            case (1):
                output.println(DriverStationLCD.Line.kMain6, 1, msg);
                break;
            case (2):
                output.println(DriverStationLCD.Line.kUser2, 1, msg);
                break;
            case (3):
                output.println(DriverStationLCD.Line.kUser3, 1, msg);
                break;
            case (4):
                output.println(DriverStationLCD.Line.kUser4, 1, msg);
                break;
            case (5):
                output.println(DriverStationLCD.Line.kUser5, 1, msg);
                break;
            case (6):
                output.println(DriverStationLCD.Line.kUser6, 1, msg);
                break;
        }
        // Show the message
        output.updateLCD();
    }

    /**
     * Clear the entire output box.
     */
    public void clearOutput() {
        say(1, "                   ");
        say(2, "                   ");
        say(3, "                   ");
        say(4, "                   ");
        say(5, "                   ");
        say(6, "                   ");
        output.updateLCD();
    }

    public void clearLine(int line) {
        say(line, "                   ");
        // Show the message
        output.updateLCD();
    }
}
