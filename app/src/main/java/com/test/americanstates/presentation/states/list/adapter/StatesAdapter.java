package com.test.americanstates.presentation.states.list.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.americanstates.R;
import com.test.americanstates.data.states.list.model.State;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by
 * Mykhailo on 8/21/2018.
 */
public class StatesAdapter extends RecyclerView.Adapter<StatesAdapter.StatesViewHolder> {

    private List<State> states = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Inject
    public StatesAdapter() {
    }

    public void setStates(List<State> _states) {
        if (_states == null)
            return;

        this.states = _states;
    }

    @NonNull
    @Override
    public StatesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StatesViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_state, parent, false));
    }

    @SuppressLint("StringFormatMatches")
    @Override
    public void onBindViewHolder(@NonNull StatesViewHolder holder, int position) {
        State state = states.get(position);
        holder.state = state;

        holder.tvStateName.setText(state.getName());
        holder.tvStateAbbr.setText(holder.tvStateAbbr.getContext().getString(
                R.string.item_state_abbr, state.getCountry(), state.getAbbr()));
        holder.tvCapital.setText(state.getCapital());
        holder.tvLargestCity.setText(state.getLargestCity());
        holder.tvStateId.setText(String.valueOf(state.getId()));
    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    public class StatesViewHolder extends RecyclerView.ViewHolder {

        private State state;

        @OnClick(R.id.cvItem_IS)
        protected void onItemClick() {
            onItemClickListener.onStateClick(state);
        }

        @BindView(R.id.tvStateName_IS)
        TextView tvStateName;
        @BindView(R.id.tvStateAbbr_IS)
        TextView tvStateAbbr;
        @BindView(R.id.tvCapital_IS)
        TextView tvCapital;
        @BindView(R.id.tvLargestCity_IS)
        TextView tvLargestCity;
        @BindView(R.id.tvStateId_IS)
        TextView tvStateId;

        StatesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onStateClick(State state);
    }
}
