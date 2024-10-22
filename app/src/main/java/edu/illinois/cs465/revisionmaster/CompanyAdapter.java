package edu.illinois.cs465.revisionmaster;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.CompanyViewHolder> {

    private List<String> companies;
    private Map<Integer, Boolean> expandedStates; // To track which items are expanded

    // Constructor to pass the list of companies
    public CompanyAdapter(List<String> companies) {
        this.companies = companies;
        expandedStates = new HashMap<>();
    }

    // ViewHolder class to hold reference to the views
    public static class CompanyViewHolder extends RecyclerView.ViewHolder {
        public TextView companyName;
        public LinearLayout subtitlesContainer;

        public CompanyViewHolder(View view) {
            super(view);
            companyName = view.findViewById(R.id.company_name);
            subtitlesContainer = view.findViewById(R.id.subtitles_container);
        }
    }

    @NonNull
    @Override
    public CompanyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_company, parent, false);
        return new CompanyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CompanyViewHolder holder, final int position) {
        // Set the company name
        holder.companyName.setText(companies.get(position));

        // Handle the expand/collapse functionality
        boolean isExpanded = expandedStates.getOrDefault(position, false);
        holder.subtitlesContainer.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

        // Set a click listener on the company name to toggle the subtitle list
        holder.companyName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean expanded = expandedStates.getOrDefault(position, false);
                expandedStates.put(position, !expanded);
                notifyItemChanged(position); // Refresh the item to toggle visibility
            }
        });
    }

    @Override
    public int getItemCount() {
        return companies.size();
    }
}
