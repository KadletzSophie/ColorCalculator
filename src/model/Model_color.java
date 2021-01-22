package model;

import java.util.Scanner;

/**
 * @author Sophie Kadletz
 * @version 21.01.2021
 */

public class Model_color {

    private ModularCounter red;
    private ModularCounter green;
    private ModularCounter blue;
    private String hex;

    public static void main(String[] args) {
        
    }

    public Model_color() {
        red = new ModularCounter(256);
        green = new ModularCounter(256);
        blue = new ModularCounter(256);
    }

    public void changeColorViaAbsoluteValue(ColorCode cc, String value) {
        int intValue = Integer.parseInt(value);

        switch (cc) {
            case RED:
                updateModularCounterAbsolute(intValue, red);
                break;

            case GREEN:
                updateModularCounterAbsolute(intValue, green);
                break;

            case BLUE:
                updateModularCounterAbsolute(intValue, blue);
                break;
        }
    }

    public void changeColorViaAbsoluteValue(ColorCode cc, int value) {
        switch (cc) {
            case RED:
                updateModularCounterAbsolute(value, red);
                break;

            case GREEN:
                updateModularCounterAbsolute(value, green);
                break;

            case BLUE:
                updateModularCounterAbsolute(value, blue);
                break;
        }
    }

    private void updateModularCounterAbsolute(int intValue, ModularCounter mc) {
        mc.reset();
        mc.update(intValue);
    }

    public void changeColorViaRelativeValue(ColorCode cc, String value) {
        int intValue = Integer.parseInt(value);
        updateModularCounterRelative(cc, intValue);

    }

    private void updateModularCounterRelative(ColorCode cc, int value) {
        switch (cc) {
            case RED:
                red.update(value);
                break;

            case GREEN:
                green.update(value);
                break;

            case BLUE:
                blue.update(value);
                break;
        }
    }

    public void changeColorViaRelativeValue(ColorCode cc, int value) {
        updateModularCounterRelative(cc, value);
    }

    public int getRed() {
        return red.getValue();
    }

    public int getGreen() {
        return green.getValue();
    }

    public int getBlue() {
        return blue.getValue();
    }

    public String getHex() {
        hex = String.format("#%02x%02x%02x", red.getValue(), green.getValue(), blue.getValue()).toUpperCase();
        return hex;
    }

    @Override
    public String toString() {
        return "Model{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }
}
