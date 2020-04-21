/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Deeboo
 */
public class CustomerScreenController implements Initializable {

     @FXML
    private JFXTreeTableView<Customer> treeview;

    @FXML
    private JFXTextField searchText;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadAllCustomers("SELECT * FROM customers");
       
    }    
        public void loadAllCustomers(String sql){
    
        JFXTreeTableColumn<Customer , String> customer_id = new JFXTreeTableColumn<>("Id");
        customer_id.setPrefWidth(70);
        customer_id.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                
                return param.getValue().getValue().id;
            }
        });
        
                JFXTreeTableColumn<Customer , String> customer_name = new JFXTreeTableColumn<>("Name");
        customer_name.setPrefWidth(80);
        customer_name.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                
                return param.getValue().getValue().name;
            }
        });
        
        JFXTreeTableColumn<Customer , String> email = new JFXTreeTableColumn<>("Email");
        email.setPrefWidth(110);
        email.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                
                return param.getValue().getValue().email;
            }
        });
        
                JFXTreeTableColumn<Customer , String> address = new JFXTreeTableColumn<>("Address");
        address.setPrefWidth(100);
        address.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                
                return param.getValue().getValue().address;
            }
        });
        
                JFXTreeTableColumn<Customer , String> phone = new JFXTreeTableColumn<>("Phone");
        phone.setPrefWidth(100);
        phone.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                
                return param.getValue().getValue().phone;
            }
        });
        
                JFXTreeTableColumn<Customer , String> numofPeople = new JFXTreeTableColumn<>("Number Of People");
        numofPeople.setPrefWidth(120);
        numofPeople.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                
                return param.getValue().getValue().numofPeople;
            }
        });
        
                JFXTreeTableColumn<Customer , String> duration = new JFXTreeTableColumn<>("Duration");
        duration.setPrefWidth(110);
        duration.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                
                return param.getValue().getValue().duration;
            }
        });
        
        
        JFXTreeTableColumn<Customer , String> paymentType = new JFXTreeTableColumn<>("Payment Type");
        paymentType.setPrefWidth(110);
        paymentType.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                
                return param.getValue().getValue().paymenTtype;
            }
        });
                JFXTreeTableColumn<Customer , String> roomType = new JFXTreeTableColumn<>("Room Type");
        roomType.setPrefWidth(100);
        roomType.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                
                return param.getValue().getValue().paymenTtype;
            }
        });
                JFXTreeTableColumn<Customer , String> roomNumber = new JFXTreeTableColumn<>("Room Number");
        roomNumber.setPrefWidth(110);
        roomNumber.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                
                return param.getValue().getValue().roomNumber;
            }
        });
                JFXTreeTableColumn<Customer , String> startDate = new JFXTreeTableColumn<>("Start Date");
        startDate.setPrefWidth(110);
        startDate.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                
                return param.getValue().getValue().startDate;
            }
        });
                JFXTreeTableColumn<Customer , String> endDate = new JFXTreeTableColumn<>("End Date");
        endDate.setPrefWidth(100);
        endDate.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                
                return param.getValue().getValue().endDate;
            }
        });
                JFXTreeTableColumn<Customer , String> price = new JFXTreeTableColumn<>("Price");
        price.setPrefWidth(80);
        price.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                
                return param.getValue().getValue().price;
            }
        });
                JFXTreeTableColumn<Customer , String> services = new JFXTreeTableColumn<>("Services");
        services.setPrefWidth(90);
        services.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                
                return param.getValue().getValue().paymenTtype;
            }
        });
                JFXTreeTableColumn<Customer , String> total = new JFXTreeTableColumn<>("Total");
        total.setPrefWidth(110);
        total.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                
                return param.getValue().getValue().total;
            }
        });
        
        ObservableList<Customer> customers = FXCollections.observableArrayList();
         Connection connection = DbConnection.getConnection();
        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            customers.add(new Customer(rs.getInt(1)+"",rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
  final TreeItem<Customer> root = new RecursiveTreeItem<Customer> (customers , RecursiveTreeObject::getChildren);
     
        treeview.getColumns().setAll(customer_id , customer_name , email ,address ,phone ,numofPeople ,duration , paymentType ,roomType ,roomNumber ,startDate ,endDate ,price ,services ,total);
        treeview.setRoot(root);
        treeview.setShowRoot(false);
     
    }

    @FXML
    private void searchByRoomNum(MouseEvent event) {
        loadAllCustomers("SELECT * FROM customers WHERE roomNumber='" + searchText.getText().toString().trim()+"'");
        
    }

    @FXML
    private void back(MouseEvent event) {
        Stage home = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("homeScreen.fxml"));
        } catch (Exception e) {
        }
        Stage current = (Stage) searchText.getScene().getWindow();
        Scene scene = new Scene(root);
        home.setScene(scene);
        home.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        home.show();
    }
    
}
