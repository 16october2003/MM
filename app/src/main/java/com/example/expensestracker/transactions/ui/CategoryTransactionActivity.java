package com.example.expensestracker.transactions.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.expensestracker.R;
import com.example.expensestracker.transactions.Transaction;
import com.example.expensestracker.transactions.TransactionManager;

import java.util.ArrayList;

public class CategoryTransactionActivity extends AppCompatActivity
{
    TextView selectedCategoryName;
    ListView transactionListView;

    String categoryName;
    ArrayList<Transaction> transactions;
    TransactionListAdapter transactionListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_transaction);

        selectedCategoryName = findViewById(R.id.selected_category_name);
        transactionListView = findViewById(R.id.transaction_lv);

        Bundle bundle = getIntent().getExtras();
        categoryName = bundle.getString("category" , "none");
        selectedCategoryName.setText(categoryName);

        transactions = TransactionManager.getTransactionsByCategory(categoryName);
        transactionListAdapter = new TransactionListAdapter(getApplicationContext() , transactions);
        transactionListView.setAdapter(transactionListAdapter);
        transactionListAdapter.notifyDataSetChanged();

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(transactionListAdapter!=null)
            transactionListAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(transactionListAdapter!=null)
            transactionListAdapter.notifyDataSetChanged();
    }
}