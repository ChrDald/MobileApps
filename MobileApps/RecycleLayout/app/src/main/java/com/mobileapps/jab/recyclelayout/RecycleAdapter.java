package com.mobileapps.jab.recyclelayout;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ItemViewHolder> {

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View inflatedView = inflater.inflate(R.layout.per_item_view, parent, false);
        return new ItemViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        holder.txvItem.setText( Integer.toString(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("RecycleView", "clicked item: " + Integer.toString(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView txvItem;
        FrameLayout parentLayout;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            txvItem = itemView.findViewById(R.id.txvOneItem);
        }
    }
}
