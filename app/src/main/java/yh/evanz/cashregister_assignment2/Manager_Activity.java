package yh.evanz.cashregister_assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class Manager_Activity extends AppCompatActivity {

    ArrayList<History> historyArrayList = new ArrayList<>();
    RecyclerView recyclerList;
    HistoryRecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_manager);
        recyclerList = findViewById(R.id.historyListView);


        if (getIntent().hasExtra("historyList")) {
            historyArrayList = this.getIntent().getExtras().getParcelableArrayList("historyList");
        }

        recyclerList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HistoryRecyclerAdapter(historyArrayList, this, new HistoryRecyclerAdapter.OnItemClinkListener() {
            @Override
            public void onItemClick(History item) {
                Intent detail = new Intent(getApplicationContext(), Details_Activity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("detail", item);
                detail.putExtras(bundle);
                startActivity(detail);
            }
        });
        recyclerList.setAdapter(adapter);


    }
}