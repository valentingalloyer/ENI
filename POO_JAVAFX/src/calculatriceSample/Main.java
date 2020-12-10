package calculatriceSample;

import calculatrice.DepassementCapaciteException;
import calculatrice.Operation;
import com.sun.javafx.css.CalculatedValue;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.crypto.spec.PSource;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Calculatrice");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        //launch(args);
        try {
            Operation.ajouter(2000000000, 2000000000);
            Operation.multiplication(20000000, 20000000);
            Operation.soustraire(2422424,-554454545);
        } catch (DepassementCapaciteException e) {
            System.out.println(e);
        }
        System.out.println("Test");
    }
}
