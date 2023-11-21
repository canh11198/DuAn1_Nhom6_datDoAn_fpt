package canhptph44323.fpoly.alo.duan1_nhom6_application.Models;

public class MonAN {
    private int ID_MON_AN;
    private String TEN_MON;
    private String MO_TA;
    private Double GIA;
    private byte[] ANH;
    private int id_loaiMonAn;

    public MonAN() {
    }

    public MonAN(int ID_MON_AN, String TEN_MON, String MO_TA, Double GIA, byte[] ANH, int id_loaiMonAn) {
        this.ID_MON_AN = ID_MON_AN;
        this.TEN_MON = TEN_MON;
        this.MO_TA = MO_TA;
        this.GIA = GIA;
        this.ANH = ANH;
        this.id_loaiMonAn = id_loaiMonAn;
    }

    public int getID_MON_AN() {
        return ID_MON_AN;
    }

    public void setID_MON_AN(int ID_MON_AN) {
        this.ID_MON_AN = ID_MON_AN;
    }

    public String getTEN_MON() {
        return TEN_MON;
    }

    public void setTEN_MON(String TEN_MON) {
        this.TEN_MON = TEN_MON;
    }

    public String getMO_TA() {
        return MO_TA;
    }

    public void setMO_TA(String MO_TA) {
        this.MO_TA = MO_TA;
    }

    public Double getGIA() {
        return GIA;
    }

    public void setGIA(Double GIA) {
        this.GIA = GIA;
    }

    public byte[] getANH() {
        return ANH;
    }

    public void setANH(byte[] ANH) {
        this.ANH = ANH;
    }

    public int getId_loaiMonAn() {
        return id_loaiMonAn;
    }

    public void setId_loaiMonAn(int id_loaiMonAn) {
        this.id_loaiMonAn = id_loaiMonAn;
    }
}