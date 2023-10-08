/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

/**
 *
 * @author Stegger
 */
public class GameBoard implements IGameModel
{
private int currentPlayer = 0;
private int [][] board;

public GameBoard ()
{
    board = new int[3][3];
}
    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    public int getNextPlayer()
    {
    return currentPlayer;
    }

    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is succesfull the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver == true
     * this method will always return false.
     */
    public boolean play(int col, int row)
    {
        //TODO Implement this method
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

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
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

    /**
     * Resets the game to a new game state.
     */
    public void newGame()
    {
        //TODO Implement this method
    }

}
