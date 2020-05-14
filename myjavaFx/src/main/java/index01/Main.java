package index01;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * Main
 *
 * @author linhu
 * @version 1.0
 * 2020/5/14 8:04
 **/
public class Main extends Application implements EventHandler<ActionEvent> {
    private Button button;
    public void start(Stage primaryStage) throws Exception {
        button = new Button();
        button.setText("click me");
        button.setOnAction(this);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(button);

        Scene scene = new Scene(stackPane, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void handle(ActionEvent event) {
        if (event.getSource() == button){
            System.out.println("Ooooo you clicked me,,,ha ha ha !");
        }
    }
}
