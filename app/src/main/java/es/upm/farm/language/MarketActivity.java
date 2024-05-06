package es.upm.farm.language;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MarketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        findViewById(R.id.animalStand).setOnClickListener(this::openBuyActivity);
        findViewById(R.id.sell_stand).setOnClickListener(this::openSellActivity);
        findViewById(R.id.farm_button).setOnClickListener(this::openFarmActivity);
        findViewById(R.id.speaking_button).setOnClickListener(this::openSpeakingActivity);
        findViewById(R.id.cropStand).setOnClickListener(this::underConstruction);
        findViewById(R.id.buildingStand).setOnClickListener(this::underConstruction);
        findViewById(R.id.factory_button).setOnClickListener(this::openFactoryActivity);
    }

    private void openSpeakingActivity(View view) {
        startActivity(new Intent(this, CampFire.class));
    }

    private void underConstruction(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Under construction!");
        builder.setMessage("This functionality is not yet available!");
        builder.setPositiveButton("Got it!", (dialog, id) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void openBuyActivity(View view) {
        startActivity(new Intent(this, BuyActivity.class));
    }

    private void openSellActivity(View view) {
        startActivity(new Intent(this, SellActivity.class));
    }

    private void openFarmActivity(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    private void openFactoryActivity(View view) {
        startActivity(new Intent(this, FirstLanguageExerciseActivity.class));
    }



}