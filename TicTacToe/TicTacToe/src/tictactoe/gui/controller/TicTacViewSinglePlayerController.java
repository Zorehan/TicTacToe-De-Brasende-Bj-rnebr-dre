/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.gui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import tictactoe.bll.GameBoard;
import tictactoe.bll.IGameModel;

/**
 *
 * @author Stegger
 */
public class TicTacViewSinglePlayerController implements Initializable
{

    @FXML
    private Label lblPlayer;

    @FXML
    private Button btnNewGame;

    @FXML
    private GridPane gridPane;

    private final String TXT_PLAYER = "Player: ";
    private IGameModel game;

    public void main(String[] args)
    {
        if(game.getNextPlayer() == 0)
        {
            computerTurn();
        }
    }

    @FXML
    private void handleButtonAction(ActionEvent event)
    {

        try
        {
            Integer row = GridPane.getRowIndex((Node) event.getSource());
            Integer col = GridPane.getColumnIndex((Node) event.getSource());
            int r = (row == null) ? 0 : row;
            int c = (col == null) ? 0 : col;
            int player = game.getNextPlayer();
            if (game.play(c, r))
            {
                if (game.isGameOver())
                {
                    int winner = game.getWinner();
                    displayWinner(winner);
                    Button btn = (Button) event.getSource();
                    String xOrO = player == 0 ? "X" : "O";
                    btn.setText(xOrO);
                }


                else
                {
                    Button btn = (Button) event.getSource();
                    String xOrO = player == 0 ? "X" : "O";
                    btn.setText(xOrO);
                    setPlayer();
                    if(game.getNextPlayer() == 1)
                    {
                        computerTurn();
                    }

                }
            }
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void handleNewGame(ActionEvent event)
    {
        game.newGame();
        setPlayer();
        clearBoard();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

        game = new GameBoard();
        setPlayer();
    }

    private void setPlayer()
    {
        lblPlayer.setText(TXT_PLAYER + game.getNextPlayer());
    }

    private void displayWinner(int winner)
    {
        String message = "";
        switch (winner)
        {
            case -1:
                message = "It's a draw :-(";
                break;
            default:
                message = "Player " + winner + " wins!!!";
                break;
        }
        lblPlayer.setText(message);
    }

    private void clearBoard()
    {
        for(Node n : gridPane.getChildren())
        {
            Button btn = (Button) n;
            btn.setText("");
        }
    }

    private Button getButtonForComputer(int row, int col)
    {
        for(Node node : gridPane.getChildren())
        {
            if(node instanceof Button)
            {
                Button button = (Button) node;
                Integer rowIndex = GridPane.getRowIndex(button);
                Integer colIndex = GridPane.getColumnIndex(button);

                if(rowIndex != null && colIndex != null && rowIndex == row && colIndex == col)
                {
                    return button;
                }
            }
        }
        return null;
    }

    private void computerTurn()
    {
        List<Integer> unpressedButtons = new ArrayList<Integer>();
        for(int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 3; col++)
            {
                if(GameBoard.getCell(row, col) == 0)
                {
                    unpressedButtons.add(row * 3 + col);
                }
            }
        }

        if(!unpressedButtons.isEmpty())
        {
            int player = game.getNextPlayer();
            int randomIndex = new Random().nextInt(unpressedButtons.size());
            int computerButtonChoice = unpressedButtons.get(randomIndex);
            int row = computerButtonChoice / 3;
            int col = computerButtonChoice % 3;
            System.out.println("row" + row +"col" + col);

            game.play(col,row);

            Button button = getButtonForComputer(row, col);
            String xOrO = player == 0 ? "X" : "O";
            button.setText(xOrO);

            if(game.isGameOver() == true)
            {
                int winner = game.getWinner();
                displayWinner(winner);
            }
            else
            {
                setPlayer();
            }
        }
    }
}
