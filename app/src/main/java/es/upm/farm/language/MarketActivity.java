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

        findViewById(R.id.animalStand).setOnClickListener(this::openMarket);
    }


    public void openMarket(View view) {
        startActivity(new Intent(this, BuyActivity.class));
    }


}