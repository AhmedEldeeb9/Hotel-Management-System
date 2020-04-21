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
public class Customer extends RecursiveTreeObject<Customer>{
    StringProperty id;
    StringProperty name;
    StringProperty email;
    StringProperty address;
    StringProperty phone;      
    StringProperty numofPeople;
    StringProperty duration;
    StringProperty paymenTtype;
    StringProperty roomtype;
    StringProperty roomNumber;
    StringProperty startDate;
    StringProperty endDate;
    StringProperty price;      
    StringProperty services;
    StringProperty total;
     public Customer(){
       super();

   }    

    public Customer(String id, String name, String email, String address, String phone, String numofPeople, String duration, String paymenTtype, String roomtype, String roomNumber, String startDate, String endDate, String price, String services, String total) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
        this.address = new SimpleStringProperty(address);
        this.phone = new SimpleStringProperty(phone);
        this.numofPeople = new SimpleStringProperty(numofPeople);
        this.duration = new SimpleStringProperty(duration);
        this.paymenTtype = new SimpleStringProperty(paymenTtype);
        this.roomtype = new SimpleStringProperty(roomtype);
        this.roomNumber = new SimpleStringProperty(roomNumber);
        this.startDate = new SimpleStringProperty(startDate);
        this.endDate = new SimpleStringProperty(endDate);
        this.price = new SimpleStringProperty(price);
        this.services = new SimpleStringProperty(services);
        this.total = new SimpleStringProperty(total);
    }


    
}
