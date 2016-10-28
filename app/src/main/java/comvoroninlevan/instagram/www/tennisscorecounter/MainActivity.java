package comvoroninlevan.instagram.www.tennisscorecounter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int firstPlayer, secondPlayer, setCounterOne, setCounterTwo;

    //FIRST PLAYER SCORE COUNTER AND SET SCORE______________________________________________
    public void firstPlayerCounter (View view){

        firstPlayer += 1;

        if(firstPlayer < 4 & secondPlayer < 4){
            scoreFirstPlayer(null);
        } else if(firstPlayer == 4 & secondPlayer < 3){
            gamePlayerOne(null);
        } else if(firstPlayer == 3 & secondPlayer == 3){
            deuce(null);
        } else if(firstPlayer == 4 & secondPlayer == 3){
            advantagePlayerOne(null);
        } else if(firstPlayer == 4 & secondPlayer ==4){
            deuce(null);
        } else if(firstPlayer == 5 & secondPlayer == 3){
            gamePlayerOne(null);
        }
    }

    public void scoreFirstPlayer (View view) {

        TextView scoreFirstPlayerCounter = (TextView) findViewById(R.id.firstPlayerScore);

        if (firstPlayer == 0) {
            scoreFirstPlayerCounter.setText(R.string.zeroPoint);
        } else if (firstPlayer == 1) {
            scoreFirstPlayerCounter.setText(R.string.onePoint);
        } else if (firstPlayer == 2) {
            scoreFirstPlayerCounter.setText(R.string.twoPoint);
        } else if (firstPlayer == 3) {
            scoreFirstPlayerCounter.setText(R.string.threePoint);
        }
    }
    //_______________________________________________________________________________________
    //SECOND PLAYER SCORE COUNTER AND SET SCORE______________________________________________
    public void secondPlayerCounter (View view){

        secondPlayer += 1;

        if(firstPlayer < 4 & secondPlayer < 4){
            scoreSecondPlayer(null);
        } else if(firstPlayer < 3 & secondPlayer == 4){
            gamePlayerTwo(null);
        } else if(firstPlayer == 3 & secondPlayer == 3){
            deuce(null);
        } else if(firstPlayer == 3 & secondPlayer == 4){
            advantagePlayerTwo(null);
        } else if(firstPlayer == 4 & secondPlayer ==4){
            deuce(null);
        } else if(firstPlayer == 3 & secondPlayer == 5){
            gamePlayerTwo(null);
        }
    }

    public void scoreSecondPlayer (View view) {

        TextView scoreSecondPlayerCounter = (TextView) findViewById(R.id.secondPlayerScore);

        if (secondPlayer == 0) {
            scoreSecondPlayerCounter.setText(R.string.zeroPoint);
        } else if (secondPlayer == 1) {
            scoreSecondPlayerCounter.setText(R.string.onePoint);
        } else if (secondPlayer == 2) {
            scoreSecondPlayerCounter.setText(R.string.twoPoint);
        } else if (secondPlayer == 3) {
            scoreSecondPlayerCounter.setText(R.string.threePoint);
        }
    }
    //_______________________________________________________________________________________
    //DEUCE, ADV FOR PLAYER ONE, ADV FOR PLAYER TWO METHODS__________________________________
    public void deuce (View view){

        firstPlayer = 3;
        secondPlayer = 3;

        TextView scoreFirstPlayerCounter = (TextView) findViewById(R.id.firstPlayerScore);
        scoreFirstPlayerCounter.setText(R.string.threePoint);

        TextView scoreSecondPlayerCounter = (TextView) findViewById(R.id.secondPlayerScore);
        scoreSecondPlayerCounter.setText(R.string.threePoint);

    }

    public void advantagePlayerOne (View view){

        TextView scoreFirstPlayerCounter = (TextView) findViewById(R.id.firstPlayerScore);
        scoreFirstPlayerCounter.setText(R.string.advantage);
    }

    public void advantagePlayerTwo (View view){

        TextView scoreSecondPlayerCounter = (TextView) findViewById(R.id.secondPlayerScore);
        scoreSecondPlayerCounter.setText(R.string.advantage);

    }
    //______________________________________________________________________________________
    // SET COUNTERS FOR PLAYER ONE AND TWO__________________________________________________
    public void gamePlayerOne (View view){

        setCounterOne += 1;

        TextView scoreFirstPlayerCounter = (TextView) findViewById(R.id.firstPlayerScore);
        scoreFirstPlayerCounter.setText(R.string.game);

        ImageButton buttonOne = (ImageButton) findViewById(R.id.firstPlayerButton);
        buttonOne.setVisibility(View.INVISIBLE);

        ImageButton buttonTwo = (ImageButton) findViewById(R.id.secondPlayerButton);
        buttonTwo.setVisibility(View.INVISIBLE);

        TextView setOneDisplay = (TextView) findViewById(R.id.setPlayerOne);
        if(setCounterOne == 1){
            setOneDisplay.setText(R.string.firstSet);
        } else if(setCounterOne == 2){
            setOneDisplay.setText(R.string.secondSet);
        } else if(setCounterOne == 3){
            gameOverPlayerOne(null);
        }

    }

    public void gamePlayerTwo (View view) {

        setCounterTwo += 1;

        TextView scoreSecondPlayerCounter = (TextView) findViewById(R.id.secondPlayerScore);
        scoreSecondPlayerCounter.setText(R.string.game);

        ImageButton buttonOne = (ImageButton) findViewById(R.id.firstPlayerButton);
        buttonOne.setVisibility(View.INVISIBLE);

        ImageButton buttonTwo = (ImageButton) findViewById(R.id.secondPlayerButton);
        buttonTwo.setVisibility(View.INVISIBLE);

        TextView setTwoDisplay = (TextView) findViewById(R.id.setPlayerTwo);
        if(setCounterTwo == 1){
            setTwoDisplay.setText(R.string.firstSet);
        } else if(setCounterTwo == 2){
            setTwoDisplay.setText(R.string.secondSet);
        } else if(setCounterTwo == 3){
            gameOverPlayerTwo(null);
        }

    }
    //_________________________________________________________________________________________
    //NEXT SET INSPECTION AND NEXT SET DECLINE_________________________________________________
    public void nextSetInspection (View view){

        if(firstPlayer == 4 & secondPlayer < 3 | firstPlayer == 5 & secondPlayer == 3 |
                firstPlayer < 3 & secondPlayer == 4 | firstPlayer == 3 & secondPlayer == 5){
            nextSet(null);
        } else nextSetDecline(null);
    }

    public void nextSetDecline (View view){

        Context context = getApplicationContext();
        CharSequence text = "Sorry, current set in progress. Use RESET button to start a new tournament";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    //NEXT SET BUTTON AND RESET BUTTON_________________________________________________________
    public void nextSet (View view){

        firstPlayer = 0;
        secondPlayer = 0;

        TextView scoreFirstPlayerCounter = (TextView) findViewById(R.id.firstPlayerScore);
        scoreFirstPlayerCounter.setText(R.string.zeroPoint);

        TextView scoreSecondPlayerCounter = (TextView) findViewById(R.id.secondPlayerScore);
        scoreSecondPlayerCounter.setText(R.string.zeroPoint);

        ImageButton buttonOne = (ImageButton) findViewById(R.id.firstPlayerButton);
        buttonOne.setVisibility(View.VISIBLE);

        ImageButton buttonTwo = (ImageButton) findViewById(R.id.secondPlayerButton);
        buttonTwo.setVisibility(View.VISIBLE);
    }

    public void resetButton (View view){

        firstPlayer = 0;
        secondPlayer = 0;
        setCounterOne = 0;
        setCounterTwo = 0;

        TextView scoreFirstPlayerCounter = (TextView) findViewById(R.id.firstPlayerScore);
        scoreFirstPlayerCounter.setText(R.string.zeroPoint);

        TextView scoreSecondPlayerCounter = (TextView) findViewById(R.id.secondPlayerScore);
        scoreSecondPlayerCounter.setText(R.string.zeroPoint);

        TextView setOneDisplay = (TextView) findViewById(R.id.setPlayerOne);
        setOneDisplay.setText("");

        TextView setTwoDisplay = (TextView) findViewById(R.id.setPlayerTwo);
        setTwoDisplay.setText("");

        Button nextSet = (Button) findViewById(R.id.nextSet);
        nextSet.setVisibility(View.VISIBLE);

        ImageButton buttonOne = (ImageButton) findViewById(R.id.firstPlayerButton);
        buttonOne.setVisibility(View.VISIBLE);

        ImageButton buttonTwo = (ImageButton) findViewById(R.id.secondPlayerButton);
        buttonTwo.setVisibility(View.VISIBLE);
    }
    //_____________________________________________________________________________________

    //PLAYER ONE WINS______________________________________________________________________
    public void gameOverPlayerOne (View view){

        TextView setOneDisplay = (TextView) findViewById(R.id.setPlayerOne);
        setOneDisplay.setText(R.string.thirdSet);

        EditText playerOne = (EditText) findViewById(R.id.namePlayerOne);
        String name = playerOne.getText().toString();

        Button nextSet = (Button) findViewById(R.id.nextSet);
        nextSet.setVisibility(View.INVISIBLE);

        Context context = getApplicationContext();
        CharSequence text = "Congratulations, " + name + " Wins!!!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        TextView scoreWin = (TextView) findViewById(R.id.firstPlayerScore);
        scoreWin.setText(R.string.win);
    }
    //____________________________________________________________________________________
    //PLAYER TWO WINS_____________________________________________________________________
    public void gameOverPlayerTwo (View view){

        TextView setTwoDisplay = (TextView) findViewById(R.id.setPlayerTwo);
        setTwoDisplay.setText(R.string.thirdSet);

        EditText playerTwo = (EditText) findViewById(R.id.namePlayerTwo);
        String name = playerTwo.getText().toString();

        Button nextSet = (Button) findViewById(R.id.nextSet);
        nextSet.setVisibility(View.INVISIBLE);

        Context context = getApplicationContext();
        CharSequence text = "Congratulations, " + name + " Wins";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        TextView scoreWin = (TextView) findViewById(R.id.secondPlayerScore);
        scoreWin.setText(R.string.win);
    }
    //___________________________________________________________________________________
}
