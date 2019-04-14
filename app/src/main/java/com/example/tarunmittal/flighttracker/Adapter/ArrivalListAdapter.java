package com.example.tarunmittal.flighttracker.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tarunmittal.flighttracker.MainActivity;
import com.example.tarunmittal.flighttracker.Model.Arrival;
import com.example.tarunmittal.flighttracker.R;

import java.util.List;
public class ArrivalListAdapter extends RecyclerView.Adapter<ArrivalListAdapter.ArrivalViewHolder> {

    private List<Arrival>getArrival;
    private Context mContext;

    public ArrivalListAdapter(Context context,List<Arrival> dataList){
        this.mContext = context;
        this.getArrival = dataList;
    }
    @NonNull
    @Override
    public ArrivalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.custom_arrival, viewGroup, false);
        return new ArrivalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArrivalViewHolder arrivalViewHolder, int i) {
        arrivalViewHolder.iataCode.setText(getArrival.get(i).getIataCode());
        arrivalViewHolder.iacode.setText(getArrival.get(i).getIcaoCode());

    }

    @Override
    public int getItemCount() {

        return getArrival.size();
    }

    class ArrivalViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView iataCode;
        TextView iacode;
        ArrivalViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            iataCode = mView.findViewById(R.id.text1);
            iacode = mView.findViewById(R.id.text2);
        }
    }
}
