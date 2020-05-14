package letCode.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * T0812Main
 *
 * @author linhu
 * @version 1.0
 * 2020/5/13 13:45
 **/
public class T0812Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            // Read file fxml and draw interface.
            Parent root = FXMLLoader.load(getClass()
                    .getResource("./T08_12GUI.fxml"));

            primaryStage.setTitle("My Application");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
//更多请阅读：https://www.yiibai.com/javafx/javafx-tutorial-for-beginners.html

}
