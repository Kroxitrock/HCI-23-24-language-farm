package es.upm.farm.language;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import es.upm.farm.language.databinding.ActivityMarketBinding;

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