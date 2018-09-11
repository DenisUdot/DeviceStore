package com.denisudotgmail.devicestore;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button storeButton, backendButton, buyButton;
    StoreRecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    LinearLayout storeItemLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storeButton = findViewById(R.id.store_button);
        backendButton = findViewById(R.id.backend_button);
        buyButton = findViewById(R.id.buy_button);
        ButtonListener buttonListener = new ButtonListener();
        storeButton.setOnClickListener(buttonListener);
        backendButton.setOnClickListener(buttonListener);
        buyButton.setOnClickListener(buttonListener);

        recyclerView = findViewById(R.id.backend_item_list);
        viewPager = findViewById(R.id.store_item);
        storeItemLayout = findViewById(R.id.store_item_layout);


        storeButton.setSelected(true);
        backendButton.setSelected(false);

        List<ItemData> itemDataList = new ArrayList<>();
        itemDataList.add(new ItemData("Apple iPod touch 5 32Gb", 8888, 5));
        itemDataList.add(new ItemData("Samsung Galaxy S Duos S7562", 7230, 2));
        itemDataList.add(new ItemData("Canon EOS 600D Kit", 15569, 4));
        itemDataList.add(new ItemData("Samsung Galaxy Tab 2 10.1 P5100 16Gb", 13290, 9));
        itemDataList.add(new ItemData("PocketBook Touch", 5197, 2));

        itemDataList.add(new ItemData("Canon EOS 600D Kit", 15569, 4));
        itemDataList.add(new ItemData("Samsung Galaxy Tab 2 10.1 P5100 16Gb", 13290, 9));
        itemDataList.add(new ItemData("PocketBook Touch", 5197, 2));
        itemDataList.add(new ItemData("Canon EOS 600D Kit", 15569, 4));
        itemDataList.add(new ItemData("Samsung Galaxy Tab 2 10.1 P5100 16Gb", 13290, 9));
        itemDataList.add(new ItemData("PocketBook Touch", 5197, 2));

        viewPager.setAdapter(new ItemFragmentAdapter(getSupportFragmentManager(), itemDataList));

        RecyclerView recyclerView = findViewById(R.id.backend_item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setNestedScrollingEnabled(false);
        adapter = new StoreRecyclerViewAdapter(this, itemDataList);


//        GridLayoutManager layoutManager = new GridLayoutManager(this,1);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
//        ItemFragment itemFragment = new ItemFragment();}
    }

    class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.store_button:
                    if (!storeButton.isSelected()) {
                        storeButton.setSelected(true);
                        backendButton.setSelected(false);
                        recyclerView.setVisibility(View.GONE);
                        storeItemLayout.setVisibility(View.VISIBLE);
                    }
                    break;
                case R.id.backend_button:
                    if (!backendButton.isSelected()) {
                        storeButton.setSelected(false);
                        backendButton.setSelected(true);
                        recyclerView.setVisibility(View.VISIBLE);
                        storeItemLayout.setVisibility(View.GONE);
                    }
                    break;
                case R.id.buy_button:
                    int i = viewPager.getCurrentItem();
                    ItemFragmentAdapter adapter = (ItemFragmentAdapter)viewPager.getAdapter();

                    Fragment fragment = adapter.getItem(i);
                    Bundle bundle = fragment.getArguments();
                    if (bundle != null) {
                        ItemData id = (ItemData)bundle.getSerializable("d");
                        if(id.getQuantity() > 0) {
                            id.setQuantity(id.getQuantity() - 1);
                        }
                    }
                    adapter.notifyDataSetChanged();
                    break;

            }
        }
    }
}
