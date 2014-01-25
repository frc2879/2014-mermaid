/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frc2879.bender;

import edu.wpi.first.wpilibj.DriverStationLCD;

/**
 * Utilities for managing the Driver Station output window.
 *
 * @author floogulinc
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
    public void sayNOCLEAR(int ln, String msg) {
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
                output.println(DriverStationLCD.Line.kUser1, 1, msg);
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

    public void say(int ln, String msg) {
        clearLine(ln);
        sayNOCLEAR(ln, msg);
    }

    public void clearLine(int line) {
        sayNOCLEAR(line, "                   ");
        output.updateLCD();
    }

    /**
     * Clear the entire output box.
     */
    public void clearOutput() {
        clearLine(1);
        clearLine(2);
        clearLine(3);
        clearLine(4);
        clearLine(5);
        clearLine(6);
    }

}
