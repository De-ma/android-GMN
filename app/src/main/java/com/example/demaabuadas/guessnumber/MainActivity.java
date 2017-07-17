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

    Random rand = new Random();
    // 100 is the max and 1 is the min :-)
    int randNum = rand.nextInt(100) + 1;
    int counter = 10;
    String getInput;
    int userGuess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGuessButton = (Button) findViewById(R.id.guessBtn);
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

    }

    public void checkGuess(int randomNum, int userNum) {
        if (randomNum > userNum) {
            //The random number is GREATER than the guess
            mHintView.setText("");
            mHintView.setText("Guess Higher!");
        } else if (randomNum < userNum) {
            //The random number is LESS THAN the guess
            mHintView.setText("");
            mHintView.setText("Guess Lower!:");
        } else {
            //The random number IS the guess :-)
            mHintView.setText("");
            mHintView.setText("Your guess is correct!");

        }
    }
}
