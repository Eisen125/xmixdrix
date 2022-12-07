package com.example.tictactoe;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Gamelocig {

    public void setPlayerNames(String[] playerNames) {
        this.playerNames = playerNames;
    }
    private TextView playerturn;
    private int[][] gameboard;
    private Button playAgainButton;
    private String [] playerNames={"player1","player 2 "};
    private  Button homeButton;
    private boolean winnigline=false;

    public void setPlayAgainButton(Button playAgainButton) {
        this.playAgainButton = playAgainButton;
    }

    public void setHomeButton(Button homeButton) {
        this.homeButton = homeButton;
    }

    public void setPlayerturn(TextView playerturn) {
        this.playerturn = playerturn;
    }


    private int player = 1;

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }

    Gamelocig() {
        gameboard = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameboard[j][i] = 0;
            }
        }

    }

    public boolean updateGameBoard(int row, int col) {
        if (gameboard[row - 1][col - 1] == 0) {
            gameboard[row - 1][col - 1] = player;
            if (player==1){playerturn.setText(playerNames[1]+"s turn");
            }else  {
                playerturn.setText(playerNames[0] + "s turn");
            }
            return true;
        } else {
            return false;
        }
    }
    public boolean winnerCheck() {
        boolean isWinner = false;
        for (int r = 0; r < 3; r++) {
            if (gameboard[r][0] == gameboard[r][1] && gameboard[r][0] == gameboard[r][2] &&
                    gameboard[r][0] != 0) ;
            isWinner = true;
        }
        for (int c = 0; c < 3; c++) {
            if (gameboard[0][c] == gameboard[1][c] && gameboard[2][c] == gameboard[0][c] &&
                    gameboard[0][0] != 0) ;
            isWinner = true;
            if (gameboard[2][0] == gameboard[1][1] && gameboard[2][0] == gameboard[0][2] &&
                    gameboard[0][0] != 0)
                isWinner = true;
        }
        int boardFilled=0;
        for ( int r=0;r<3;r++){
            for(int c=0;c<3;c++){
                if (gameboard[r][c]!=0) {
                    boardFilled += 1;
                }
            }
        }
        if (isWinner){
            playAgainButton.setVisibility(View.VISIBLE);
            homeButton.setVisibility(View.VISIBLE);
            playerturn.setText((playerNames[player-1]+"won"));
            return true;
        }else if (boardFilled==9){
            playAgainButton.setVisibility(View.VISIBLE);
            homeButton.setVisibility(View.VISIBLE);
            playerturn.setText("Tie");
            return true;
        }else{return false;}
    }
    public void resretGame(){
for (int i=0;i<3;i++){
    for (int j=0;j<3;j++){
        gameboard[i][j] =0;
    }
}

    }

    public int[][] getGameboard() {
        return gameboard;
    }


}

