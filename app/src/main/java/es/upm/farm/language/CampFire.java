package es.upm.farm.language;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
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
        findViewById(R.id.market_button).setOnClickListener(this::openMarket);
        findViewById(R.id.factory_button).setOnClickListener(this::openFactory);
        findViewById(R.id.farm_button).setOnClickListener(this::openFarmMarket);
    }


    private void openSpeakingEx1(View view) {
        startActivity(new Intent(this, SpeakingExercises1.class));
    }

    private void openMarket(View view) {
        startActivity(new Intent(this, MarketActivity.class));
    }

    private void openFactory(View view) {
        startActivity(new Intent(this, FirstLanguageExerciseActivity.class));
    }

    private void openFarmMarket(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

}