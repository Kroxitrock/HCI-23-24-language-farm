package es.upm.farm.language;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class lang_ex3_activity extends AppCompatActivity {

    Button btn_continue;
    TextView text_valid_answer;

    protected void onCreate(Bundle saveInstances) {

        super.onCreate(saveInstances);
        setContentView(R.layout.lang_exercise3_layout);

        btn_continue = findViewById(R.id.btn_continue);
        btn_continue.setVisibility(View.INVISIBLE);
        text_valid_answer = findViewById(R.id.text_valid_answer);
        text_valid_answer.setVisibility(View.INVISIBLE);

        Button btn_madrid = findViewById(R.id.btn_madrid);
        btn_madrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInput(1);
            }
        });

        Button btn_derecha = findViewById(R.id.btn_derecha);
        btn_derecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInput(2);
            }
        });

        Button btn_manzana = findViewById(R.id.btn_manzana);
        btn_manzana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInput(3);
            }
        });

        Button btn_futbol = findViewById(R.id.btn_futbol);
        btn_futbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInput(4);
            }
        });

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent exc_sum = new Intent(lang_ex3_activity.this, ex_sum_activity.class);
                //startActivity(exc_sum);
            }
        });
    }

    protected void validateInput(Integer option){
        if (option == 2){
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
