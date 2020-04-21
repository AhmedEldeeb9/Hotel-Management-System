/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
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
import javafx.beans.property.StringProperty;
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
import javafx.scene.control.TreeTableView;
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
public class EmployeeScreenController implements Initializable {
    
    @FXML
    private JFXTreeTableView<Employee> treeview;
    
    @FXML
    private JFXTextField searc_text2;


    @FXML
    private JFXTextField searc_text;

    @FXML
    private JFXTextField searc_text1;

    @FXML
    private JFXTextField searc_text3;

    @FXML
    private JFXTextField searc_text4;

    @FXML
    private JFXTextField searc_text5;

    @FXML
    private JFXTextField searc_text7;

    @FXML
    private JFXTextField searc_text8;
    @FXML
    private StackPane stackpane;
    @FXML
    private JFXTextField search_text6;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadAllEmployees("SELECT * FROM emmployees");
    

        
    }    

    public void loadAllEmployees(String sql){
    
    JFXTreeTableColumn<Employee , String> userName = new JFXTreeTableColumn<>("User Name");
        userName.setPrefWidth(100);
        userName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Employee, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Employee, String> param) {
                
                return param.getValue().getValue().username;
            }
        });
            JFXTreeTableColumn<Employee , String> Password = new JFXTreeTableColumn<>("Password");
        Password.setPrefWidth(100);
        Password.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Employee, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Employee, String> param) {
                
                return param.getValue().getValue().password;
            }
        });
        JFXTreeTableColumn<Employee , String> fullName = new JFXTreeTableColumn<>("Full Name");
        fullName.setPrefWidth(100);
        fullName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Employee, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Employee, String> param) {
                
                return param.getValue().getValue().fullname;
            }
        });
        JFXTreeTableColumn<Employee , String> Address = new JFXTreeTableColumn<>("Address");
        Address.setPrefWidth(100);
        Address.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Employee, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Employee, String> param) {
                
                return param.getValue().getValue().adddress;
            }
        });
         JFXTreeTableColumn<Employee , String> Phone = new JFXTreeTableColumn<>("Phone");
        Phone.setPrefWidth(100);
        Phone.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Employee, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Employee, String> param) {
                
                return param.getValue().getValue().phone;
            }
        });
                 JFXTreeTableColumn<Employee , String> startDate = new JFXTreeTableColumn<>("Start Date");
        startDate.setPrefWidth(100);
        startDate.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Employee, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Employee, String> param) {
                
                return param.getValue().getValue().startdate;
            }
        });
        JFXTreeTableColumn<Employee , String> Salary = new JFXTreeTableColumn<>("Salary");
        Salary.setPrefWidth(100);
        Salary.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Employee, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Employee, String> param) {
                
                return param.getValue().getValue().salary;
            }
        });
        JFXTreeTableColumn<Employee , String> userType = new JFXTreeTableColumn<>("User Type");
        userType.setPrefWidth(100);
        userType.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Employee, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Employee, String> param) {
                
                return param.getValue().getValue().usertype;
            }
        });
        ObservableList<Employee> employee = FXCollections.observableArrayList();
         Connection connection = DbConnection.getConnection();
        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            employee.add(new Employee(rs.getString(1)+"",rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
            }
        } catch (SQLException ex) {
           // Logger.getLogger(RoomScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
  final TreeItem<Employee> root = new RecursiveTreeItem<Employee> (employee , RecursiveTreeObject::getChildren);
     
        treeview.getColumns().setAll(userName , Password , fullName ,Address ,Phone ,startDate ,Salary , userType);
        treeview.setRoot(root);
        treeview.setShowRoot(false);
      treeview.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends TreeItem<Employee>> observable, TreeItem<Employee> oldValue, TreeItem<Employee> newValue) -> {
            showDetails(newValue);
        });
  
 
    }
    @FXML
    private void searchbyName(MouseEvent event) {
        loadAllEmployees("SELECT * FROM emmployees WHERE username = '" +searc_text.getText().toString().trim()+"'");
        
    }

    @FXML
    private void insert(MouseEvent event) {
                
        String userName = searc_text1.getText().toString().trim();
        String password = searc_text2.getText().toString().trim();
        String fullname = searc_text3.getText().toString().trim();
        String address = searc_text4.getText().toString().trim();
        String phone = searc_text5.getText().toString().trim();
        String Startdate = search_text6.getText().toString().trim();
        String salary = searc_text7.getText().toString().trim();
        String uertype = searc_text8.getText().toString().trim();


        Connection connection = DbConnection.getConnection();
        String sql = "INSERT INTO emmployees VALUES('"+userName+"','"+password+"','"+fullname+"','"+address+"','"+phone+"','"+phone+"','"+salary+"','"+uertype+"')";
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
    private void update(MouseEvent event) {
        Connection connection = DbConnection.getConnection();
        String sql = "UPDATE `emmployees` SET `password`=?,`fullname`=?,`address`=?,`phone`=?,`startdate`=?,`salary`=?,`usertype`=? WHERE `username`=?" ;
        int res = 0;
       
        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
            ps.setString(1 , searc_text2.getText());
             ps.setString(2 , searc_text3.getText());
              ps.setString(3 , searc_text4.getText());
               ps.setString(4 , searc_text5.getText());
                ps.setString(5 , search_text6.getText());
                 ps.setString(6 , searc_text7.getText());
                 ps.setString(7 , searc_text8.getText());
                  ps.setString(8 , searc_text1.getText());
            res =  ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(res>0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Data Updated");
            alert.setHeaderText("Information Dialog");
            alert.setContentText("Data has been Updated!!");
            alert.showAndWait();
         
        }
    }

    @FXML
    private void clear(MouseEvent event) {
        searc_text1.clear();
        searc_text2.clear();
        searc_text3.clear();
        searc_text4.clear();
        searc_text5.clear();
        search_text6.clear();
        searc_text7.clear();
        searc_text8.clear();
    }

    @FXML
    private void delete(MouseEvent event) {
        
        Connection connection = DbConnection.getConnection();
        String sql = "DELETE FROM `emmployees` WHERE `username`= ?" ;
        int res = 0;
       
        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
            ps.setString(1 , searc_text1.getText());
            res =  ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(res>0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Data Deleted");
            alert.setHeaderText("Information Dialog");
            alert.setContentText("Data has been Deleted!!");
            alert.showAndWait();
         
        }
        
    }

    @FXML
    private void back(MouseEvent event) {
        Stage home = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("adminScreen.fxml"));
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
    private void showDetails(TreeItem<Employee> newValue) {
        searc_text1.setText(newValue.getValue().username.get());
        searc_text2.setText(newValue.getValue().password.get());
        searc_text3.setText(newValue.getValue().fullname.get());
        searc_text4.setText(newValue.getValue().adddress.get());
        searc_text5.setText(newValue.getValue().phone.get());
        search_text6.setText(newValue.getValue().startdate.get());
        searc_text7.setText(newValue.getValue().salary.get());
        searc_text8.setText(newValue.getValue().usertype.get());
    }

    
}
