package edu.illinois.cs465.revisionmaster;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCompanies;
    private CompanyAdapter companyAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView
        recyclerViewCompanies = findViewById(R.id.recyclerView_companies);
        recyclerViewCompanies.setLayoutManager(new LinearLayoutManager(this));

        // Sample data
        List<String> companies = Arrays.asList(
                "Google", "Amazon", "NVIDIA", "Meta", "PayPal", "Goldman Sachs", "Jane Street", "Ebay"
        );

        // Set the adapter with data
        companyAdapter = new CompanyAdapter(companies);
        recyclerViewCompanies.setAdapter(companyAdapter);
    }
}