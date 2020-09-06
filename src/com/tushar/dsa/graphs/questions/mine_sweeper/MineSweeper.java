package com.tushar.dsa.graphs.questions.mine_sweeper;

/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java " + Runtime.version().feature());

        for (String string : strings) {
            System.out.println(string);
        }
    }
}


// Minesweeper
// - x - - - - x -
// - 2 - - x - 2 x
// - x 1 1 1 1 - -
// - 2 1 0 0 1 - -
// x 1 0 0 0 1 x 1
// - 1 0 0 0 1 - -

// 1. Click on a mine - GAME OVER.
// 2. Click on a sq adj to mines - reveal the number of adj mines
// 3. Click on a sq with no adj mines - reveal the largest possible "safe" region
// 4. Win condition - when the user has revealed all sq that are not mines, WIN.

enum GameState {
    Win,
    Playing,
    Lose
}

enum CellState{
    Covered,
    Bomb,
    Empty,

}


public class MineSweeper{

    int[][] mineField;
    int score;
    int maxScore;

    public MineSweeper(int[][] mineField){
        mineField = mineField;
        score = 0;
        maxScore = mineField.length * mineField[0].length;
    }


    //magic-function - triggered by user click
    public GameState OnTileClicked(int x, int y) {

        if (mineField[x][y] == -1){
            return GameState.Lose;

        } else if (mineField[x][y] == 0) {  // assumption: no duplicate clicks

            dfs(x,y);
        }

        if (score == maxScore){

            return GameState.Win;
        }

        return GameState.Playing;
    }

  /*
  -1 = bomb
  0 = uncovered
  1,2,3..8 counts of nearby bombs
  */

    public int dfs(int x, int y){

        if (getValue(x, y) == -2){  // out of bound
            return 0;
        }

        // empty cell, ads score
        if (getValue(x, y) == 0){
            // mineField[i][j] = 0;
            score++;
            return 0;
        }

        // already exposed boundaries of previous DFS
        if (getValue(x, y) > 0){
            return 0;
        }

        // found a bomb
        if (getValue(x, y) == -1){  // If I need to stop user from hitting an exposed cell
            return 1;
        }


        for(int i = -1; i<=1; i++){
            for(int j = -1; j<=1; j++){

                if (i ==0 & j ==0){
                    continue;
                }

                mineField[i][j] += dfs(i, j);
            }
        }

    /*
    mineField[i][j] = dfs(x+1, y+1);  // TODO: remove this repetition
    mineField[i][j] += dfs(x+1, y);
    mineField[i][j] += dfs(x+1, y-1);
    mineField[i][j] += dfs(x, y-1);
    mineField[i][j] += dfs(x-1, y-1);
    mineField[i][j] += dfs(x+1, y);
    mineField[i][j] += dfs(x-1, y+1);
    mineField[i][j] += dfs(x, y+1);
    */

        return mineField[x][y];
    }

    int getValue(int x, int y){

        if (x < 0 || y < 0 || x > mineField.length -1 || y > mineField[0].length -1){
            return -2;
        }

        return mineField[x][y];
    }
}








