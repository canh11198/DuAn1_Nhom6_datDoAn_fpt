package canhptph44323.fpoly.alo.duan1_nhom6_application.Dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import canhptph44323.fpoly.alo.duan1_nhom6_application.Databases.DBHelper;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Models.ADMIN;

public class Admin_Dao {
    private SQLiteDatabase db;

    public Admin_Dao(Context context) {
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long updatepass(ADMIN obj) {
        ContentValues values = new ContentValues();
        values.put("TEN_AD", obj.getTEN_AD());
        values.put("MATKHAU_AD", obj.getMAT_KHAU_AD());
        return db.update("ADMIN", values, "ID_ADMIN=?", new String[]{String.valueOf(obj.getID_ADMIN())});
    }

    public List<ADMIN> getAll() {
        String sql = "SELECT * FROM ADMIN";
        return getData(sql);
    }

    public ADMIN getID(String id) {
        String sql = "SELECT * FROM ADMIN WHERE ID_ADMIN=?";
        List<ADMIN> list = getData(sql, id);
        return list.get(0);
    }

    public int checkLogin(String taikhoan, String password) {
        String sql = "SELECT * FROM ADMIN WHERE TEN_AD=? AND MATKHAU_AD=?";
        List<ADMIN> list = getData(sql, taikhoan, password);
        if (list.size() == 0) {
            return -1;
        }
        return 1;
    }

    @SuppressLint("Range")
    private List<ADMIN> getData(String sql, String... selectionArgs) {
        List<ADMIN> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            ADMIN obj = new ADMIN();
            obj.setID_ADMIN(Integer.parseInt(cursor.getString(cursor.getColumnIndex("ID_ADMIN"))));
            obj.setTEN_AD(cursor.getString(cursor.getColumnIndex("TEN_AD")));
            obj.setEMAIL_AD(cursor.getString(cursor.getColumnIndex("EMAIL_AD")));
            obj.setMAT_KHAU_AD(cursor.getString(cursor.getColumnIndex("MATKHAU_AD")));
            list.add(obj);
        }
        return list;
    }
}
