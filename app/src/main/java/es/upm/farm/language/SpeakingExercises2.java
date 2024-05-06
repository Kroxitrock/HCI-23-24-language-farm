package es.upm.farm.language;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SpeakingExercises2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_speaking_exercises2);
        findViewById(R.id.confirm_button).setOnClickListener(this::openCongratsScreen);

        findViewById(R.id.close_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCloseConfirmationDialog();
            }
        });
    }

    private void openCongratsScreen(View view) {
        startActivity(new Intent(this, SpeakingCongratsScreen.class));
    }


    private void showCloseConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmation");
        builder.setMessage("Are you sure you want to cancel your speaking exercises?");
        builder.setPositiveButton("Yes", (dialog, id) -> {
            Intent intent = new Intent(getApplicationContext(), CampFire.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });
        builder.setNegativeButton("No", null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

