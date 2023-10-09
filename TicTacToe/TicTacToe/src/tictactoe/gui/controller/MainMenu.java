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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/TicTacView.fxml"));
        Parent SecondSceneRoot = loader.load();
        Stage SecondStage = new Stage();
        SecondStage.setTitle("TicTacToe");
        SecondStage.setScene(new Scene(SecondSceneRoot));

        SecondStage.show();

        Stage currentStage = (Stage) btnMultiplayerButton.getScene().getWindow();

        SecondStage.setOnHidden(event -> currentStage.close());
    }

    public void OnSinglePlayerClick(ActionEvent actionEvent) {
        gamemode=1;


    }
}
