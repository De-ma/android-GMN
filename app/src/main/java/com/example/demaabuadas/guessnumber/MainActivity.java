package com.example.demaabuadas.guessnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.view.MenuItem;
import android.view.Menu;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button mGuessButton;
    TextView mTriesView;
    EditText mGuessEdit;
    TextView mHintView;
    Button mResetButton;

    Random rand = new Random();
    // 100 is the max and 1 is the min :-)
    public int randNum = rand.nextInt((100 - 1) + 1) + 1;
    public int counter = 10;
    public String getInput;
    public int userGuess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGuessButton = (Button) findViewById(R.id.guessBtn);
        mResetButton = (Button) findViewById(R.id.resetBtn);
        mTriesView = (TextView) findViewById(R.id.triesLeft);
        mGuessEdit = (EditText) findViewById(R.id.userInput);
        mHintView = (TextView) findViewById(R.id.hintView);

        mGuessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //What happens when we click the button!!
                getInput = mGuessEdit.getText().toString();
                userGuess = Integer.parseInt(getInput);
                if (counter > 0) {
                    checkGuess(randNum, userGuess);
                }
            }
        });

        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //What happens when we click the reset button!
                // gotta generate a new number and reset the counter ;-)
                randNum = rand.nextInt((100 - 1) + 1) + 1;
                counter = 10;
                mTriesView.setText(Integer.toString(counter));
                mHintView.setText("");

            }
        });

    }

    public void checkGuess(int randomNum, int userNum) {
        if (randomNum > userNum) {
            //The random number is GREATER than the guess
            mHintView.setText("");
            mHintView.setText("Guess Higher!");
            lowerCount();
        } else if (randomNum < userNum) {
            //The random number is LESS THAN the guess
            mHintView.setText("");
            mHintView.setText("Guess Lower!");
            lowerCount();
        } else {
            //The random number IS the guess :-)
            mHintView.setText("");
            mHintView.setText("Your guess is correct!");

        }
    }

    public void lowerCount() {
        counter--;
        mTriesView.setText("");
        mTriesView.setText(Integer.toString(counter));
    }
}
