package com.jdc.tut;
	
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.jdc.tut.controller.MainController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

@SpringBootApplication
public class Main extends Application {
	
private static ConfigurableApplicationContext ctx;

public static<T> T getController(Class<T> type) {
	return ctx.getBean(type);
}


@Override
	public void init() throws Exception {
		
		super.init();
		ctx=SpringApplication.run(Main.class);
		
		
	}
	@Override
	protected void finalize() throws Throwable {
		
		super.finalize();
		ctx.close();
		
	}
	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader loader=new FXMLLoader(MainController.class.getResource("view/Main.fxml"));
		loader.setControllerFactory(ctx::getBean);
		stage.setScene(new Scene(loader.load()));
		stage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
		
}
