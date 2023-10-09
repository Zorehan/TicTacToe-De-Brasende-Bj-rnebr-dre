package tictactoe.gui.controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenu
{
    public Button btnMultiplayerButton;
    public Button btnSinglePayer;
    private int gamemode;




    public void OnMultiplayerClick(ActionEvent actionEvent) throws IOException {
        gamemode=0;
        FXMLLoader loader =new FXMLLoader (getClass().getResource("tictactoe/gui/views/TicTacView.fxml"));
        Parent root = loader.load();
        Stage stage =new Stage();

        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Tic Tac Toe");
        stage.centerOnScreen();
        stage.show();
    }

    public void OnSinglePlayerClick(ActionEvent actionEvent) {
        gamemode=1;


    }
}
