package canhptph44323.fpoly.alo.duan1_nhom6_application.Dao;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import canhptph44323.fpoly.alo.duan1_nhom6_application.Databases.DBHelper;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Models.LoaiMon;

public class LoaiMon_Dao {
    DBHelper dbHelper;
    private static SQLiteDatabase sqLite;
    public LoaiMon_Dao(Context context){
        dbHelper = new DBHelper(context);
        sqLite = dbHelper.getWritableDatabase();
    }
    @SuppressLint("Range")
    public static ArrayList<LoaiMon> getDataLoaiSach(String sql, String... SelectAvg){
        ArrayList<LoaiMon> list = new ArrayList<>();
        Cursor cursor = sqLite.rawQuery("SELECT * FROM tbl_typeFood", SelectAvg);
        while (cursor.moveToNext()){
            LoaiMon type = new LoaiMon();
            type.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex("typeFood_id"))));
            type.setTypeName(cursor.getString(cursor.getColumnIndex("typeFood_typeName")));
            list.add(type);
        }
        return list;
    }

    public static ArrayList<LoaiMon> getAllData() {
        String sql = "SELECT * FROM tbl_typeFood";
        return getDataLoaiSach(sql);
    }
    public static ArrayList<String> name() {
        String name = "SELECT typeFood_typeName FROM tbl_typeFood";
        return getName(name);
    }


    public static ArrayList<String> getName(String sql, String... SelectAvgs) {
        ArrayList<String> lst = new ArrayList<>();
        Cursor cursor = sqLite.rawQuery(sql, SelectAvgs);
        while (cursor.moveToNext()) {
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("typeFood_typeName"));
            lst.add(name);
        }
        return lst;

    }
}
