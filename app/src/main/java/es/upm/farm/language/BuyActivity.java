package es.upm.farm.language;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.upm.farm.language.adapters.ProductsForBuyAdapter;
import es.upm.farm.language.models.ProductsForBuy;

public class BuyActivity extends AppCompatActivity implements ProductsForBuyAdapter.OnButtonClickListener {

    private List<ProductsForBuy> dataList;

    private List<ProductsForBuy> productsInCart;
    private TextView totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buy);

        //set header title
        TextView headerTitle = findViewById(R.id.header).findViewById(R.id.header_title);
        headerTitle.setText("Buy");

        // Set count of products
        productsInCart = new ArrayList<>();
        totalPrice = findViewById(R.id.totalPrice);
        totalPrice.setText(String.valueOf(productsInCart.size()));

        //load the list with items for buying
        loadDataList();
        RecyclerView recyclerView = findViewById(R.id.productsList);
        ProductsForBuyAdapter adapter = new ProductsForBuyAdapter(dataList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        //Set buy click listener
        findViewById(R.id.buyButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the confirmation dialog
                showConfirmationDialog();
            }
        });
    }

    private void loadDataList() {
        ProductsForBuy p1 = new ProductsForBuy("Cow", 10);
        ProductsForBuy p2 = new ProductsForBuy("Chicken", 20);
        ProductsForBuy p3 = new ProductsForBuy("Pig", 30);
        ProductsForBuy p4 = new ProductsForBuy("Rabbit", 15);
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
                        .mapToDouble(ProductsForBuy::getPrice)
                        .sum()));
    }

    @Override
    public void onRemoveButtonClick(ProductsForBuy dataModel) {
        productsInCart.remove(dataModel);
        totalPrice.setText(String.valueOf(
                productsInCart.stream()
                        .mapToDouble(ProductsForBuy::getPrice)
                        .sum()));
    }


    private void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmation");
        builder.setMessage("Are you sure you want to buy these products?");

        // Add the buttons
        builder.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked Buy button, proceed with the purchase
                // TODO Add here the buy functionality
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog, do nothing
                dialog.dismiss();
            }
        });

        // Create and show the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}