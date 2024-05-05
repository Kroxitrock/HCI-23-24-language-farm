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
        findViewById(R.id.animalStand).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMarket(view);
            }
        });
    }


    public void openMarket(View view) {
        Intent intent = new Intent(this, BuyActivity.class);
        startActivity(intent);
    }


}