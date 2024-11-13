package com.hospital;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * JavaFX App
 */
public class App extends Application{

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd");
        try
        {
            Date date1 = sdf1.parse("2001.02.02");
            Patient marek = new Patient(1, "Marek", Gender.MAN,date1,"12221323232",Patient_status.CRITICAL_CONDITION);
            marek.displayInfo();
        }
        catch (ParseException e) 
        {
            e.printStackTrace();
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("dupa");
        }
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}