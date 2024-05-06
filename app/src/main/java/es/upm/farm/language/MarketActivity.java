package es.upm.farm.language;

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



}