package es.upm.farm.language.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

import es.upm.farm.language.R;
import es.upm.farm.language.models.ProductsForBuy;

public class ProductsForBuyAdapter extends RecyclerView.Adapter<ProductsForBuyAdapter.ViewHolder> {

    private final List<ProductsForBuy> dataList;
    private final OnButtonClickListener buttonClickListener;

    public ProductsForBuyAdapter(List<ProductsForBuy> dataList, OnButtonClickListener buttonClickListener) {
        this.dataList = dataList;
        //The click listener from the parent
        this.buttonClickListener = buttonClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_buy, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductsForBuy data = dataList.get(position);
        // Bind your data to the views in your list_item_buy.xml layout
        holder.productTextView.setText(data.getProduct());
        holder.priceTextView.setText(String.format(Locale.ENGLISH, "Price: %d", data.getPrice()));

        if (data.getOwn() < Integer.MAX_VALUE) {
            holder.own.setText("Own: " + data.getOwn());
        }

        addClickListener(holder, data);
        removeClickListener(holder, data);
    }

    private void addClickListener(@NonNull ViewHolder holder, ProductsForBuy data) {
        holder.addButton.setOnClickListener(view -> {
            if (buttonClickListener != null && holder.counter < data.getOwn()) {
                buttonClickListener.onAddButtonClick(data);
                holder.counter++;
                holder.counterTextView.setText(String.valueOf(holder.counter));
            }
        });
    }

    private void removeClickListener(@NonNull ViewHolder holder, ProductsForBuy data) {
        holder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonClickListener != null && holder.counter > 0) {
                    buttonClickListener.onRemoveButtonClick(data);
                    holder.counter--;
                    holder.counterTextView.setText(String.valueOf(holder.counter));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public interface OnButtonClickListener {
        void onAddButtonClick(ProductsForBuy dataModel);

        void onRemoveButtonClick(ProductsForBuy dataModel);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView productTextView;
        TextView priceTextView;
        ImageButton addButton;
        ImageButton removeButton;

        TextView own;

        //counter for the number of the current item added to the basket
        int counter;

        //the view that shows the counter
        TextView counterTextView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productTextView = itemView.findViewById(R.id.product);
            priceTextView = itemView.findViewById(R.id.price);
            addButton = itemView.findViewById(R.id.add);
            removeButton = itemView.findViewById(R.id.remove);
            counterTextView = itemView.findViewById(R.id.counterTextView);
            own = itemView.findViewById(R.id.own);
        }
    }
}
