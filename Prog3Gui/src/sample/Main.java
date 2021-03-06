package sample;

/**
 * This class defines the properties and methods of a
 *
 * @author  Akaash Patel, Yanheng Zhang
 */

import Prog2.StudentList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static StudentList sList = new StudentList();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Prog2Gui.fxml"));
        primaryStage.setTitle("Program 3 - Tuition Manager");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);
    }
}
