/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Deeboo
 */
public class HomeScreenController implements Initializable {

    @FXML
    private Pane pane3;
    @FXML
    private Pane pane2;
    @FXML
    private Pane pane1;
    @FXML
    private Pane pane4;
    @FXML
    private Pane pane5;
    @FXML
    private StackPane stackpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   

        @FXML
    private void mouse_exit_1(MouseEvent event) {
        pane1.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_hover_1(MouseEvent event) {
        pane1.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }
    
    
    @FXML
    private void mouse_exit_2(MouseEvent event) {
        pane2.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");

    }

    @FXML
    private void mouse_hover_2(MouseEvent event) {
         pane2.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }

 @FXML
    private void mouse_exit_3(MouseEvent event) {
        pane3.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");

    }

    @FXML
    private void mouse_hover_3(MouseEvent event) {
         pane3.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    
    }

    @FXML
    private void mouse_exit_4(MouseEvent event) {
        pane4.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");

    }

    @FXML
    private void mouse_hover_4(MouseEvent event) {
         pane4.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_exit_5(MouseEvent event) {
        pane5.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");

    }

    @FXML
    private void mouse_hover_5(MouseEvent event) {
         pane5.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }

    @FXML
    private void customerScreen(MouseEvent event) {
        Stage customer = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("customerScreen.fxml"));
        } catch (Exception e) {
        }
        Stage current = (Stage) pane1.getScene().getWindow();
        Scene scene = new Scene(root);
        customer.setScene(scene);
        customer.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        customer.show();
    }

    @FXML
    private void roomScreen(MouseEvent event) {
        Stage room = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("roomScreen.fxml"));
        } catch (Exception e) {
        }
        Stage current = (Stage) pane1.getScene().getWindow();
        Scene scene = new Scene(root);
        room.setScene(scene);
        room.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        room.show();
    }

    @FXML
    private void reservationScreen(MouseEvent event) {
       Stage reservation = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("reservationScreen.fxml"));
        } catch (Exception e) {
        }
        Stage current = (Stage) pane1.getScene().getWindow();
        Scene scene = new Scene(root);
        reservation.setScene(scene);
        reservation.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        reservation.show();
    }

    @FXML
    private void logout(MouseEvent event) {
         JFXDialogLayout dialogLayout = new JFXDialogLayout();
        dialogLayout.setHeading(new Text("Alert"));
        dialogLayout.setBody(new Text("Do you Want to Logout !!"));
        JFXButton ok = new JFXButton("Ok");
        JFXButton cancle = new JFXButton("Cancle");
        JFXDialog dialog = new JFXDialog(stackpane, dialogLayout, JFXDialog.DialogTransition.CENTER);
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage home = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        } catch (Exception e) {
        }
        Stage current = (Stage) pane1.getScene().getWindow();
        Scene scene = new Scene(root);
        home.setScene(scene);
        home.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        home.show();
            }
        });
        cancle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               System.exit(0);
            }
        });
        dialogLayout.setActions(ok , cancle);
        dialog.show();
        
    }

    @FXML
    private void exit(MouseEvent event) {
         JFXDialogLayout dialogLayout = new JFXDialogLayout();
        dialogLayout.setHeading(new Text("Close"));
        dialogLayout.setBody(new Text("Do you Want to Close !!"));
        JFXButton ok = new JFXButton("Ok");
        JFXButton cancle = new JFXButton("Cancle");
        JFXDialog dialog = new JFXDialog(stackpane, dialogLayout, JFXDialog.DialogTransition.CENTER);
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        cancle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        dialogLayout.setActions(ok , cancle);
        dialog.show();
    }
    
}
