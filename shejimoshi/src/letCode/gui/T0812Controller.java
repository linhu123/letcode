package letCode.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * T0812Controller
 *
 * @author linhu
 * @version 1.0
 * 2020/5/13 13:40
 **/
public class T0812Controller implements Initializable {

    @FXML
    private Button showDateButton;
    @FXML
    private TextField dataTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void showDate(ActionEvent event){
        System.out.println("Button Clicked!");

        Date now= new Date();

        DateFormat df = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
        String dateTimeString = df.format(now);
        // Show in VIEW
        dataTextField.setText(dateTimeString);

    }
}
