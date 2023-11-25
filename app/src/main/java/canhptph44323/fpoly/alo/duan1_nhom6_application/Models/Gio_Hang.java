package canhptph44323.fpoly.alo.duan1_nhom6_application.Models;

public class Gio_Hang {
    private int idCart;
    private int idFood;
    private int quanti;
    private double sum;
    private  String username;

    public Gio_Hang() {
    }

    public Gio_Hang(int idCart, int idFood, int quanti, double sum, String username) {
        this.idCart = idCart;
        this.idFood = idFood;
        this.quanti = quanti;
        this.sum = sum;
        this.username = username;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public int getIdFood() {
        return idFood;
    }

    public void setIdFood(int idFood) {
        this.idFood = idFood;
    }

    public int getQuanti() {
        return quanti;
    }

    public void setQuanti(int quanti) {
        this.quanti = quanti;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
