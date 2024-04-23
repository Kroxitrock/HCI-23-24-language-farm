package es.upm.farm.language.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.upm.farm.language.R;
import es.upm.farm.language.models.ProductsForBuy;

public class ProductsForBuyAdapter extends RecyclerView.Adapter<ProductsForBuyAdapter.ViewHolder> {

    private List<ProductsForBuy> dataList;

    public ProductsForBuyAdapter(List<ProductsForBuy> dataList) {
        this.dataList = dataList;
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
        // Bind other views here
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView productTextView;
        TextView priceTextView;
        // Other views

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productTextView = itemView.findViewById(R.id.product);
            priceTextView = itemView.findViewById(R.id.price);
            // Initialize other views here
        }
    }
}
