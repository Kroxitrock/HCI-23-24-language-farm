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

public class lang_ex3_activity extends AppCompatActivity {

    Button btn_continue;
    TextView text_valid_answer;

    private Integer cheese_count;

    protected void onCreate(Bundle saveInstances) {

        super.onCreate(saveInstances);
        setContentView(R.layout.lang_exercise3_layout);

        btn_continue = findViewById(R.id.btn_continue);
        btn_continue.setVisibility(View.INVISIBLE);
        text_valid_answer = findViewById(R.id.text_valid_answer);
        text_valid_answer.setVisibility(View.INVISIBLE);

        //receiving cheese count
        cheese_count = getIntent().getIntExtra("cheese_count", 2);

        //setup media player for audio content
        MediaPlayer mediaPlayer = MediaPlayer.create(lang_ex3_activity.this, R.raw.donde_esta);
        MediaPlayer mediaPlayer_slow_down = MediaPlayer.create(lang_ex3_activity.this, R.raw.donde_esta_slow_down);


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

        btn_continue.setOnClickListener(v -> {
            Intent exc_sum = new Intent(lang_ex3_activity.this, exc_sum_activity.class);
            exc_sum.putExtra("cheese_count", cheese_count);
            startActivity(exc_sum);
        });
    }

    protected void validateInput(Integer option){
        if (option == 2){
            text_valid_answer.setText("Your answer was correct!");
            text_valid_answer.setVisibility(View.VISIBLE);
            btn_continue.setVisibility(View.VISIBLE);
            cheese_count ++;
        }else{
            text_valid_answer.setText("Your answer was not correct.");
            text_valid_answer.setVisibility(View.VISIBLE);
            btn_continue.setBackgroundColor(Color.rgb(106,37,37));
            btn_continue.setVisibility(View.VISIBLE);
        }
    }
}
