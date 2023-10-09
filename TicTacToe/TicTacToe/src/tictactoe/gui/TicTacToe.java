/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Stegger
 */
public class TicTacToe extends Application
{
  Scene scene1, scene2;
    @Override
    public void start(Stage stage) throws Exception
    {
     
        
        Parent root = FXMLLoader.load(getClass().getResource("views/MainMenu.fxml"));
        Scene MainMenu1 = new Scene(root);
        stage.setScene(MainMenu1);
        stage.setResizable(false);
        stage.setTitle("Tic Tac Toe");
        stage.centerOnScreen();


        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
