package com.example.uaspwpb2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListData extends ArrayAdapter<Data> {

    private Activity context;
    private List<Data> dataList;

    public ListData(Activity context, List<Data> dataList) {
        super(context, R.layout.activity_list_data, dataList);
        this.context = context;
        this.dataList = dataList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.activity_list_data, null, true);

        TextView txtJudul = listViewItem.findViewById(R.id.txtJudul);
        TextView txtDeskripsi = listViewItem.findViewById(R.id.txtDeskripsi);
        TextView txtTanggal = listViewItem.findViewById(R.id.txtDate);

        Data data = dataList.get(position);

        txtJudul.setText(data.getDataJudul());
        txtDeskripsi.setText(data.getDataDeskripsi());
        txtTanggal.setText(data.getDataTanggal());

        return listViewItem;
    }
}
