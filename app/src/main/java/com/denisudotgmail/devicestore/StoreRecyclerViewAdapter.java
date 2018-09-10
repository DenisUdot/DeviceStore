package com.denisudotgmail.devicestore;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;
public class StoreRecyclerViewAdapter extends RecyclerView.Adapter<StoreRecyclerViewAdapter.ItemViewHolder> {

    private List<ItemData> itemDataList;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public StoreRecyclerViewAdapter(Context context, List<ItemData> itemDataList) {
        this.mInflater = LayoutInflater.from(context);
        this.itemDataList = itemDataList;
    }

    // inflates the row layout from xml when needed
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.backend_item, parent, false);
        return new ItemViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        String productName = itemDataList.get(position).getProductName();
        holder.myTextView.setText(productName);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return itemDataList.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;

        ItemViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.backend_item_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    ItemData getItem(int id) {
        return itemDataList.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}


