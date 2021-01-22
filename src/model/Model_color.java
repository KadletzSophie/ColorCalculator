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

    }

    public void changeColorViaAbsoluteValue(ColorCode cc, String value) {

    }

    public void changeColorViaAbsoluteValue(ColorCode cc, int value) {

    }


    public void changeColorViaRelativeValue(ColorCode cc, String value) {

    }

    public void changeColorViaRelativeValue(ColorCode cc, int value) {

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
