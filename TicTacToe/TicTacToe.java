//*************
// Tic Tac Toe Program
//
// Author: Austin Reid
// Description: Project for Java to help learn Java.
//
//
//************* 

// Packages
package TicTacToe;


// Imports

import java.util.Scanner;

public class TicTacToe {
    
    

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        initializeBoard(board);
        playGame(board);
        isValidMove(board, 0, 0);
        checkWin(board, 'X'); // Fix: Change the second argument to a char
        isBoardFull(board);
    }

    public static void initializeBoard(char[][] board) {

        for (int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++){
                board[row][col] = ' ';
            }
        }
    }
    public static void displayBoard(char[][] board) {
        for (int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++){
                System.out.print(board[row][col]);
                if (col < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (row < 2) {
                System.out.println("----------");
            }
        }
    }

    public static boolean isValidMove(char[][] board, int row, int col) {
        
        if(row < 0 || row > 2) {
            System.out.println("Invalid move.");
            return false;
        }
        
        if(col < 0 || col > 2 ){
            System.out.println("Invalid move.");
            return false;
        }

        if(board[row][col] == ' '){
            return true;
        } else {
            System.out.println("Invalid move.");
            return false;
            
        }
    }

    public static boolean checkWin(char[][] board, char playerSymbol){
        for(int i = 0; i < board.length; i++){
            if (board[i][0] == playerSymbol && board[i][1] == playerSymbol && board[i][2] == playerSymbol){
                // Win condition met
                return true;
            } 
        }

        // Check Columns

        for(int j = 0; j < board[0].length; j++){
            if (board[0][j] == playerSymbol && board[1][j] == playerSymbol && board[2][j] == playerSymbol){
                return true;
            }
        }

        // Diagonals

        if(board[0][0] == playerSymbol && board[1][1] == playerSymbol && board[2][2] == playerSymbol){
            return true;
        }

        if (board[0][2] == playerSymbol && board[1][1] == playerSymbol && board[0][0] == playerSymbol){
            return true;
        }
        return false;
    }
    
    public static boolean isBoardFull(char[][] board){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }
        


    public static void playGame(char[][]board){
        boolean isGameRunning = true;
        boolean isPlayerOneTurn = true;
        Scanner inputs = new Scanner(System.in);

        while(isGameRunning){
            displayBoard(board);
            int row, col;
            char playerSymbol;
            if(isPlayerOneTurn) {
                playerSymbol = 'X';
                System.out.print("Player 1 (X), enter your move (Row, Column): ");
            } else {
                playerSymbol = 'O';
                System.out.print("Player 2 (O), enter your move (Row, Column): ");
            }

            row = inputs.nextInt();
            col = inputs.nextInt();

            if(isValidMove(board, row, col)){
                board[row][col] = playerSymbol;

                if(checkWin(board, playerSymbol)){
                    displayBoard(board);
                    System.out.println("Player " + playerSymbol + "Wins!");
                    isGameRunning = false;

                } else if(isBoardFull(board)) {
                    displayBoard(board);
                    System.out.println("Board filled, it's a draw!");
                    isGameRunning = false;
                    
                } else {
                    isPlayerOneTurn = !isPlayerOneTurn;
                }
            } else {
                System.out.println("Invalid move, try again.");
            }

        }
    }

}


