package es.upm.farm.language;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExerciseSumActivity extends AppCompatActivity {

    private Integer cheese_count;

    protected void onCreate(Bundle saveInstances) {

        super.onCreate(saveInstances);
        setContentView(R.layout.exc_summary);

        //get number of cheeses
        cheese_count = getIntent().getIntExtra("cheese_count", 3);
        TextView text_cheese_count = findViewById(R.id.text_cheese_count);
        TextView text_congrats = findViewById(R.id.text_congratulations);

        if (cheese_count == 0){
            text_congrats.setText("Keep practicing!");
        }else{
            text_congrats.setText("Congratulations!!!");
        }

        text_cheese_count.setText(cheese_count.toString() + "x ");

        Button btn_back_to_farm = findViewById(R.id.btn_back_to_farm);
        /**
         *
         * btn_back_to_farm.setOnClickListener(v ->);
         */

    }
}
