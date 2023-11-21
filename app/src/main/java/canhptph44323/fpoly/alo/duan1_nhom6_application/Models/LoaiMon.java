package canhptph44323.fpoly.alo.duan1_nhom6_application.Models;

public class LoaiMon {
     private int id_loaiMonAn;
     private String tenMonAn;
    private String ANH_LOAI;

    public LoaiMon() {
    }

    public LoaiMon(int id_loaiMonAn, String tenMonAn, String ANH_LOAI) {
        this.id_loaiMonAn = id_loaiMonAn;
        this.tenMonAn = tenMonAn;
        this.ANH_LOAI = ANH_LOAI;
    }

    public int getId_loaiMonAn() {
        return id_loaiMonAn;
    }

    public void setId_loaiMonAn(int id_loaiMonAn) {
        this.id_loaiMonAn = id_loaiMonAn;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public String getANH_LOAI() {
        return ANH_LOAI;
    }

    public void setANH_LOAI(String ANH_LOAI) {
        this.ANH_LOAI = ANH_LOAI;
    }
}

