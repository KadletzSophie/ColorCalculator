package controllerview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.ColorCode;
import model.Model_color;

/**
 * @author Sophie Kadletz
 * @version 21.01.2021
 */

public class Controller {

    private Model_color mc;

    @FXML
    private TextField blue_value;

    @FXML
    private TextField red_value;

    @FXML
    private TextField green_value;

    @FXML
    private Label color;

    @FXML
    private Label hex_value;


    @FXML
    void addTenBlue(ActionEvent event) {
        mc.changeColorViaRelativeValue(ColorCode.BLUE,10);
        blue_value.setText(Integer.toString(mc.getBlue()));
        updateHex();
    }

    @FXML
    void addTenGreen(ActionEvent event) {
        mc.changeColorViaRelativeValue(ColorCode.GREEN,10);
        green_value.setText(Integer.toString(mc.getGreen()));
        updateHex();
    }

    @FXML
    void addTenRed(ActionEvent event) {
        mc.changeColorViaRelativeValue(ColorCode.RED,10);
        red_value.setText(Integer.toString(mc.getRed()));
        updateHex();
    }

    @FXML
    void blueAbsoluteValue(ActionEvent event) {
        mc.changeColorViaAbsoluteValue(ColorCode.BLUE, blue_value.getText());
        blue_value.setText(Integer.toString(mc.getBlue()));
        updateHex();
    }

    @FXML
    void greenAbsoluteValue(ActionEvent event) {
        mc.changeColorViaAbsoluteValue(ColorCode.GREEN, green_value.getText());
        green_value.setText(Integer.toString(mc.getGreen()));
        updateHex();
    }

    @FXML
    void redAbsoluteValue(ActionEvent event) {
        mc.changeColorViaAbsoluteValue(ColorCode.RED, red_value.getText());
        red_value.setText(Integer.toString(mc.getRed()));
        updateHex();
    }

    @FXML
    void subTenBlue(ActionEvent event) {
        mc.changeColorViaRelativeValue(ColorCode.BLUE,-10);
        blue_value.setText(Integer.toString(mc.getBlue()));
        updateHex();
    }

    @FXML
    void subTenRed(ActionEvent event) {
        mc.changeColorViaRelativeValue(ColorCode.RED,-10);
        red_value.setText(Integer.toString(mc.getRed()));
        updateHex();
    }

    @FXML
    void sudTenGreen(ActionEvent event) {
        mc.changeColorViaRelativeValue(ColorCode.GREEN,-10);
        green_value.setText(Integer.toString(mc.getGreen()));
        updateHex();
    }

    private void updateHex(){
        hex_value.setText(mc.getHex());
        color.setStyle("-fx-background-color:"+mc.getHex()+";");
    }

    @FXML
    public void initialize(){
        mc = new Model_color();
    }

}
