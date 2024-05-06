package es.upm.farm.language;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

public class SpeakingExercises1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_speaking_exercises1);


        setBlackAudioButton();
        findViewById(R.id.confirm_button).setOnClickListener(v -> showConfirmationMessage());


        findViewById(R.id.btn_continue).setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SpeakingExercises2.class);
            startActivity(intent);
        });

        findViewById(R.id.close_btn).setOnClickListener(v -> showCloseConfirmationDialog());


        addSpeakingFunc();
        addSlowSpeakingFunc();
    }

    private void addSpeakingFunc() {
        MediaPlayer mediaPlayer = MediaPlayer.create(SpeakingExercises1.this, R.raw.de_donde_eres);

        ImageView btn_audio = findViewById(R.id.btn_audio);
        btn_audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });
    }

    private void addSlowSpeakingFunc() {
        MediaPlayer mediaPlayer = MediaPlayer.create(SpeakingExercises1.this, R.raw.de_donde_eres_slow);

        TextView btn_audio = findViewById(R.id.slow_listen);
        btn_audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });
    }

    private void setBlackAudioButton() {
        ImageView btnAudio = findViewById(R.id.btn_audio);
        Drawable drawable = ContextCompat.getDrawable(this, android.R.drawable.ic_lock_silent_mode_off);

        if (drawable != null) {
            // Change the tint color to black
            DrawableCompat.setTint(drawable, Color.BLACK);
            btnAudio.setImageDrawable(drawable);
        }
    }

    private void showConfirmationMessage() {
        ConstraintLayout pop_up = findViewById(R.id.correct_pop_up);
        pop_up.setVisibility(View.VISIBLE);
        TextView result = findViewById(R.id.result);
        TextView answer = findViewById(R.id.answer);
        String answerStr = answer.getText().toString().toLowerCase();
        if (answerStr.contains("de donde eres") || answerStr.contains("de dónde eres")) {
            result.setText("Your answer was correct!");
            pop_up.setBackgroundColor(ContextCompat.getColor(this, R.color.grass));
        } else {
            result.setText("Your answer was not correct!");
            pop_up.setBackgroundColor(Color.rgb(143,42,40));
        }
    }


    private void showCloseConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmation");
        builder.setMessage("Are you sure you want to cancel your speaking exercises?");
        builder.setPositiveButton("Yes", (dialog, id) -> finish());
        builder.setNegativeButton("No", null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}