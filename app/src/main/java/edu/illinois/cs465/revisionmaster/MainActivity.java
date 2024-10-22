package edu.illinois.cs465.revisionmaster;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

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

        //hide status bar for full screen experience
        //View decoView = getWindow().getDecorView();
        //decoView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        // Initialize RecyclerView
        recyclerViewCompanies = findViewById(R.id.recyclerView_companies);
        recyclerViewCompanies.setLayoutManager(new LinearLayoutManager(this));

        // Sample data
        List<String> companies = Arrays.asList(
                "Google", "Amazon", "NVIDIA", "Meta", "PayPal", "Goldman Sachs", "Jane Street", "Ebay",
                "Salesforce", "Riot", "Expedia", "Dropbox", "Doordash", "Bloomberg", "Tiktok"
        );

        // Set the adapter with data
        companyAdapter = new CompanyAdapter(companies);
        recyclerViewCompanies.setAdapter(companyAdapter);
    }
}