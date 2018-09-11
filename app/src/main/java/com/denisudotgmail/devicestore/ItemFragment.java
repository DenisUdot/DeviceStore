package com.denisudotgmail.devicestore;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ItemFragment extends Fragment {

    private int pageNumber, price, quantity;
    private String product;
    private ItemData itemData;

    public static ItemFragment newInstance(ItemData data) {
        ItemFragment fragment = new ItemFragment();
        Bundle args=new Bundle();
        args.putSerializable("d",data);
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
        itemData = (ItemData)getArguments().getSerializable("d");
        price = getArguments().getInt("price");
        quantity = getArguments().getInt("quantity");
        product = getArguments().getString("name","product name");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View result = inflater.inflate(R.layout.store_item, container, false);
        TextView productText = (TextView)result.findViewById(R.id.product_name);
        TextView priceText = (TextView)result.findViewById(R.id.price);
        TextView quantityText = (TextView)result.findViewById(R.id.quantity);
//        Button buyButton = (Button)result.findViewById(R.id.buy_button);
//        buyButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(itemData.getQuantity() > 0) {
//                    itemData.setQuantity(itemData.getQuantity() - 1);
//                }
//            }
//        });
        productText.setText(product);
        priceText.setText(Integer.toString(price));
        quantityText.setText(Integer.toString(quantity));

        return result;
    }
}

