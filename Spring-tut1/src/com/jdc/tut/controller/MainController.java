package com.jdc.tut.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jdc.tut.entity.User;
import com.jdc.tut.service.MainService;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
@Controller
public class MainController implements Initializable {

    @FXML
    private TextField name;

    @FXML
    private TableView<User> tbView;
    @Autowired
    private MainService service;

    @FXML
    void add() {
    	
    	User u=new User();
    	u.setName(name.getText());
    	service.save(u);
    	loadView();
    	

    }
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		
    	loadView();
	}
	private void loadView() {
		tbView.getItems().clear();
		tbView.getItems().addAll(service.findAll());
		
	}

}
