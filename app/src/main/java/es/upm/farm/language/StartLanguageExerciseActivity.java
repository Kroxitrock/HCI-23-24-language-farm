package es.upm.farm.language;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StartLanguageExerciseActivity extends AppCompatActivity {

    protected void onCreate (Bundle saveInstances) {

        super.onCreate(saveInstances);
        setContentView(R.layout.start_lang_exc_layout);

        Button start_exc = findViewById(R.id.btn_start_exc);
        start_exc.setOnClickListener(v -> {
            Intent exercise1 = new Intent(StartLanguageExerciseActivity.this, FirstLanguageExerciseActivity.class);
            startActivity(exercise1);
        });
    }
}
