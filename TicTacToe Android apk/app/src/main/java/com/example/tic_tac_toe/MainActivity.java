package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button bttn1, bttn2, bttn3, bttn4, bttn5, bttn6, bttn7, bttn8, bttn9, toggle_mode, play_again;
    private TextView player1_score, player2_score, tie_score, p1_text, p2_text, turn;

    private char current_val = 'x', curr_play = '1';
    private int ply1 = 0, ply2 = 0, tie = 0, allfill = 0;

    private char mode = 'c';
    private boolean win = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUi();

        bttn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bttn1.getText().equals("")  && !win) {
                    bttn1.setText(currentValue());
                    checkWin(bttn1.getText().toString());
                    if(!win)
                     changePlayer();
                    if(mode == 'c' && !win){
                        decideMove();
                    }
                }
            }
        });

        bttn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bttn2.getText().equals("")  && !win) {
                    bttn2.setText(currentValue());
                    checkWin(bttn2.getText().toString());
                    if(!win)
                     changePlayer();
                    if(mode == 'c' && !win){
                        decideMove();
                    }
                }

            }
        });

        bttn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bttn3.getText().equals("")  && !win) {
                    bttn3.setText(currentValue());
                    checkWin(bttn3.getText().toString());
                    if(!win)
                     changePlayer();
                    if(mode == 'c' && !win){
                        decideMove();
                    }
                }
            }
        });

        bttn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bttn4.getText().equals("")  && !win) {
                    bttn4.setText(currentValue());
                    checkWin(bttn4.getText().toString());
                    if(!win)
                     changePlayer();
                    if(mode == 'c' && !win){
                        decideMove();
                    }
                }
            }
        });

        bttn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bttn5.getText().equals("")  && !win) {
                    bttn5.setText(currentValue());
                    checkWin(bttn5.getText().toString());
                    if(!win)
                     changePlayer();
                    if(mode == 'c' && !win){
                        decideMove();
                    }
                }

            }
        });

        bttn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bttn6.getText().equals("")  && !win) {
                    bttn6.setText(currentValue());
                    checkWin(bttn6.getText().toString());
                    if(!win)
                     changePlayer();
                    if(mode == 'c' && !win){
                        decideMove();
                    }
                }

            }
        });

        bttn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bttn7.getText().equals("")  && !win) {
                    bttn7.setText(currentValue());
                    checkWin(bttn7.getText().toString());
                    if(!win)
                     changePlayer();
                    if(mode == 'c' && !win){
                        decideMove();
                    }
                }

            }
        });

        bttn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bttn8.getText().equals("")  && !win) {
                    bttn8.setText(currentValue());
                    checkWin(bttn8.getText().toString());
                    if(!win)
                     changePlayer();
                    if(mode == 'c' && !win){
                        decideMove();
                    }
                }

            }
        });

        bttn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bttn9.getText().equals("")  && !win) {
                    bttn9.setText(currentValue());
                    checkWin(bttn9.getText().toString());
                    if(!win)
                     changePlayer();
                    if(mode == 'c' && !win){
                        decideMove();
                    }
                }

            }
        });

        play_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAgain();
            }
        });

        toggle_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mode == 'c') {
                    playAgain();
                    toggle_mode.setText("Play with Computer");
                    mode = 'm';
                    if(current_val == 'x') {
                        p1_text.setText("Player1 (X)");
                        p2_text.setText("Player2 (O)");
                    }
                    else {
                        p1_text.setText("Player1 (O)");
                        p2_text.setText("Player2 (X)");
                    }
                }
                else{
                    playAgain();
                    toggle_mode.setText("Two Player");
                    mode = 'c';
                }
            }
        });

    }

    public void setUi(){
        bttn1 = (Button)findViewById(R.id.bttn_1);
        bttn2 = (Button)findViewById(R.id.bttn_2);
        bttn3 = (Button)findViewById(R.id.bttn_3);
        bttn4 = (Button)findViewById(R.id.bttn_4);
        bttn5 = (Button)findViewById(R.id.bttn_5);
        bttn6 = (Button)findViewById(R.id.bttn_6);
        bttn7 = (Button)findViewById(R.id.bttn_7);
        bttn8 = (Button)findViewById(R.id.bttn_8);
        bttn9 = (Button)findViewById(R.id.bttn_9);
        play_again = (Button)findViewById(R.id.play_again);
        toggle_mode = (Button)findViewById(R.id.toggle_mode);
        player1_score = (TextView)findViewById(R.id.player1_score);
        player2_score = (TextView)findViewById(R.id.player2_score);
        tie_score = (TextView)findViewById(R.id.tie_score);
        p1_text = (TextView) findViewById(R.id.player_1);
        p2_text = (TextView) findViewById(R.id.player_2);
        turn = (TextView) findViewById(R.id.turn);

        p1_text.setText("Player (X)");
        p2_text.setText("Computer (O)");
        turn.setText("Player Turn");
    }

    public String currentValue(){
        String val = "Na";
        switch(current_val){
            case 'x':
                val =  "X";
                current_val = 'o';
                break;
            case 'o':
                val = "O";
                current_val = 'x';
                break;
            default:
                val = "Na";
        }
        allfill ++;
        return val;
    }

    public void changePlayer(){
        if(curr_play == '1'){
            curr_play = '2';
            if(mode == 'c')
            turn.setText("Computer Turn");
            else
                turn.setText("Player(2) Turn");
        }
        else{
            curr_play = '1';
            if(mode == 'c')
            turn.setText("Player Turn");
            else
                turn.setText("Player(1) Turn");
        }
    }

    public boolean checkWin(String curr){
        // --------->
        if(bttn1.getText().equals(bttn2.getText()) && bttn3.getText().equals(bttn2.getText()) && !bttn1.getText().equals("") && !bttn2.getText().equals("") && !bttn3.getText().equals("")) {
            displayScore();
            win = true;
            return true;
        }
        if(bttn4.getText().equals(bttn5.getText()) && bttn6.getText().equals(bttn5.getText()) && !bttn4.getText().equals("") && !bttn5.getText().equals("") && !bttn6.getText().equals("")) {
            displayScore();
            win = true;
            return true;
        }
        if(bttn7.getText().equals(bttn8.getText()) && bttn9.getText().equals(bttn8.getText()) && !bttn8.getText().equals("") && !bttn7.getText().equals("") && !bttn9.getText().equals("")) {
            displayScore();
            win = true;
            return true;
        }

        /*
        * |
        * |
        * |
        * V
        * */
        if(bttn1.getText().equals(bttn4.getText()) && bttn7.getText().equals(bttn4.getText()) && !bttn1.getText().equals("") && !bttn4.getText().equals("") && !bttn7.getText().equals("")) {
            displayScore();
            win = true;
            return true;
        }
        if(bttn2.getText().equals(bttn5.getText()) && bttn8.getText().equals(bttn5.getText()) && !bttn2.getText().equals("") && !bttn5.getText().equals("") && !bttn8.getText().equals("")) {
            displayScore();
            win = true;
            return true;
        }
        if(bttn3.getText().equals(bttn6.getText()) && bttn9.getText().equals(bttn6.getText()) && !bttn3.getText().equals("") && !bttn6.getText().equals("") && !bttn9.getText().equals("")) {
            displayScore();
            win = true;
            return true;
        }

        //Diagonal
        if(bttn1.getText().equals(bttn5.getText()) && bttn9.getText().equals(bttn5.getText()) && !bttn1.getText().equals("") && !bttn5.getText().equals("") && !bttn9.getText().equals("")) {
            displayScore();
            win = true;
            return true;
        }
        if(bttn3.getText().equals(bttn5.getText()) && bttn7.getText().equals(bttn5.getText()) && !bttn3.getText().equals("") && !bttn5.getText().equals("") && !bttn7.getText().equals("")) {
            displayScore();
            win = true;
            return true;
        }

        else if(allfill == 9){
            tie += 1;
            win = true;
            tie_score.setText(String.valueOf(tie));
            turn.setText("Draw");
            return false;
        }
        return false;
    }

    public void displayScore(){
        if(curr_play == '1'){
            ply1 += 1;
            player1_score.setText(String.valueOf(ply1));
            if(mode == 'c')
            turn.setText("Player Wins");
            else
                turn.setText("Palyer1 wins");
        }
        else{
            ply2 += 1;
            player2_score.setText(String.valueOf(ply2));
            if(mode == 'c')
            turn.setText("Computer Wins");
            else
                turn.setText("Player 2 wins");
        }
    }

    public void playAgain(){
        bttn1.setText("");
        bttn2.setText("");
        bttn3.setText("");
        bttn4.setText("");
        bttn5.setText("");
        bttn6.setText("");
        bttn7.setText("");
        bttn8.setText("");
        bttn9.setText("");
        allfill = 0;
        curr_play = '1';

        if(current_val == 'x'){
            current_val = 'o';
            if(mode == 'c'){
                p1_text.setText("Player (O)");
                p2_text.setText("Computer (X)");
            }
            else{
                p1_text.setText("Player1 (O)");
                p2_text.setText("Player2 (X)");
            }

        }
        else{
            current_val = 'x';
            if(mode == 'c'){
                p1_text.setText("Player (X)");
                p2_text.setText("Computer (O)");
            }
            else{
                p1_text.setText("Player1 (X)");
                p2_text.setText("Player2 (O)");
            }
        }
        if(mode == 'c')
         turn.setText("Player Turn");
        else
            turn.setText("Player(1)");
        win = false;
    }


    public void decideMove(){

        int num = (int) (Math.random()*(9-1+1)+1);

        if(allfill == 9){
            checkWin(String.valueOf(curr_play));
            turn.setText("Player Turn");
            if(!win)
             changePlayer();
            return;
        }
        if(num == 1 && bttn1.getText().equals("")){
            String val = currentValue();
            bttn1.setText(val);
            turn.setText("Player Turn");
            checkWin(String.valueOf(curr_play));
            if(!win)
             changePlayer();
            return;
        }
        if(num == 2 && bttn2.getText().equals("")){
            String val = currentValue();
            bttn2.setText(val);
            turn.setText("Player Turn");
            checkWin(String.valueOf(curr_play));
            if(!win)
             changePlayer();
            return;
        }
        if(num == 3 && bttn3.getText().equals("")){
            String val = currentValue();
            bttn3.setText(val);
            turn.setText("Player Turn");
            if(!win)
             changePlayer();
            return;
        }
        if(num == 4 && bttn4.getText().equals("")){
            String val = currentValue();
            bttn4.setText(val);
            turn.setText("Player Turn");
            checkWin(String.valueOf(curr_play));
            if(!win)
             changePlayer();
            return;
        }
        if(num == 5 && bttn5.getText().equals("")){
            String val = currentValue();
            bttn5.setText(val);
            turn.setText("Player Turn");
            checkWin(String.valueOf(curr_play));
            if(!win)
             changePlayer();
            return;
        }
        if(num == 6 && bttn6.getText().equals("")){
            String val = currentValue();
            bttn6.setText(val);
            turn.setText("Player Turn");
            checkWin(String.valueOf(curr_play));
            if(!win)
             changePlayer();
            return;
        }
        if(num == 7 && bttn7.getText().equals("")){
            String val = currentValue();
            bttn7.setText(val);
            turn.setText("Player Turn");
            checkWin(String.valueOf(curr_play));
            if(!win)
             changePlayer();
            return;
        }
        if(num == 8 && bttn8.getText().equals("")){
            String val = currentValue();
            bttn8.setText(val);
            turn.setText("Player Turn");
            checkWin(String.valueOf(curr_play));
            if(!win)
             changePlayer();
            return;
        }
        if(num == 9 && bttn9.getText().equals("")) {
            String val = currentValue();
            bttn9.setText(val);
            turn.setText("Player Turn");
            checkWin(String.valueOf(curr_play));
            if(!win)
             changePlayer();
            return;
        }
        decideMove();
    }
}