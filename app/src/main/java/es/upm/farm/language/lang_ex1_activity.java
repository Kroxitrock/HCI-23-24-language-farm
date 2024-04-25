package es.upm.farm.language;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class lang_ex1_activity extends AppCompatActivity {

    private Button como_btn;
    private Button estas_btn;
    private Button amigo_btn;

   private Button btn_continue;
   private TextView text_valid_answer;

    protected void onCreate (Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.lang_exercise1_layout);

        btn_continue = findViewById(R.id.btn_continue);
        btn_continue.setVisibility(View.INVISIBLE);
        text_valid_answer = findViewById(R.id.text_valid_answer);
        text_valid_answer.setVisibility(View.INVISIBLE);


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

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exercise2 = new Intent(lang_ex1_activity.this, lang_ex2_activity.class);
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

        if (textline_como.getText().equals("Cómo") && textline_estas.getText().equals("estás") && textline_amigo.getText().equals("amigo")){
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
