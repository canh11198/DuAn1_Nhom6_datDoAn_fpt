package canhptph44323.fpoly.alo.duan1_nhom6_application.Models;

public class LoaiMon {
    private int id;
    private String typeName;

    public LoaiMon() {
    }

    public LoaiMon(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}

