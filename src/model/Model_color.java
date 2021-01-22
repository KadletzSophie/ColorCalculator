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

    public static void main(String[] args)
    {
        Model_color model_color = new Model_color();
        ColorCode cc;
        boolean inputCorrect;
        cc = ColorCode.BLUE;

        while (true)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Menu:");
            System.out.println("a - changeColorViaAbsoluteValue\n" +
                    "r - changeColorViaRelativeValue\n" +
                    "? - view all accessors\n" +
                    "q - quit \n");
            System.out.println("Enter command: ");

            String input = sc.next();
            switch (input)
            {
                case "a":
                    System.out.println("Enter color (red, green or blue):");
                    String color = sc.next();
                    inputCorrect = true;
                    switch (color) {
                        case "red":
                            cc = ColorCode.RED;
                            break;

                        case "green":
                            cc = ColorCode.GREEN;
                            break;

                        case "blue":
                            cc = ColorCode.BLUE;
                            break;

                        default:
                            inputCorrect = false;
                    }

                    if (inputCorrect) {
                        System.out.println("Enter value (0-255):");
                        model_color.changeColorViaAbsoluteValue(cc, sc.nextInt());
                        System.out.println(" \n Red:" + model_color.red + " Green:" + model_color.green.getValue() + " Blue:" + model_color.blue.getValue() +"\n");
                    } else {
                        System.out.println("\n Please enter a valid color (red, green or blue) \n");
                    }
                    break;

                case "r":
                    System.out.println("Enter color (red, green or blue):");
                    String colorrelative = sc.next();
                    inputCorrect = true;
                    switch (colorrelative)
                    {
                        case "red":
                            cc = ColorCode.RED;
                            break;

                        case "green":
                            cc = ColorCode.GREEN;
                            break;

                        case "blue":
                            cc = ColorCode.BLUE;
                            break;

                        default:
                            inputCorrect = false;
                    }

                    if (inputCorrect)
                    {
                        System.out.println("Enter value:");
                        model_color.changeColorViaRelativeValue(cc, sc.nextInt());
                        //System.out.println("Red:" + model_color.red + " Green:" + model_color.green.getValue() + " Blue:" + model_color.blue.getValue());
                        System.out.println(model_color.toString());
                    }
                    else
                    {
                        System.out.println("Wrong input. Please enter a valid input: \n"+
                                "a - changeColorViaAbsoluteValue\n" +
                                "r - changeColorViaRelativeValue\n" +
                                "? - view all accessors\n" +
                                "q - quit");
                    }
                    break;

                case "?":
                    System.out.println("\n Red   = " + model_color.getRed() + "\n Green = " + model_color.getGreen() + "\n Blue  = " + model_color.getBlue() + "\n Hex   = " + model_color.getHex() + "\n");
                    break;

                case "q":
                    System.out.println("Goodbye :)");
                    return;
            }
        }
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
