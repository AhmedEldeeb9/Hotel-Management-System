/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;


/**
 * FXML Controller class
 *
 * @author Deeboo
 */
public class LoginScreenController implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField password;
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
    private void loginButton(MouseEvent event) {
        
        if(username.getText().toString().equals("")){
            
            Image image = new Image("img/delete.png");
            Notifications notifications = Notifications.create()
                  .title("Error")
                  .text("UserName is Empty")
                  .hideAfter(Duration.seconds(3))
                  .position(Pos.BOTTOM_LEFT)
                   .graphic(new ImageView(image));
                  notifications.darkStyle();
                  notifications.show();
        }
        else if(password.getText().toString().equals("")){
            
            Image image = new Image("img/delete.png");
            Notifications notifications = Notifications.create()
                  .title("Error")
                  .text("Password is Empty")
                  .hideAfter(Duration.seconds(3))
                  .position(Pos.BOTTOM_LEFT)
                   .graphic(new ImageView(image));
                  notifications.darkStyle();
                  notifications.show();
        }
        else {
        boolean isExist = false;
        String userType = "";
        String userPass = "";
        String sql = "select * from users where username='" + username.getText().toString().trim() +"'";
        Connection connection = DbConnection.getConnection();
        try {
            PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            isExist = true;
            userPass = rs.getString(3);
            userType = rs.getString(9);
            
            
            }
            if(isExist){
               
              if(password.getText().toString().trim().equals(userPass)){
                  if(userType.equals("admin")){
                   //if the user is admin goes to admin page
                   Stage adminScreen = new Stage();
                      Parent root = null;
                      try {
                         root = FXMLLoader.load(getClass().getResource("adminScreen.fxml"));
                      } catch (Exception e) {
                          
                      }
                      Stage current = (Stage) username.getScene().getWindow();
                      Scene scene = new Scene(root, 1366, 730);
                      adminScreen.setScene(scene);
                      adminScreen.initStyle(StageStyle.TRANSPARENT);
                      current.hide();
                      adminScreen.show();
                  }
                  else{
                  //if the user is normal user goes to home screen
                    Stage homeScreen = new Stage();
                      Parent root = null;
                      try {
                         root = FXMLLoader.load(getClass().getResource("homeScreen.fxml"));
                      } catch (Exception e) {
                          
                      }
                      Stage current = (Stage) username.getScene().getWindow();
                      Scene scene = new Scene(root, 1366, 730);
                      homeScreen.setScene(scene);
                      homeScreen.initStyle(StageStyle.TRANSPARENT);
                      current.hide();
                      homeScreen.show();
                  
                  }
                }
            
            }
            else {
            Image image = new Image("img/delete.png");
            Notifications notifications = Notifications.create()
                  .title("Error")
                  .text("Check your UserName and Password again")
                  .hideAfter(Duration.seconds(3))
                  .position(Pos.BOTTOM_LEFT)
                   .graphic(new ImageView(image));
                  notifications.darkStyle();
                  notifications.show();
            
            }
        } catch (Exception e) {
        }
        
        
        
    }
    
}

    @FXML
    private void cancelButton(MouseEvent event) {
        
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