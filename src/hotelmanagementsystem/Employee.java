/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Deeboo
 */
public class Employee extends RecursiveTreeObject<Employee> {
    StringProperty username;
    StringProperty password;
    StringProperty fullname;
    StringProperty adddress;
    StringProperty phone;      
    StringProperty startdate;
    StringProperty salary;
    StringProperty usertype;
     public Employee(){
       super();

   }    

    public Employee(String username, String password, String fullname, String adddress, String phone, String startdate, String salary, String usertype) {
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.fullname = new SimpleStringProperty(fullname);
        this.adddress = new SimpleStringProperty(adddress);
        this.phone = new SimpleStringProperty(phone);
        this.startdate = new SimpleStringProperty(startdate);
        this.salary = new SimpleStringProperty(salary);
        this.usertype = new SimpleStringProperty(usertype);
    }


    
}
