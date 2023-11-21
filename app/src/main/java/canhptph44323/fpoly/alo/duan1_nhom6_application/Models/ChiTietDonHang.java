package canhptph44323.fpoly.alo.duan1_nhom6_application.Models;

public class ChiTietDonHang {
    private int id_chiTietDonhang;
    private int id_donHang;
    private int id_monAn;
    private int so_luong;
    private double gia;

    public ChiTietDonHang() {
    }

    public ChiTietDonHang(int id_chiTietDonhang, int id_donHang, int id_monAn, int so_luong, double gia) {
        this.id_chiTietDonhang = id_chiTietDonhang;
        this.id_donHang = id_donHang;
        this.id_monAn = id_monAn;
        this.so_luong = so_luong;
        this.gia = gia;
    }

    public int getId_chiTietDonhang() {
        return id_chiTietDonhang;
    }

    public void setId_chiTietDonhang(int id_chiTietDonhang) {
        this.id_chiTietDonhang = id_chiTietDonhang;
    }

    public int getId_donHang() {
        return id_donHang;
    }

    public void setId_donHang(int id_donHang) {
        this.id_donHang = id_donHang;
    }

    public int getId_monAn() {
        return id_monAn;
    }

    public void setId_monAn(int id_monAn) {
        this.id_monAn = id_monAn;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
}
