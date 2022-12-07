package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;



public class Game extends AppCompatActivity {
    private EditText p1;
    private EditText p2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p1 = findViewById(R.id.player1);
        p2=findViewById(R.id.player2);
    }
    public void submitButton(View view){
    String player1name = p1.getText().toString();
    String player2name =p2.getText().toString();
    Intent intent = new Intent(this,Display.class); //that you can use to put extended data to the intent. The main use of the putExtra() method is to send values you need in the next activity
    intent.putExtra("player_names",new String[]{player1name,player2name});
    startActivity(intent);
    }


}