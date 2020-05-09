package main;

import static java.lang.Integer.min;
import java.math.BigInteger;
import java.util.Arrays;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author HAS
 */
public class main extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
  
    }
       @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/start.fxml"));
        stage.setScene(new Scene(root));

        stage.setTitle("insert image");
        stage.show();

    }
}
