package com.example.android.quizapp;

import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private String currentState = "q0"; // intro
    private int nCorrect = 0;


    public void NextQuestion(View V) {

        switch (currentState) {
            case "q0":
                // show next question
                ((TextView) findViewById(R.id.question_view)).setText(R.string.q1);

                // show new image
                Drawable id = ResourcesCompat.getDrawable(getResources(), R.drawable.baeckeoffe, null);
                ((ImageView) findViewById(R.id.img_view)).setImageDrawable(id);

                // show next answer view
                findViewById(R.id.q1_answers).setVisibility(View.VISIBLE);

                // show Next button
                ((Button) findViewById(R.id.button_next)).setText(R.string.next);

                currentState = "q1";
                break;

            case "q1" :
                // check answer
                if (((RadioButton) findViewById(R.id.q1_a3)).isChecked()) nCorrect++;

                // show next question
                ((TextView) findViewById(R.id.question_view)).setText(R.string.q2);

                // hide prev answer view
                findViewById(R.id.q1_answers).setVisibility(View.GONE);

                // show new image
                id = ResourcesCompat.getDrawable(getResources(), R.drawable.alsaciancuisine, null);
                ((ImageView) findViewById(R.id.img_view)).setImageDrawable(id);

                // show new answer view
                findViewById(R.id.user_input).setVisibility(View.VISIBLE);

                currentState = "q2";
                break;


            case "q2" :
                // check answer
                if (((EditText) findViewById(R.id.user_input)).getText().toString().equals(getString(R.string.q2_a1))) {
                    nCorrect++;
                }

                // print next question
                ((TextView) findViewById(R.id.question_view)).setText(R.string.q3);

                // hide prev answer view
                findViewById(R.id.user_input).setVisibility(View.GONE);

                // show new image
                id = ResourcesCompat.getDrawable(getResources(), R.drawable.tarteflambee, null);
                ((ImageView) findViewById(R.id.img_view)).setImageDrawable(id);

                // show new answer view
                findViewById(R.id.q3_answers).setVisibility(View.VISIBLE);

                currentState = "q3";

                break;

            case "q3" :
                // check answer
                boolean correct1 = ((CheckBox) findViewById(R.id.q3_a1)).isChecked();
                boolean correct2 = ((CheckBox) findViewById(R.id.q3_a3)).isChecked();
                boolean correct3 = ((CheckBox) findViewById(R.id.q3_a4)).isChecked();

                if (correct1 & correct2 & correct3)  nCorrect++;

                // print next question
                ((TextView) findViewById(R.id.question_view)).setText(R.string.q4);

                // show new image
                id = ResourcesCompat.getDrawable(getResources(), R.drawable.spaetzle, null);
                ((ImageView) findViewById(R.id.img_view)).setImageDrawable(id);

                // hide prev answer view
                findViewById(R.id.q3_answers).setVisibility(View.GONE);

                // show next answer view
                findViewById(R.id.q4_answers).setVisibility(View.VISIBLE);


                currentState = "q4";

                break;

            case "q4" :

                // check answer
                if (((RadioButton) findViewById(R.id.q4_a1)).isChecked()) nCorrect++;

                // print next question
                ((TextView) findViewById(R.id.question_view)).setText(R.string.q5);

                // show new image
                id = ResourcesCompat.getDrawable(getResources(), R.drawable.riesling, null);
                ((ImageView) findViewById(R.id.img_view)).setImageDrawable(id);

                // hide prev answer view
                findViewById(R.id.q4_answers).setVisibility(View.GONE);

                // show new answer view
                findViewById(R.id.q5_answers).setVisibility(View.VISIBLE);

                currentState = "q5";

                break;

            case "q5" :
                // check answer
                correct1 = ((CheckBox) findViewById(R.id.q5_a1)).isChecked();
                correct2 = ((CheckBox) findViewById(R.id.q5_a2)).isChecked();
                correct3 = ((CheckBox) findViewById(R.id.q5_a3)).isChecked();

                if (correct1 & correct2 & correct3)  nCorrect++;

                // print next question
                ((TextView) findViewById(R.id.question_view)).setText(R.string.q6);

                // show new image
                id = ResourcesCompat.getDrawable(getResources(), R.drawable.bredele, null);
                ((ImageView) findViewById(R.id.img_view)).setImageDrawable(id);

                // hide prev answer view
                findViewById(R.id.q5_answers).setVisibility(View.GONE);

                // show new answer view
                findViewById(R.id.q6_answers).setVisibility(View.VISIBLE);

                currentState = "q6";

                break;

            case "q6" :
                // check answer
                if (((RadioButton) findViewById(R.id.q6_a3)).isChecked()) nCorrect++;

                // print next question
                ((TextView) findViewById(R.id.question_view)).setText(R.string.q7);

                // show new image
                id = ResourcesCompat.getDrawable(getResources(), R.drawable.cuisses, null);
                ((ImageView) findViewById(R.id.img_view)).setImageDrawable(id);

                // hide prev answer view
                findViewById(R.id.q6_answers).setVisibility(View.GONE);

                // show new answer view
                ((EditText) findViewById(R.id.user_input)).setText("");
                ((EditText) findViewById(R.id.user_input)).setInputType(InputType.TYPE_CLASS_TEXT);
                findViewById(R.id.user_input).setVisibility(View.VISIBLE);

                currentState = "q7";

                break;

            case "q7" :
                // check answer
                String answer_q7 = ((EditText) findViewById(R.id.user_input)).getText().toString().trim().toLowerCase();
                if (answer_q7.equals(getString(R.string.q7_a1))) {
                    nCorrect++;
                }

                // hide prev answer view
                findViewById(R.id.user_input).setVisibility(View.GONE);

                int score = CalculateScore();

                String result = getText(R.string.your_score) + " " + Integer.toString(score) + "% ! ";

                switch (nCorrect) {
                    case 7:
                        result += getText(R.string.result1);
                        break;

                    case 6:
                        result += getText(R.string.result2);
                        break;
                    case 5:
                        result += getText(R.string.result3);
                        break;
                    case 4:
                        result += getText(R.string.result3);
                        break;
                    default:
                        result += getText(R.string.result4);
                        break;
                }


                // print result
                ((TextView) findViewById(R.id.question_view)).setText(result);

                // show new image
                id = ResourcesCompat.getDrawable(getResources(), R.drawable.alsace, null);
                ((ImageView) findViewById(R.id.img_view)).setImageDrawable(id);

                // show Restart button
                ((Button) findViewById(R.id.button_next)).setText(R.string.restart);

                currentState = "end";

                break;

            case "end" :

                // reset counter

                nCorrect = 0;

                // reset answer fields

                ((EditText) findViewById(R.id.user_input)).setText("");
                ((EditText) findViewById(R.id.user_input)).setInputType(InputType.TYPE_CLASS_NUMBER);


                ((RadioButton) findViewById(R.id.q1_a1)).setChecked(false);
                ((RadioButton) findViewById(R.id.q1_a2)).setChecked(false);
                ((RadioButton) findViewById(R.id.q1_a3)).setChecked(false);
                ((RadioButton) findViewById(R.id.q1_a4)).setChecked(false);

                ((RadioButton) findViewById(R.id.q4_a1)).setChecked(false);
                ((RadioButton) findViewById(R.id.q4_a2)).setChecked(false);
                ((RadioButton) findViewById(R.id.q4_a3)).setChecked(false);

                ((RadioButton) findViewById(R.id.q6_a1)).setChecked(false);
                ((RadioButton) findViewById(R.id.q6_a2)).setChecked(false);
                ((RadioButton) findViewById(R.id.q6_a3)).setChecked(false);
                ((RadioButton) findViewById(R.id.q6_a4)).setChecked(false);

                ((CheckBox) findViewById(R.id.q3_a1)).setChecked(false);
                ((CheckBox) findViewById(R.id.q3_a2)).setChecked(false);
                ((CheckBox) findViewById(R.id.q3_a3)).setChecked(false);
                ((CheckBox) findViewById(R.id.q3_a4)).setChecked(false);
                ((CheckBox) findViewById(R.id.q3_a5)).setChecked(false);

                ((CheckBox) findViewById(R.id.q5_a1)).setChecked(false);
                ((CheckBox) findViewById(R.id.q5_a2)).setChecked(false);
                ((CheckBox) findViewById(R.id.q5_a3)).setChecked(false);
                ((CheckBox) findViewById(R.id.q5_a4)).setChecked(false);


                // show intro
                ((TextView) findViewById(R.id.question_view)).setText(R.string.welcome);

                // show Next button
                ((Button) findViewById(R.id.button_next)).setText(R.string.next);

                // reset state
                currentState = "q0";
                break;


            default: break;


        }


    }

    private int CalculateScore() {
        int nQuestions = 7;
        return ( (int) (((double) nCorrect )/ nQuestions * 100)) ;
    }


}
