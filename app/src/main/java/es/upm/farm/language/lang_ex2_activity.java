package es.upm.farm.language;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class lang_ex2_activity extends AppCompatActivity {

    private Button btn_continue;
    private TextView text_valid_answer;

    protected void onCreate(Bundle saveInstances) {

        super.onCreate(saveInstances);
        setContentView(R.layout.lang_exercise2_layout);

        btn_continue = findViewById(R.id.btn_continue);
        btn_continue.setVisibility(View.INVISIBLE);
        text_valid_answer = findViewById(R.id.text_valid_answer);
        text_valid_answer.setVisibility(View.INVISIBLE);

        //set Button Listeners
        Button btn_chicken = findViewById(R.id.btn_chicken);
        btn_chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleInput("Chicken");
            }
        });

        Button btn_cauliflower = findViewById(R.id.btn_cauliflower);
        btn_cauliflower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleInput("Cauliflower");
            }
        });

        Button btn_cow = findViewById(R.id.btn_cow);
        btn_cow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleInput("Cow");
            }
        });

        Button btn_pig = findViewById(R.id.btn_pig);
        btn_pig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleInput("Pig");
            }
        });

        btn_continue.findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exercise3 = new Intent(lang_ex2_activity.this, lang_ex3_activity.class);
                startActivity(exercise3);
            }
        });
    }


    protected void handleInput(String word) {
        if (word.equals("Cow")){
            text_valid_answer.setText("Your answer was correct!");
            text_valid_answer.setVisibility(View.VISIBLE);
            btn_continue.setVisibility(View.VISIBLE);

        }else{
            text_valid_answer.setText("Your answer was not correct.");
            text_valid_answer.setVisibility(View.VISIBLE);
            btn_continue.setBackgroundColor(Color.RED);
            btn_continue.setVisibility(View.VISIBLE);

        }
    }
}
