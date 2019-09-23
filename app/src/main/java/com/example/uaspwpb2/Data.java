package com.example.uaspwpb2;

public class Data {
    String dataId;
    String dataJudul;
    String dataDeskripsi;
    String dataTanggal;
    public Data() {

    }

    public Data(String dataId, String dataJudul, String dataDeskripsi, String dataTanggal) {
        this.dataId = dataId;
        this.dataJudul = dataJudul;
        this.dataDeskripsi = dataDeskripsi;
        this.dataTanggal = dataTanggal;
    }

    public String getDataId() {
        return dataId;
    }

    public String getDataJudul() {
        return dataJudul;
    }

    public String getDataDeskripsi() {
        return dataDeskripsi;
    }

    public String getDataTanggal() {
        return dataTanggal;
    }
}
