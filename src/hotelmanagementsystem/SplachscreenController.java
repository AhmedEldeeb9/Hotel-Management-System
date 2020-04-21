/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Deeboo
 */
public class SplachscreenController implements Initializable {
    
    private Label label;
    @FXML
    private ImageView image;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FadeTransition fadeTransition = new FadeTransition(javafx.util.Duration.seconds(12),image);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0);
        
        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                Stage loginscreen = new Stage();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
                } 
                catch (Exception e) {
                }
                Stage current = (Stage) image.getScene().getWindow();
                Scene scene = new Scene(root, 720, 600);
                loginscreen.setScene(scene);
                loginscreen.initStyle(StageStyle.TRANSPARENT);  //to hide minimize and close
                current.hide();
                loginscreen.show();
            }
        });
        
        fadeTransition.play();
    }    
    
}
