package es.upm.farm.language;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CampFire extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_camp_fire);
        findViewById(R.id.start_exc).setOnClickListener(this::openSpeakingEx1);
    }


    private void openSpeakingEx1(View view) {
        startActivity(new Intent(this, SpeakingExercises1.class));
    }
}