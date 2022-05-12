package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] board = {
            {7, 0, 2, 0, 5, 0, 6, 0, 0},
            {0, 0, 0, 0, 0, 3, 0, 0, 0},
            {1, 0, 0, 0, 0, 9, 5, 0, 0},
            {8, 0, 0, 0, 0, 0, 0, 9, 0},
            {0, 4, 3, 0, 0, 0, 7, 5, 0},
            {0, 9, 0, 0, 0, 0, 0, 0, 8},
            {0, 0, 9, 7, 0, 0, 0, 0, 5},
            {0, 0, 0, 2, 0, 0, 0, 0, 0},
            {0, 0, 7, 0, 4, 0, 2, 0, 3}
        };

        if(solveSudoku(board)){
            System.out.println("Solved sudoku");
        }
        else{
            System.out.println("Unsolved sudoku");
        }

        printSudoku(board);
    }

    public static void printSudoku(int[][] sudoku){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if( j != 0 && j != 8){
                    System.out.print("|");
                }
                System.out.print(sudoku[i][j]);
            }
            System.out.println("\n__________________");
        }
    }

    public static boolean checkRow(int[][] board, int row, int number){
        for(int column  = 0; column < 9; column++){
            if(board[row][column] == number){
                return false;
            }
        }
        return true;
    }

    public static boolean checkColumn(int[][] board, int column, int number){
        for(int row  = 0; row < 9; row++){
            if(board[row][column] == number){
                return false;
            }
        }
        return true;
    }

    public static boolean checkBlock(int[][] board,int row, int column, int number){
        int localColumn = column - column % 3;
        int localRow = row - row % 3;

        for(int i = localRow; i < localRow + 3; i++){
            for(int j = localColumn; j < localColumn + 3; j++){
                if(board[i][j] == number){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean validNumber(int[][] board, int row, int column, int number){
        return checkRow(board,row,number) && checkColumn(board,column,number) && checkBlock(board,row,column,number);
    }

    public static boolean solveSudoku(int [][] board){
        for(int row = 0; row < 9; row++){
            for(int column = 0; column < 9; column++){
                if(board[row][column] == 0){
                    for(int number = 1; number <= 9; number++){
                        if(validNumber(board,row,column,number)) {
                            board[row][column] = number;
                            if(solveSudoku(board)){
                                return true;
                            }
                            else{
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}

