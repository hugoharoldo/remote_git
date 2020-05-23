/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.utils;

import java.awt.event.KeyEvent;

/**
 *
 * @author hugo
 */
public class Events {

    public static void displayInfo(KeyEvent e, String keyStatus) {

        //You should only rely on the key char if the event
        //is a key typed event.
        int id = e.getID();
        String keyString;
        if (id == KeyEvent.KEY_TYPED) {
            char c = e.getKeyChar();
            keyString = "key character = '" + c + "'";
        } else {
            int keyCode = e.getKeyCode();
            keyString = "key code = " + keyCode
                    + " ("
                    + KeyEvent.getKeyText(keyCode)
                    + ")";
        }

        int modifiersEx = e.getModifiersEx();
        String modString = "extended modifiers = " + modifiersEx;
        String tmpString = KeyEvent.getModifiersExText(modifiersEx);
        if (tmpString.length() > 0) {
            modString += " (" + tmpString + ")";
        } else {
            modString += " (no extended modifiers)";
        }

        String actionString = "action key? ";
        if (e.isActionKey()) {
            actionString += "YES";
        } else {
            actionString += "NO";
        }

        String locationString = "key location: ";
        int location = e.getKeyLocation();
        switch (location) {
            case KeyEvent.KEY_LOCATION_STANDARD:
                locationString += "standard";
                break;
            case KeyEvent.KEY_LOCATION_LEFT:
                locationString += "left";
                break;
            case KeyEvent.KEY_LOCATION_RIGHT:
                locationString += "right";
                break;
            case KeyEvent.KEY_LOCATION_NUMPAD:
                locationString += "numpad";
                break;
            default:

                locationString += "unknown";
                break;
        }

        StringBuilder displayArea = new StringBuilder();

        String sp = "    ";
        String newline = "\n";

        displayArea.append(keyStatus).append(newline).append(sp)
                .append(keyString).append(newline).append(sp)
                .append(modString).append(newline).append(sp)
                .append(actionString).append(newline).append(sp)
                .append(locationString).append(newline);

        System.out.println(" \n -->> " + displayArea);
    }

}
