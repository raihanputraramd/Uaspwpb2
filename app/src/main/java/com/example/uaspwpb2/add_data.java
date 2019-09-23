package com.example.uaspwpb2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class add_data extends AppCompatActivity {
    TextView txtDate;
    EditText edtJudul, edtDeskripsi;
    Button btnAdd;

    DatabaseReference databaseData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        databaseData = FirebaseDatabase.getInstance().getReference("data");

        txtDate = (TextView) findViewById(R.id.txtDate);
        edtJudul = (EditText) findViewById(R.id.edtJudul);
        edtDeskripsi = (EditText) findViewById(R.id.edtDeskripsi);


        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addData();
            }
        });
    }

    private void addData() {
        String judul = edtJudul.getText().toString().trim();
        String deskripsi = edtDeskripsi.getText().toString().trim();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
        String tanggal = sdf.format(new Date());
        String id = databaseData.push().getKey();
        Data data = new Data(id, judul, deskripsi, tanggal);

        databaseData.child(id).setValue(data);
    }
}
