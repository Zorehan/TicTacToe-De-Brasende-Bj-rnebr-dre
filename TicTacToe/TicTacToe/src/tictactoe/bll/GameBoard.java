/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;


public class GameBoard implements IGameModel
{
    private int currentPlayer = 0;
    private int [][] board;

    public GameBoard ()
    {
        board = new int[3][3];
    }


    public int getNextPlayer()
    {
        return currentPlayer;
    }


    public boolean play(int col, int row)
    {
        if(board[row][col] == 0)
        {
            board[row][col] = currentPlayer + 1;
            currentPlayer = 1 - currentPlayer;
            return true;

            //haha
            //test 1
        }
        return false;
    }

    public boolean isGameOver()
    {

        for(int row = 0; row < 3; row++)
        {
            if(board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0] !=0)
            {
                return true;
            }
        }

        for (int col = 0; col < 3; col++)
        {
            if(board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[0][col] !=0)
            {
                return true;
            }
        }

        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != 0)
        {
            return true;
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != 0)
        {
            return true;
        }

        boolean isDraw = true;
        for(int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 3; col++)
            {
                if(board[row][col] == 0)
                {
                    isDraw = false;
                    break;
                }
            }
        }
        if(isDraw == true)
        {
            return true;
        }

        return false;
    }


    public int getWinner()
    {

        for(int row = 0; row < 3; row++)
        {
            if(board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0] !=0)
            {
                return board[row][0] - 1;
            }
        }

        for (int col = 0; col < 3; col++)
        {
            if(board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[0][col] !=0)
            {
                return board[0][col] -1;
            }
        }

        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != 0)
        {
            return board[0][0] -1;
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != 0)
        {
            return board[0][2] - 1;
        }


        return -1;
    }


    public void newGame()
    {


        for(int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 3; col++)
            {
                if (board[row][col] != 0)
                {
                    board[row][col] = 0;
                }
            }
        }

    }

}
