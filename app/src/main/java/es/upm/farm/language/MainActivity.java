package es.upm.farm.language;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.market_button).setOnClickListener(this::openMarket);
    }

    private void openMarket(View view) {
        startActivity(new Intent(this, MarketActivity.class));
    }
}