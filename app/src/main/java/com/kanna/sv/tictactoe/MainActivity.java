package com.kanna.sv.tictactoe;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    //    grid
    static CardView r1c1, r1c2, r1c3, r2c1, r2c2, r2c3, r3c1, r3c2, r3c3;
    static TextView t1r1;
    static TextView t2r1;
    static TextView t3r1;
    static TextView t1r2;
    static TextView t2r2;
    static TextView t3r2;
    static TextView t1r3;
    static TextView t2r3;
    static TextView t3r3;

    //    score board
    static TextView wins_o;
    static TextView wins_x;
    static TextView tie;
    static int nowins_o;
    static int nowins_x;
    static int draw;

    //    controler
    static CardView resetbutton;

    //    turn
    static CardView turn_x, turn_o;
    static TextView turntext_x, turntext_o;

    static boolean turnCase = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        grid - cardview
        r1c1 = findViewById(R.id.r1c1);
        r1c2 = findViewById(R.id.r1c2);
        r1c3 = findViewById(R.id.r1c3);

        r2c1 = findViewById(R.id.r2c1);
        r2c2 = findViewById(R.id.r2c2);
        r2c3 = findViewById(R.id.r2c3);

        r3c1 = findViewById(R.id.r3c1);
        r3c2 = findViewById(R.id.r3c2);
        r3c3 = findViewById(R.id.r3c3);

//         grid - textview

        t1r1 = findViewById(R.id.t1r1);
        t1r2 = findViewById(R.id.t1r2);
        t1r3 = findViewById(R.id.t1r3);

        t2r1 = findViewById(R.id.t2r1);
        t2r2 = findViewById(R.id.t2r2);
        t2r3 = findViewById(R.id.t2r3);

        t3r1 = findViewById(R.id.t3r1);
        t3r2 = findViewById(R.id.t3r2);
        t3r3 = findViewById(R.id.t3r3);

//        Score board textview + int counters

        wins_o = findViewById(R.id.counter_o);
        wins_x = findViewById(R.id.counter_x);
        tie = findViewById(R.id.counter_tie);

        nowins_o = 0;
        nowins_x = 0;
        draw = 0;

//        reset button

        resetbutton = findViewById(R.id.reset);

//        turn
        turn_x = findViewById(R.id.turnbtn_x);
        turn_o = findViewById(R.id.turnbtn_o);

        turntext_o = findViewById(R.id.turn_o);
        turntext_x = findViewById(R.id.turn_x);


//        button click functions

//        reset button
        resetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

        Click(r1c1 , t1r1);
        Click(r1c2 , t2r1);
        Click(r1c3 , t3r1);

        Click(r2c1 , t1r2);
        Click(r2c2 , t2r2);
        Click(r2c3 , t3r2);

        Click(r3c1 , t1r3);
        Click(r3c2 , t2r3);
        Click(r3c3 , t3r3);




        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void reset() {
        t1r1.setText("");
        t2r1.setText("");
        t3r1.setText("");

        t1r2.setText("");
        t2r2.setText("");
        t3r2.setText("");

        t1r3.setText("");
        t2r3.setText("");
        t3r3.setText("");

        turntext_x.setTextColor(getColor(R.color.color_x));
        turn_x.setCardBackgroundColor(getColor(R.color.white));

        turntext_o.setTextColor(getColor(R.color.white));
        turn_o.setCardBackgroundColor(getColor(R.color.color_o));
    }

    private static void Click(CardView cardView, TextView textView) {
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckEmptyAndPlay(textView);
                Win();
            }
        });
    }

    @SuppressLint("ResourceAsColor")
    private static void CheckEmptyAndPlay(TextView text) {
        if (text.getText().equals("")) {
            if (turnCase == true) {
                text.setText("O");
                text.setTextColor(R.color.color_o);
                turn_x.setCardBackgroundColor(R.color.color_x);
                turntext_x.setTextColor(R.color.white);
            }
            if (turnCase == false) {
                text.setText("X");
                text.setTextColor(R.color.color_x);
                turn_o.setCardBackgroundColor(R.color.white);
                turntext_o.setTextColor(R.color.color_o);
            }
        }

    }

    private static void Win() {
//      straight
        if (t1r1.equals("") || t2r1.equals("") || t3r1.equals("")) {
        } else {
            if (t1r1.equals(t2r1) && t2r1.equals(t3r1)) {
                if (t1r1.equals("X")) {
                    nowins_x += 1;
                    wins_x.setText(nowins_x + " Wins");
                } else if (t1r1.equals("O")) {
                    nowins_o += 1;
                    wins_o.setText(nowins_x + " Wins");
                }
            }
        }
        if (t1r2.equals("") || t2r2.equals("") || t3r2.equals("")) {
        } else {
            if (t1r2.equals(t2r2) && t2r2.equals(t3r2)) {
                if (t1r2.equals("X")) {
                    nowins_x += 1;
                    wins_x.setText(nowins_x + " Wins");
                } else if (t1r2.equals("O")) {
                    nowins_o += 1;
                    wins_o.setText(nowins_x + " Wins");
                }
            }
        }

        if (t1r3.equals("") || t2r3.equals("") || t3r3.equals("")) {
        } else {
            if (t1r3.equals(t2r3) && t2r3.equals(t3r3)) {
                if (t1r3.equals("X")) {
                    nowins_x += 1;
                    wins_x.setText(nowins_x + " Wins");
                } else if (t1r3.equals("O")) {
                    nowins_o += 1;
                    wins_o.setText(nowins_x + " Wins");
                }
            }
        }
//        diagonal
        if (t1r1.equals("") || t2r2.equals("") || t3r3.equals("")) {
        } else {
            if (t1r1.equals(t2r2) && t2r2.equals(t3r3)) {
                if (t1r1.equals("X")) {
                    nowins_x += 1;
                    wins_x.setText(nowins_x + " Wins");
                } else if (t1r1.equals("O")) {
                    nowins_o += 1;
                    wins_o.setText(nowins_x + " Wins");
                }
            }
        }

        if (t3r1.equals("") || t2r2.equals("") || t1r3.equals("")) {
        } else {
            if (t3r1.equals(t2r2) && t2r2.equals(t1r3)) {
                if (t3r1.getText().toString().equals("X")) {
                    nowins_x += 1;
                    wins_x.setText(nowins_x + " Wins");
                } else if (t3r1.getText().toString().equals("O")) {
                    nowins_o += 1;
                    wins_o.setText(nowins_x+ " Wins");
                }
            }


        }

    }

    public static void Draw(){

        if(t1r1.equals("") && t2r1.equals("") && t3r1.equals("") && t1r2.equals("") && t2r2.equals("") && t3r2.equals("") && t1r3.equals("") && t2r3.equals("") && t3r3.equals("")){}
        else{
            draw += 1;
            tie.setText(draw + "Wins");
        }
    }


}