package es.upm.farm.language;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SpeakingExercises1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_speaking_exercises1);
        findViewById(R.id.confirm_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationMessage();
            }
        });


        findViewById(R.id.btn_continue).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SpeakingExercises2.class);
                startActivity(intent);
            }
        });
    }

    private void showConfirmationMessage(){
        findViewById(R.id.correct_pop_up).setVisibility(View.VISIBLE);
        TextView result = findViewById(R.id.result);
        TextView answer = findViewById(R.id.answer);
        String answerStr = answer.getText().toString().toLowerCase();
        if (answerStr.contains("de donde eres") || answerStr.contains("de dónde eres") ){
            result.setText("Correct answer!");
        } else {
            result.setText("Wrong answer!");
        }
    }
}