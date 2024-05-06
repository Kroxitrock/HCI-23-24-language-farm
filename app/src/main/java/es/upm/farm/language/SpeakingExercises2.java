package es.upm.farm.language;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SpeakingExercises2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        
        setContentView(R.layout.activity_speaking_exercises2);
        findViewById(R.id.confirm_button).setOnClickListener(this::openCongratsScreen);

        findViewById(R.id.close_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCloseConfirmationDialog();
            }
        });

        addMicrophoneFunc();
        addPlayBtnMedia();
    }

    private void addPlayBtnMedia() {
        TextView answer = findViewById(R.id.user_answer);

        if(answer.getText().equals("")) return;

        MediaPlayer mediaPlayer = MediaPlayer.create(SpeakingExercises2.this, R.raw.yo_soy_de_canada);

        ImageView btn_audio = findViewById(R.id.play_button);
        btn_audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });
    }

    private void addMicrophoneFunc() {
        findViewById(R.id.microphone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView answer = findViewById(R.id.user_answer);
                answer.setText("Yo soy de Canada.");
            }
        });
    }

    private void openCongratsScreen(View view) {
        startActivity(new Intent(this, SpeakingCongratsScreen.class));
    }


    private void showCloseConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmation");
        builder.setMessage("Are you sure you want to cancel your speaking exercises?");
        builder.setPositiveButton("Yes", (dialog, id) -> {
            Intent intent = new Intent(getApplicationContext(), CampFire.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });
        builder.setNegativeButton("No", null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

