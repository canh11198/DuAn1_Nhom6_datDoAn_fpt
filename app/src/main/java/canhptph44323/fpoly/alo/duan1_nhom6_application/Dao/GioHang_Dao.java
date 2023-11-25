package canhptph44323.fpoly.alo.duan1_nhom6_application.Dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import canhptph44323.fpoly.alo.duan1_nhom6_application.Databases.DBHelper;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Models.Gio_Hang;

public class GioHang_Dao {
    DBHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;

    public GioHang_Dao(Context context) {
        dbHelper = new DBHelper(context);
        sqLiteDatabase= dbHelper.getWritableDatabase();
    }

    public ArrayList<Gio_Hang> getAllData(){
        String sql = "SELECT * From tbl_cart";
        return getData(sql);
    }
    public long insert(Gio_Hang gio_hang) {
        ContentValues values = new ContentValues();
        values.put("food_id", gio_hang.getIdFood());
        values.put("cart_quantity", gio_hang.getQuanti());
        values.put("cart_sum", gio_hang.getSum());
        values.put("user_name", gio_hang.getUsername());
        return sqLiteDatabase.insert("tbl_cart", null, values);
    }
    @SuppressLint("Range")
    public ArrayList<Gio_Hang> getData(String sql, String... SelectAvg) {
        ArrayList<Gio_Hang> list = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, SelectAvg);

        while (cursor.moveToNext()) {
            Gio_Hang gio_hang = new Gio_Hang();
            gio_hang.setIdCart(cursor.getInt(cursor.getColumnIndex("cart_id")));
            gio_hang.setIdFood(cursor.getInt(cursor.getColumnIndex("food_id")));
            gio_hang.setQuanti(cursor.getInt(cursor.getColumnIndex("cart_quantity")));
            gio_hang.setSum(cursor.getDouble(cursor.getColumnIndex("cart_sum")));
            gio_hang.setUsername(cursor.getString(cursor.getColumnIndex("user_name")));
            list.add(gio_hang);
        }

        cursor.close();
        return list;
    }
    public boolean FoodExists(int foodId, String username) {
        String query = "SELECT * FROM tbl_cart WHERE food_id = ? AND user_name = ?";
        String[] selectionArgs = {String.valueOf(foodId), username};
        Cursor cursor = sqLiteDatabase.rawQuery(query, selectionArgs);
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }
}
