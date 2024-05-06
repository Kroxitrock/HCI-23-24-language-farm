package es.upm.farm.language;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FirstLanguageExerciseActivity extends AppCompatActivity {

    private Button como_btn;
    private Button estas_btn;
    private Button amigo_btn;

   private Button btn_continue;
   private TextView text_valid_answer;
   private Integer cheese_count = 0;

   private TextView textline_como;
   private TextView textline_estas;
   private TextView textline_amigo;
   private LinearLayout valid_input_box;

    protected void onCreate (Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.lang_exercise1_layout);

        valid_input_box = findViewById(R.id.valid_input_box);
        valid_input_box.setVisibility(View.INVISIBLE);


        //set Button Listeners
        como_btn = (Button) findViewById(R.id.btn_como);
        como_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonInput(como_btn, "Cómo");
            }
        });

        estas_btn = findViewById(R.id.btn_estas);
        estas_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonInput(estas_btn, "estás");
            }
        });

        amigo_btn = findViewById(R.id.btn_amigo);
        amigo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonInput(amigo_btn,"amigo");

            }
        });

        textline_como = findViewById(R.id.textline_como);
        textline_como.setOnClickListener(v -> textline_como.setText("______"));

        textline_estas = findViewById(R.id.textline_estas);
        textline_estas.setOnClickListener(v -> textline_estas.setText("______"));

        textline_amigo = findViewById(R.id.textline_amigo);
        textline_amigo.setOnClickListener(v -> textline_amigo.setText("______"));

        btn_continue = findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exercise2 = new Intent(FirstLanguageExerciseActivity.this, SecondLanguageExerciseActivity.class);
                exercise2.putExtra("cheese_count", cheese_count);
                startActivity(exercise2);
            }
        });
    }

    protected void handleButtonInput(Button pressedButton, String word){
        TextView textline_como = findViewById(R.id.textline_como);
        TextView textline_estas = findViewById(R.id.textline_estas);
        TextView textline_amigo = findViewById(R.id.textline_amigo);

        if (textline_como.getText().equals("______")){
            textline_como.setText(word);
        }else if (textline_estas.getText().equals("______")){
            textline_estas.setText(word);
        } else if (textline_amigo.getText().equals("______")) {
            textline_amigo.setText(word);
            validateInput();
        }else {

        }
    }

    protected void validateInput(){
        TextView textline_como = findViewById(R.id.textline_como);
        TextView textline_estas = findViewById(R.id.textline_estas);
        TextView textline_amigo = findViewById(R.id.textline_amigo);
        text_valid_answer = findViewById(R.id.text_valid_answer);


        if (textline_como.getText().equals("Cómo") && textline_estas.getText().equals("estás") && textline_amigo.getText().equals("amigo")){
            text_valid_answer.setText("Your answer was correct!");
            valid_input_box.setVisibility(View.VISIBLE);
            valid_input_box.setBackgroundColor(Color.rgb(67,160,71));
            cheese_count ++;

        }else{
            text_valid_answer.setText("Your answer was not correct.");
            valid_input_box.setVisibility(View.VISIBLE);
            valid_input_box.setBackgroundColor(Color.rgb(143,42,40));
            btn_continue.setVisibility(View.VISIBLE);
        }

    }


}
