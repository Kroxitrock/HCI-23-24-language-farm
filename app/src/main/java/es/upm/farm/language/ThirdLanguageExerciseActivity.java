package es.upm.farm.language;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdLanguageExerciseActivity extends AppCompatActivity {

    Button btn_continue;
    TextView text_valid_answer;

    private Integer cheese_count;

    private LinearLayout valid_input_box;

    protected void onCreate(Bundle saveInstances) {

        super.onCreate(saveInstances);
        setContentView(R.layout.lang_exercise3_layout);

        valid_input_box = findViewById(R.id.valid_input_box);
        valid_input_box.setVisibility(View.INVISIBLE);


        //receiving cheese count
        cheese_count = getIntent().getIntExtra("cheese_count", 2);

        //setup media player for audio content
        MediaPlayer mediaPlayer = MediaPlayer.create(ThirdLanguageExerciseActivity.this, R.raw.donde_esta);
        MediaPlayer mediaPlayer_slow_down = MediaPlayer.create(ThirdLanguageExerciseActivity.this, R.raw.donde_esta_slow_down);


        Button btn_madrid = findViewById(R.id.btn_madrid);
        btn_madrid.setOnClickListener(v -> validateInput(1));

        Button btn_derecha = findViewById(R.id.btn_derecha);
        btn_derecha.setOnClickListener(v -> validateInput(2));

        Button btn_manzana = findViewById(R.id.btn_manzana);
        btn_manzana.setOnClickListener(v -> validateInput(3));

        Button btn_futbol = findViewById(R.id.btn_futbol);
        btn_futbol.setOnClickListener(v -> validateInput(4));

        ImageView iView_audio = findViewById(R.id.iView_audio);
        iView_audio.setOnClickListener(v -> mediaPlayer.start());

        Button btn_slow_down = findViewById(R.id.btn_slow_down);
        btn_slow_down.setOnClickListener(v -> mediaPlayer_slow_down.start());

        btn_continue = findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(v -> {
            Intent exc_sum = new Intent(ThirdLanguageExerciseActivity.this, ExerciseSumActivity.class);
            exc_sum.putExtra("cheese_count", cheese_count);
            startActivity(exc_sum);
        });
    }

    protected void validateInput(Integer option){
        text_valid_answer = findViewById(R.id.text_valid_answer);

        if (option == 2){
            text_valid_answer.setText("Your answer was correct!");
            valid_input_box.setVisibility(View.VISIBLE);
            valid_input_box.setBackgroundColor(Color.rgb(67,160,71));
            cheese_count ++;

        }else {
            text_valid_answer.setText("Your answer was not correct.");
            valid_input_box.setVisibility(View.VISIBLE);
            valid_input_box.setBackgroundColor(Color.rgb(143, 42, 40));
            btn_continue.setBackgroundColor(Color.rgb(74, 69, 66));
            btn_continue.setVisibility(View.VISIBLE);
        }
    }
}
