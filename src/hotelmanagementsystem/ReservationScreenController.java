/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Deeboo
 */
public class ReservationScreenController implements Initializable {

    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField phone;
    @FXML
    private JFXTextField address;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField duration;
    @FXML
    private JFXTextField numOfPeople;
    @FXML
    private JFXTextField paymentType;
    @FXML
    private JFXTextField roomType;
    @FXML
    private JFXTextField roonNum;
    @FXML
    private JFXTextField startDate;
    @FXML
    private JFXTextField endDate;
    @FXML
    private JFXTextField price;
    @FXML
    private JFXTextField servies;
    @FXML
    private JFXTextField total;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void book(MouseEvent event) {
        
        String Name = name.getText().toString().trim();
        String Phone = phone.getText().toString().trim();
        String Address = address.getText().toString().trim();
        String Email = email.getText().toString().trim();
        String Duration = duration.getText().toString().trim();
        String NumOfPeople = numOfPeople.getText().toString().trim();
        String PaymentType = paymentType.getText().toString().trim();
        String RoomType = roomType.getText().toString().trim();
        String RoomNum = roonNum.getText().toString().trim();
        String StartDate = startDate.getText().toString().trim();
        String EndDate = endDate.getText().toString().trim();
        String Price = price.getText().toString().trim();
        String Servies = servies.getText().toString().trim();
        String Total = total.getText().toString().trim();

        Connection connection = DbConnection.getConnection();
        String sql = "INSERT INTO customers VALUES('"+""+"','"+Name+"','"+Email+"','"+Address+"','"+Phone+"','"+NumOfPeople+"','"+PaymentType+"','"+Duration+"','"+RoomType+"','"+RoomNum+"','"+StartDate+"','"+EndDate+"','"+Price+"','"+Servies+"','"+Total+"')";
        int res = 0;
       
        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
            res =  ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(res>0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Data Inserted");
            alert.setHeaderText("Information Dialog");
            alert.setContentText("Data Inserted Successfully!!");
            alert.showAndWait();
         
        }
    }

    @FXML
    private void print(MouseEvent event) {
    }

    @FXML
    private void cancel(MouseEvent event) {
        Stage home = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("homeScreen.fxml"));
        } catch (Exception e) {
        }
        Stage current = (Stage) name.getScene().getWindow();
        Scene scene = new Scene(root);
        home.setScene(scene);
        home.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        home.show();
    }
    
}
