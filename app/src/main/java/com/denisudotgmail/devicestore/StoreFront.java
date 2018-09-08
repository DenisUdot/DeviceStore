package com.denisudotgmail.devicestore;

import android.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class StoreFront extends AppCompatActivity {
    private Button storeButton, backendButton;
    StoreRecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storeButton = findViewById(R.id.store_button);
        backendButton = findViewById(R.id.backend_button);
        ButtonListener buttonListener = new ButtonListener();
        storeButton.setOnClickListener(buttonListener);
        backendButton.setOnClickListener(buttonListener);
        storeButton.setSelected(true);
        backendButton.setSelected(false);

        List<ItemData> itemDataList = new ArrayList<>();
        itemDataList.add(new ItemData("Apple iPod touch 5 32Gb",8888,5));
        itemDataList.add(new ItemData("Samsung Galaxy S Duos S7562",7230,2));
        itemDataList.add(new ItemData("Canon EOS 600D Kit",15569,4));
        itemDataList.add(new ItemData("Samsung Galaxy Tab 2 10.1 P5100 16Gb",13290,9));
        itemDataList.add(new ItemData("PocketBook Touch",5197,2));

        ViewPager pager=(ViewPager)findViewById(R.id.pager);
        pager.setAdapter(new PagerAdapter(getSupportFragmentManager(), itemDataList));
//        RecyclerView recyclerView = findViewById(R.id.idRecyclerViewHorizontalList);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new StoreRecyclerViewAdapter(this, animalNames);
//
//        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(StoreFront.this, LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(horizontalLayoutManager);

//        GridLayoutManager layoutManager = new GridLayoutManager(this,1);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        adapter.setClickListener(this);
//        recyclerView.setAdapter(adapter);
//        ItemFragment itemFragment = new ItemFragment();
//        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        ft.replace(R.id.fragment_container, itemFragment);
//        ft.addToBackStack(null);
//        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//        ft.commit();
    }

    class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.store_button:
                    if(!storeButton.isSelected()){
                        storeButton.setSelected(true);
                        backendButton.setSelected(false);
                    }
                    break;
                case R.id.backend_button:
                    if(!backendButton.isSelected()){
                        storeButton.setSelected(false);
                        backendButton.setSelected(true);
                    }
                    break;
            }
            Toast.makeText(getBaseContext(),"Button presed",Toast.LENGTH_SHORT).show();
        }
    }
}
