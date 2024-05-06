package es.upm.farm.language;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static Integer coins = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.market_button).setOnClickListener(this::openMarket);
        findViewById(R.id.speaking_button).setOnClickListener(this::openCampFire);
        findViewById(R.id.factory_button).setOnClickListener(this::openLanguageEx);
    }

    private void openMarket(View view) {
        startActivity(new Intent(this, MarketActivity.class));
    }

    private void openCampFire(View view) {
        startActivity(new Intent(this, CampFire.class));
    }

    private void openLanguageEx(View view) {
        startActivity(new Intent(this, FirstLanguageExerciseActivity.class));
    }
}