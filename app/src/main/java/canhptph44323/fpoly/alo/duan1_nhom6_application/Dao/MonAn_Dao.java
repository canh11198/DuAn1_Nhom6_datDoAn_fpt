package canhptph44323.fpoly.alo.duan1_nhom6_application.Dao;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import canhptph44323.fpoly.alo.duan1_nhom6_application.Databases.DBHelper;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Models.MonAN;

public class MonAn_Dao {

    private SQLiteDatabase db;
    public MonAn_Dao (Context context){
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    @SuppressLint("Range")
    private List<MonAN> getDataMonAn(String sql, String... selectionArgs) {
        List<MonAN> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            MonAN obj = new MonAN();
            obj.setID_MON_AN(Integer.parseInt(cursor.getString(cursor.getColumnIndex("ID_MON_AN"))));
            obj.setTEN_MON(cursor.getString(cursor.getColumnIndex("TEN_MON")));
            obj.setMO_TA(cursor.getString(cursor.getColumnIndex("MO_TA")));
            obj.setGIA(Double.parseDouble(cursor.getString(cursor.getColumnIndex("GIA"))));
            //obj.setANH(cursor.getBlob(cursor.getColumnIndex("ANH")));
            // Lấy dữ liệu hình ảnh từ cột "ANH" kiểu BLOB
            byte[] imageBytes = cursor.getBlob(cursor.getColumnIndex("ANH"));
            obj.setANH(imageBytes);
            //obj.setId_loaiMonAn(Integer.parseInt(cursor.getString(cursor.getColumnIndex("ID_LOAI_MON"))));
            String id_loaiMonAnString = cursor.getString(cursor.getColumnIndex("ID_LOAI_MON"));
            int id_loaiMonAn = 0; // Giá trị mặc định hoặc giá trị bạn chọn để xử lý lỗi

            if (id_loaiMonAnString != null && !id_loaiMonAnString.isEmpty()) {
                try {
                    id_loaiMonAn = Integer.parseInt(id_loaiMonAnString);
                    // Nếu không có lỗi, giá trị id_loaiMonAn sẽ được gán là số nguyên từ chuỗi id_loaiMonAnString
                } catch (NumberFormatException e) {
                    e.printStackTrace(); // Xử lý khi có lỗi chuyển đổi
                }
            }

          // Bây giờ bạn có thể sử dụng id_loaiMonAn mà không gây ra NumberFormatException
            obj.setId_loaiMonAn(id_loaiMonAn);
            // Bạn cần thay đổi tên cột nếu tên cột trong CSDL không chính xác
            list.add(obj);
        }
        cursor.close(); // Đóng con trỏ sau khi sử dụng xong
        return list;
    }
    public List<MonAN> getAll() {
        String sql = "SELECT * FROM MON_AN";
        return getDataMonAn(sql);
    }

    public MonAN getID(String id) {
        String sql = "SELECT * FROM MON_AN WHERE ID_MON_AN=?";
        List<MonAN> list = getDataMonAn(sql, id);
        return list.get(0);
    }
}
