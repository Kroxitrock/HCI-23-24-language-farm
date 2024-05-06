package es.upm.farm.language;

import android.app.AlertDialog;
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

        findViewById(R.id.farm_house).setOnClickListener(this::underConstruction);
        findViewById(R.id.hen_house_1).setOnClickListener(this::underConstruction);
        findViewById(R.id.hen_house_2).setOnClickListener(this::underConstruction);
        findViewById(R.id.cows).setOnClickListener(this::underConstruction);
    }

    private void underConstruction(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Under construction!");
        builder.setMessage("This functionality is not yet available!");
        builder.setPositiveButton("Got it!", (dialog, id) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
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