package com.denisudotgmail.devicestore;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ItemFragment extends Fragment {

    private int pageNumber, price, quantity;
    private String product;

    public static ItemFragment newInstance(int position, ItemData data) {
        ItemFragment fragment = new ItemFragment();
        Bundle args=new Bundle();
        args.putInt("num", position);
        args.putInt("price", data.getPrice());
        args.putInt("quantity", data.getQuantity());
        args.putString("name", data.getProductName());
        fragment.setArguments(args);
        return fragment;
    }

    public ItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments() != null ? getArguments().getInt("num") : 1;
        price = getArguments().getInt("price");
        quantity = getArguments().getInt("quantity");
        product = getArguments().getString("name","product name");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.store_item, container, false);
        TextView productText = (TextView)result.findViewById(R.id.product_name);
        TextView priceText = (TextView)result.findViewById(R.id.price);
        TextView quantityText = (TextView)result.findViewById(R.id.quantity);

        productText.setText(product);
        priceText.setText(Integer.toString(price));
        quantityText.setText(Integer.toString(quantity));

        return result;
    }
}

