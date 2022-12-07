package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Display extends AppCompatActivity {
    private  xmixdrixboard xmixdrixboard;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button playAgainBtn = findViewById(R.id.play_again);
        Button homebutton= findViewById(R.id.home_button);
        xmixdrixboard =findViewById(R.id.xmixdrixboard3);
        TextView playeturn= findViewById(R.id.player_turn);
        String [] playernames =getIntent().getStringArrayExtra("player_names");
        xmixdrixboard.setUpgame(playAgainBtn,homebutton,playeturn,playernames);

    }
    public void playagainbuttonclicked(View view){
xmixdrixboard.reset_Game();
xmixdrixboard.invalidate();
    }
    public void backhome(View view){
        Intent intent  = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}