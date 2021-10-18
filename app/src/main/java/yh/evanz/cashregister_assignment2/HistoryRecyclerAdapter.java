package yh.evanz.cashregister_assignment2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryRecyclerAdapter extends RecyclerView.Adapter<HistoryRecyclerAdapter.viewHolder> {

    ArrayList<History> listOfHistory;
    Context mContext;

    public interface OnItemClinkListener{
        void onItemClick(History item);
    }

    private final OnItemClinkListener listener;

    public HistoryRecyclerAdapter(ArrayList<History> listOfHistory, Context mContext, OnItemClinkListener listenerFromActivity) {
        this.listOfHistory = listOfHistory;
        this.mContext = mContext;
        listener = listenerFromActivity;
    }

    public static class viewHolder extends RecyclerView.ViewHolder{

        private final TextView nameText;
        private final TextView totalText;
        private final TextView quantityText;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.name);
            totalText = itemView.findViewById(R.id.total);
            quantityText = itemView.findViewById(R.id.quantity);
        }

        public TextView getNameText() {
            return nameText;
        }

        public TextView getTotalText() {
            return totalText;
        }

        public TextView getQuantityText() {
            return quantityText;
        }
    }



    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater myInflater = LayoutInflater.from(mContext);
        View view = myInflater.inflate(R.layout.recycler_view_list_row, parent, false);

        return new viewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.getNameText().setText(listOfHistory.get(position).name);
        holder.getQuantityText().setText(Integer.toString(listOfHistory.get(position).quantity));
        holder.getTotalText().setText(Double.toString(listOfHistory.get(position).total));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(listOfHistory.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listOfHistory.size();
    }



}
