package es.upm.farm.language;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SpeakingExercises2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_speaking_exercises2);
        findViewById(R.id.confirm_button).setOnClickListener(this::openCongratsScreen);

    }

    private void openCongratsScreen(View view) {
        startActivity(new Intent(this, SpeakingCongratsScreen.class));
    }
}

