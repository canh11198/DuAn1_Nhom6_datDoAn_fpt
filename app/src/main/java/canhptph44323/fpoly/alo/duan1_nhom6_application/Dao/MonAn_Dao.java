package canhptph44323.fpoly.alo.duan1_nhom6_application.Dao;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import canhptph44323.fpoly.alo.duan1_nhom6_application.Databases.DBHelper;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Models.MonAN;
// bài code trên git nhóm
public class MonAn_Dao {

//    private SQLiteDatabase db;
//    public MonAn_Dao (Context context){
//        DBHelper dbHelper = new DBHelper(context);
//        db = dbHelper.getWritableDatabase();
//    }
//    @SuppressLint("Range")
//    private List<MonAN> getDataMonAn(String sql, String... selectionArgs) {
//        List<MonAN> list = new ArrayList<>();
//        Cursor cursor = db.rawQuery(sql, selectionArgs);
//        while (cursor.moveToNext()) {
//            MonAN obj = new MonAN();
//            obj.setID_MON_AN(Integer.parseInt(cursor.getString(cursor.getColumnIndex("ID_MON_AN"))));
//            obj.setTEN_MON(cursor.getString(cursor.getColumnIndex("TEN_MON")));
//            obj.setMO_TA(cursor.getString(cursor.getColumnIndex("MO_TA")));
//            obj.setGIA(Double.parseDouble(cursor.getString(cursor.getColumnIndex("GIA"))));
//            //obj.setANH(cursor.getBlob(cursor.getColumnIndex("ANH")));
//            // Lấy dữ liệu hình ảnh từ cột "ANH" kiểu BLOB
//            byte[] imageBytes = cursor.getBlob(cursor.getColumnIndex("ANH"));
//            obj.setANH(imageBytes);
//            //obj.setId_loaiMonAn(Integer.parseInt(cursor.getString(cursor.getColumnIndex("ID_LOAI_MON"))));
//            String id_loaiMonAnString = cursor.getString(cursor.getColumnIndex("ID_LOAI_MON"));
//            int id_loaiMonAn = 0; // Giá trị mặc định hoặc giá trị bạn chọn để xử lý lỗi
//
//            if (id_loaiMonAnString != null && !id_loaiMonAnString.isEmpty()) {
//                try {
//                    id_loaiMonAn = Integer.parseInt(id_loaiMonAnString);
//                    // Nếu không có lỗi, giá trị id_loaiMonAn sẽ được gán là số nguyên từ chuỗi id_loaiMonAnString
//                } catch (NumberFormatException e) {
//                    e.printStackTrace(); // Xử lý khi có lỗi chuyển đổi
//                }
//            }
//
//          // Bây giờ bạn có thể sử dụng id_loaiMonAn mà không gây ra NumberFormatException
//            obj.setId_loaiMonAn(id_loaiMonAn);
//            // Bạn cần thay đổi tên cột nếu tên cột trong CSDL không chính xác
//            list.add(obj);
//        }
//        cursor.close(); // Đóng con trỏ sau khi sử dụng xong
//        return list;
//    }
//    public List<MonAN> getAll() {
//        String sql = "SELECT * FROM MON_AN";
//        return getDataMonAn(sql);
//    }
//
//    public MonAN getID(String id) {
//        String sql = "SELECT * FROM MON_AN WHERE ID_MON_AN=?";
//        List<MonAN> list = getDataMonAn(sql, id);
//        return list.get(0);
//    }
    DBHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    public MonAn_Dao(Context context) {
        dbHelper= new DBHelper(context);
        sqLiteDatabase=dbHelper.getWritableDatabase();
    }
    public ArrayList<MonAN> getAllData(){
        String sql = "SELECT * FROM tbl_food";
        return getData(sql);
    }
    @SuppressLint("Range")
    public ArrayList<MonAN> TypeName(String type) {
        SQLiteDatabase sqlite=dbHelper.getWritableDatabase();
        ArrayList<MonAN>list= new ArrayList<>();
        Cursor cursor=sqlite.rawQuery("SELECT * FROM tbl_food WHERE typeFood_typeName LIKE '%"+ type +"%' ", null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                MonAN monAN= new MonAN();
                monAN.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex("food_id"))));
                monAN.setImg(cursor.getString(cursor.getColumnIndex("food_img")));
                monAN.setName(cursor.getString(cursor.getColumnIndex("food_name")));
                monAN.setDes(cursor.getString(cursor.getColumnIndex("food_description")));
                monAN.setPrice(Integer.parseInt(cursor.getString(cursor.getColumnIndex("food_price"))));
                list.add(monAN);
            }
            while (cursor.moveToNext());
        }
        return list;
    }
    @SuppressLint("Range")
    public ArrayList<MonAN> getData(String sql, String... SelectAvg){
        ArrayList<MonAN> list = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM tbl_food", SelectAvg);
        while (cursor.moveToNext()){
            MonAN monAN = new MonAN();
            monAN.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex("food_id"))));
            monAN.setType(cursor.getString(cursor.getColumnIndex("typeFood_typeName")));
            monAN.setImg(cursor.getString(cursor.getColumnIndex("food_img")));
            monAN.setName(cursor.getString(cursor.getColumnIndex("food_name")));
            monAN.setDes(cursor.getString(cursor.getColumnIndex("food_description")));
            monAN.setPrice(cursor.getInt(cursor.getColumnIndex("food_price")));
            list.add(monAN);
        }
        return list;
    }
    @SuppressLint("Range")
    public ArrayList<MonAN> search(String ten){
        SQLiteDatabase sqLiteDatabase1=dbHelper.getWritableDatabase();
        ArrayList<MonAN> list= new ArrayList<>();
        Cursor cursor= sqLiteDatabase1.rawQuery("SELECT * FROM tbl_food WHERE food_name LIKE '%"+ ten +"%' ", null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                MonAN monAN = new MonAN();
                monAN.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex("food_id"))));
                monAN.setType(cursor.getString(cursor.getColumnIndex("typeFood_typeName")));
                monAN.setImg(cursor.getString(cursor.getColumnIndex("food_img")));
                monAN.setName(cursor.getString(cursor.getColumnIndex("food_name")));
                monAN.setDes(cursor.getString(cursor.getColumnIndex("food_description")));
                monAN.setPrice(cursor.getInt(cursor.getColumnIndex("food_price")));
                list.add(monAN);

            }
            while (cursor.moveToNext());
        }
        return list;
    }
}
