package es.upm.farm.language;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class lang_ex2_activity extends AppCompatActivity {

    private Button btn_continue;
    private TextView text_valid_answer;

    private  Integer cheese_count;

    protected void onCreate(Bundle saveInstances) {

        super.onCreate(saveInstances);
        setContentView(R.layout.lang_exercise2_layout);

        btn_continue = findViewById(R.id.btn_continue);
        btn_continue.setVisibility(View.INVISIBLE);
        text_valid_answer = findViewById(R.id.text_valid_answer);
        text_valid_answer.setVisibility(View.INVISIBLE);

        //receiving cheese count
        cheese_count = getIntent().getIntExtra("cheese_count", 1);

        //audio handling
        MediaPlayer mediaPlayer = MediaPlayer.create(lang_ex2_activity.this, R.raw.vaca);


        //set Button Listeners
        Button btn_chicken = findViewById(R.id.btn_chicken);
        btn_chicken.setOnClickListener(v -> handleInput("Chicken"));

        Button btn_cauliflower = findViewById(R.id.btn_cauliflower);
        btn_cauliflower.setOnClickListener(v -> handleInput("Cauliflower"));

        Button btn_cow = findViewById(R.id.btn_cow);
        btn_cow.setOnClickListener(v -> handleInput("Cow"));

        Button btn_pig = findViewById(R.id.btn_pig);
        btn_pig.setOnClickListener(v -> handleInput("Pig"));

        ImageView btn_audio = findViewById(R.id.btn_audio);
        btn_audio.bringToFront();
        btn_audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });

        btn_continue.findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(v -> {
            Intent exercise3 = new Intent(lang_ex2_activity.this, lang_ex3_activity.class);
            exercise3.putExtra("cheese_count", cheese_count);
            startActivity(exercise3);
        });
    }


    protected void handleInput(String word) {
        if (word.equals("Cow")){
            text_valid_answer.setText("Your answer was correct!");
            text_valid_answer.setVisibility(View.VISIBLE);
            btn_continue.setVisibility(View.VISIBLE);
            cheese_count++;

        }else{
            text_valid_answer.setText("Your answer was not correct.");
            text_valid_answer.setVisibility(View.VISIBLE);
            btn_continue.setBackgroundColor(Color.rgb(106,37,37));
            btn_continue.setVisibility(View.VISIBLE);

        }
    }
}
