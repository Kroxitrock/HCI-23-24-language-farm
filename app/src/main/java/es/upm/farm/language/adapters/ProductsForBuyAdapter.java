package es.upm.farm.language.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.upm.farm.language.R;
import es.upm.farm.language.models.ProductsForBuy;

public class ProductsForBuyAdapter extends RecyclerView.Adapter<ProductsForBuyAdapter.ViewHolder> {

    private List<ProductsForBuy> dataList;
    private OnAddButtonClickListener addButtonClickListener;


    public interface OnAddButtonClickListener {
        void onAddButtonClick(ProductsForBuy dataModel);
    }

    public ProductsForBuyAdapter(List<ProductsForBuy> dataList, OnAddButtonClickListener addButtonClickListener) {
        this.dataList = dataList;
        //The click listener from the parent
        this.addButtonClickListener = addButtonClickListener;
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
        holder.priceTextView.setText(data.getPrice().toString());
        addAddClickListener(holder, data);
    }

    private void addAddClickListener(@NonNull ViewHolder holder, ProductsForBuy data) {
        holder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (addButtonClickListener != null) {
                    addButtonClickListener.onAddButtonClick(data);
                    holder.counter++;
                    holder.counterTextView.setText(String.valueOf(holder.counter));
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView productTextView;
        TextView priceTextView;
        ImageButton addButton;

        //counter for the number of the current item added to the basket
        int counter;

        //the view that shows the counter
        TextView counterTextView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productTextView = itemView.findViewById(R.id.product);
            priceTextView = itemView.findViewById(R.id.price);
            addButton = itemView.findViewById(R.id.add);
            counterTextView = itemView.findViewById(R.id.counterTextView);
        }
    }
}
