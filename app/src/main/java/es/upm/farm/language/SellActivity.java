package es.upm.farm.language;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.upm.farm.language.adapters.ProductsForBuyAdapter;
import es.upm.farm.language.models.ProductsForBuy;

public class SellActivity extends AppCompatActivity implements ProductsForBuyAdapter.OnButtonClickListener {

    private static Integer coins = 100;

    private List<ProductsForBuy> dataList;

    private List<ProductsForBuy> productsInCart;
    private TextView totalPrice;

    private View header;
    private TextView totalCoins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buy_sell);


        header = findViewById(R.id.header);
        //set header title
        TextView headerTitle = header.findViewById(R.id.header_title);
        headerTitle.setText("Sell");

        totalCoins = header.findViewById(R.id.coins);
        totalCoins.setText(Integer.toString(coins));

        // Set count of products
        productsInCart = new ArrayList<>();
        totalPrice = findViewById(R.id.total_price);
        totalPrice.setText(String.valueOf(productsInCart.size()));


        loadDataList();
        RecyclerView recyclerView = findViewById(R.id.productsList);
        ProductsForBuyAdapter adapter = new ProductsForBuyAdapter(dataList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        //Set buy click listener
        Button actionButton = findViewById(R.id.action_button);
        actionButton.setText("Sell");
        actionButton.setOnClickListener(v -> {
            handleBuyClicked();
        });

        findViewById(R.id.close_btn).setOnClickListener(view -> {
            finish();
        });

        TextView plus = findViewById(R.id.minusPlusText);
        plus.setText("+");
    }

    private void handleBuyClicked() {
        int totalPrice = Integer.parseInt(this.totalPrice.getText().toString());

        if (totalPrice == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Nothing in the cart!");
            builder.setMessage("You have not selected anything for purchase! Please add some items and try again.");
            builder.setPositiveButton("Got it!", (dialog, id) -> dialog.dismiss());
            AlertDialog dialog = builder.create();
            dialog.show();
            return;
        }

        if (totalPrice > coins) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Not enough coins!");
            builder.setMessage("You do not have enough coins to finish your purchase! Please remove some items and try again.");
            builder.setPositiveButton("Got it!", (dialog, id) -> dialog.dismiss());
            AlertDialog dialog = builder.create();
            dialog.show();
            return;
        }

        showConfirmationDialog(totalPrice);
    }

    private void loadDataList() {
        ProductsForBuy p1 = new ProductsForBuy("Cow", 60);
        ProductsForBuy p2 = new ProductsForBuy("Chicken", 20);
        ProductsForBuy p3 = new ProductsForBuy("Pig", 40);
        ProductsForBuy p4 = new ProductsForBuy("Rabbit", 25);
        dataList = new ArrayList<>();
        dataList.add(p1);
        dataList.add(p2);
        dataList.add(p3);
        dataList.add(p4);
    }

    @Override
    public void onAddButtonClick(ProductsForBuy dataModel) {
        productsInCart.add(dataModel);
        totalPrice.setText(String.valueOf(
                productsInCart.stream()
                        .mapToInt(ProductsForBuy::getPrice)
                        .sum()));
    }

    @Override
    public void onRemoveButtonClick(ProductsForBuy dataModel) {
        productsInCart.remove(dataModel);
        totalPrice.setText(String.valueOf(
                productsInCart.stream()
                        .mapToInt(ProductsForBuy::getPrice)
                        .sum()));
    }

    private void showConfirmationDialog(int totalPrice) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmation");
        builder.setMessage("Are you sure you want to sell these products?");

        // Add the buttons
        builder.setPositiveButton("Sell", (dialog, id) -> {
            coins -= totalPrice;
            totalCoins.setText(String.valueOf(coins));
            dialog.dismiss();
            finish();
        });
        builder.setNegativeButton("Cancel", (dialog, id) -> dialog.dismiss());

        // Create and show the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}