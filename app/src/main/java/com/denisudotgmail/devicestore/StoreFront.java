package com.denisudotgmail.devicestore;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class StoreFront extends AppCompatActivity {
    private Button storeButton, backendButton;
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

        StoreFragment storeFragment = new StoreFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, storeFragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
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
