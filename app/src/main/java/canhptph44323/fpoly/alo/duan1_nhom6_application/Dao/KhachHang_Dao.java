package canhptph44323.fpoly.alo.duan1_nhom6_application.Dao;
// bài code trên git nhóm
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import canhptph44323.fpoly.alo.duan1_nhom6_application.Databases.DBHelper;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Models.ADMIN;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Models.KhachHang;

public class KhachHang_Dao {
    private SQLiteDatabase db;

    public KhachHang_Dao(Context context) {
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public long insert(KhachHang obj) {
        ContentValues values = new ContentValues();
        values.put("TEN_KH", obj.getTEN_KH());
        values.put("EMAIL_KH", obj.getEMAIL_KH());
        values.put("MATKHAU_KH", obj.getMAT_KHAU_KH());
        return db.insert("KHACH_HANG", null, values);
    }
    public long updatepass(KhachHang obj) {
        ContentValues values = new ContentValues();
        values.put("TEN_KH", obj.getTEN_KH());
        values.put("MATKHAU_KH", obj.getMAT_KHAU_KH());
        return db.update("KHACH_HANG", values, "ID_KHACH_HANG=?", new String[]{String.valueOf(obj.getID_KH())});
    }

    public List<KhachHang> getAll() {
        String sql = "SELECT * FROM KHACH_HANG";
        return getData(sql);
    }

    public KhachHang getID(String id) {
        String sql = "SELECT * FROM KHACH_HANG WHERE ID_KHACH_HANG=?";
        List<KhachHang> list = getData(sql, id);
        return list.get(0);
    }

    public int checkLogin(String taikhoan, String password) {
        String sql = "SELECT * FROM KHACH_HANG WHERE TEN_KH=? AND MATKHAU_KH=?";
        List<KhachHang> list = getData(sql,taikhoan, password);
        if (list.size() == 0) {
            return -1;
        }
        return 1;
    }

    @SuppressLint("Range")
    private List<KhachHang> getData(String sql, String... selectionArgs) {
        List<KhachHang> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            KhachHang obj = new KhachHang();
            obj.setID_KH(Integer.parseInt(cursor.getString(cursor.getColumnIndex("ID_KHACH_HANG"))));
            obj.setTEN_KH(cursor.getString(cursor.getColumnIndex("TEN_KH")));
            obj.setEMAIL_KH(cursor.getString(cursor.getColumnIndex("EMAIL_KH")));
            obj.setMAT_KHAU_KH(cursor.getString(cursor.getColumnIndex("MATKHAU_KH")));
            list.add(obj);
        }
        return list;
    }
}
