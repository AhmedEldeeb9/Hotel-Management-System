/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Deeboo
 */
public class RoomScreenController implements Initializable {
    String status = null; 
    @FXML
    private JFXTreeTableView<Room> treeview;
    @FXML
    private JFXTextField searc_text;
    @FXML
    private JFXCheckBox busy;
    @FXML
    private JFXCheckBox available;
    @FXML
    private StackPane stackpane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadAllRooms("SELECT * FROM rooms");
    }    
    
    public void loadAllRooms(String sql){
    
        JFXTreeTableColumn<Room , String> room_id = new JFXTreeTableColumn<>("Room Id");
        room_id.setPrefWidth(100);
        room_id.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Room, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Room, String> param) {
                
                return param.getValue().getValue().id;
            }
        });
        
                JFXTreeTableColumn<Room , String> room_type = new JFXTreeTableColumn<>("Room Type");
        room_type.setPrefWidth(110);
        room_type.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Room, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Room, String> param) {
                
                return param.getValue().getValue().roomType;
            }
        });
        
        JFXTreeTableColumn<Room , String> room_number = new JFXTreeTableColumn<>("Room Number");
        room_number.setPrefWidth(110);
        room_number.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Room, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Room, String> param) {
                
                return param.getValue().getValue().roomNumber;
            }
        });
        
                JFXTreeTableColumn<Room , String> num_of_people = new JFXTreeTableColumn<>("Num Of People");
        num_of_people.setPrefWidth(130);
        num_of_people.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Room, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Room, String> param) {
                
                return param.getValue().getValue().numberOfPeople;
            }
        });
        
                JFXTreeTableColumn<Room , String> floor_number = new JFXTreeTableColumn<>("Floor Number");
        floor_number.setPrefWidth(120);
        floor_number.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Room, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Room, String> param) {
                
                return param.getValue().getValue().floorNumber;
            }
        });
        
                JFXTreeTableColumn<Room , String> room_phone = new JFXTreeTableColumn<>("Room Phone");
        room_phone.setPrefWidth(110);
        room_phone.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Room, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Room, String> param) {
                
                return param.getValue().getValue().roomPhone;
            }
        });
        
                JFXTreeTableColumn<Room , String> room_price = new JFXTreeTableColumn<>("Room Price");
        room_price.setPrefWidth(110);
        room_price.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Room, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Room, String> param) {
                
                return param.getValue().getValue().roomPrice;
            }
        });
        
        
        JFXTreeTableColumn<Room , String> room_status = new JFXTreeTableColumn<>("Room Status");
        room_status.setPrefWidth(110);
        room_status.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Room, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Room, String> param) {
                
                return param.getValue().getValue().roomStatus;
            }
        });
        ObservableList<Room> rooms = FXCollections.observableArrayList();
         Connection connection = DbConnection.getConnection();
        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            rooms.add(new Room(rs.getInt(1)+"",rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
  final TreeItem<Room> root = new RecursiveTreeItem<Room> (rooms , RecursiveTreeObject::getChildren);
     
        treeview.getColumns().setAll(room_id , room_type , room_number ,num_of_people ,floor_number ,room_phone ,room_price , room_status);
        treeview.setRoot(root);
        treeview.setShowRoot(false);
     
    }

    @FXML
    private void searchRoomNumber(MouseEvent event) {
        loadAllRooms("SELECT * FROM rooms WHERE roomNumber = '" +searc_text.getText().toString().trim()+"'");
    }

    @FXML
    private void makeAvailable(MouseEvent event) {
        String text = searc_text.getText().toString().trim();
        String sql = "UPDATE rooms SET roomStatus=? WHERE roomNumber=?";
        int res = 0;
        Connection connection = DbConnection.getConnection();
        try {
            
            
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
            ps.setString(1, "available");
            ps.setString(2, text);
            res =  ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(res>0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Data Updated");
            alert.setHeaderText("Information Dialog");
            alert.setContentText("Record Updated Successfully!!");
            alert.showAndWait();
            loadAllRooms("SELECT * FROM `rooms` WHERE 1");
        
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Data Updated");
            alert.setHeaderText("Information Dialog");
            alert.setContentText("Error!!");
            alert.showAndWait();
            loadAllRooms("SELECT * FROM `rooms` WHERE 1");
        
        }
    }

    @FXML
    private void searchbyStatus(MouseEvent event) {
        loadAllRooms(status);
    }

    @FXML
    private void goBack(MouseEvent event) {
        Stage home = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("homeScreen.fxml"));
        } catch (Exception e) {
        }
        Stage current = (Stage) searc_text.getScene().getWindow();
        Scene scene = new Scene(root);
        home.setScene(scene);
        home.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        home.show();
    }

    @FXML
    private void close(MouseEvent event) {
           JFXDialogLayout dialogLayout = new JFXDialogLayout();
        dialogLayout.setHeading(new Text("Close"));
        dialogLayout.setBody(new Text("Do you Want to exit !!"));
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

    @FXML
    private void searchBusy(ActionEvent event) {
        available.setSelected(false);
        status = "SELECT * FROM rooms WHERE roomStatus = 'busy'";
    }

    @FXML
    private void searchAvailable(ActionEvent event) {
        busy.setSelected(false);
        status = "SELECT * FROM rooms WHERE roomStatus = 'available'";
    }
}
