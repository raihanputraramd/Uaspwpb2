package com.example.uaspwpb2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageButton btnAdd;

    DatabaseReference databaseData;
    List<Data> dataList;
    ListView listViewData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseData = FirebaseDatabase.getInstance().getReference("data");

        btnAdd = (ImageButton) findViewById(R.id.btnAdd);
        listViewData = (ListView) findViewById(R.id.listView);
        dataList = new ArrayList<>();


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add = new Intent(getApplicationContext(), add_data.class);
                startActivity(add);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dataList.clear();

                for (DataSnapshot dataSnaps : dataSnapshot.getChildren()) {
                    Data data = dataSnaps.getValue(Data.class);

                    dataList.add(data);
                }
                ListData adapter = new ListData(MainActivity.this, dataList);
                listViewData.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
