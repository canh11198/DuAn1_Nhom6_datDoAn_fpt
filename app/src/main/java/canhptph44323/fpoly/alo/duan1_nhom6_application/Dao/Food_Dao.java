package canhptph44323.fpoly.alo.duan1_nhom6_application.Dao;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import canhptph44323.fpoly.alo.duan1_nhom6_application.Databases.DBHelper;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Models.Foods;

public class Food_Dao {
    DBHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    public Food_Dao(Context contex) {
        dbHelper = new DBHelper(contex);
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }

    public ArrayList<Foods> getAllData() {
        String sql = "SELECT * FROM tbl_food";
        return getData(sql);
    }
    @SuppressLint("Range")
    public ArrayList<Foods> getData(String sql, String... SelectAvg) {
        ArrayList<Foods> list = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM tbl_food", SelectAvg);
        while (cursor.moveToNext()) {
            Foods food = new Foods();
            food.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex("food_id"))));
            food.setType(cursor.getString(cursor.getColumnIndex("typeFood_typeName")));
            food.setImg(cursor.getString(cursor.getColumnIndex("food_img")));
            food.setName(cursor.getString(cursor.getColumnIndex("food_name")));
            food.setDes(cursor.getString(cursor.getColumnIndex("food_description")));
            food.setPrice(cursor.getInt(cursor.getColumnIndex("food_price")));
            list.add(food);
        }
        return list;
    }

    @SuppressLint("Range")
    public ArrayList<Foods> Search(String ten) {
        SQLiteDatabase sqLite = dbHelper.getWritableDatabase();
        ArrayList<Foods> list = new ArrayList<>();
        Cursor cursor = sqLite.rawQuery("SELECT * FROM tbl_food WHERE food_name LIKE '%" + ten + "%' ", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                Foods food = new Foods();
                food.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex("food_id"))));
                food.setImg(cursor.getString(cursor.getColumnIndex("food_img")));
                food.setName(cursor.getString(cursor.getColumnIndex("food_name")));
                food.setDes(cursor.getString(cursor.getColumnIndex("food_description")));
                food.setPrice(Integer.parseInt(cursor.getString(cursor.getColumnIndex("food_price"))));
                list.add(food);

            }
            while (cursor.moveToNext());
        }
        return list;
    }
}
