package org.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.beans.Employees;
import org.db.EmployeesDAO;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

public class ItemController implements Initializable, EmployeesDAO {
    ArrayList <Employees> result = new ArrayList<>();
    @FXML
    private Label LabelName;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       result = getEmployees();
       result.forEach(e->{
           LabelName.setText(e.getName());
       });
    }
}
