package canhptph44323.fpoly.alo.duan1_nhom6_application.Databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_Name = "du_an1.txt";
    private static final int DB_version = 2;
    private Context context;

    public DBHelper(Context context) {
        super(context, DB_Name, null, DB_version);
        this.context=context;
    }



    public byte[] convertDrawableToByteArray(Drawable drawable) {
        // Convert khi đúng cấu trúc bitmap
        if (drawable instanceof BitmapDrawable) {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            return stream.toByteArray();
        }
        // Không cùng cấu trúc bitmap
        final int width = !drawable.getBounds().isEmpty() ? drawable
                .getBounds().width() : drawable.getIntrinsicWidth();

        final int height = !drawable.getBounds().isEmpty() ? drawable
                .getBounds().height() : drawable.getIntrinsicHeight();

        final Bitmap bitmap = Bitmap.createBitmap(width <= 0 ? 1 : width,
                height <= 0 ? 1 : height, Bitmap.Config.ARGB_8888);

        // Vẽ hình
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        // Chuyển kiểu
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    public static Bitmap convertByteArrayToBitmap(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

//    String imageloaiBM = "loaibanhmi";
//    int imageResourceID= context.getResources().getIdentifier(imageloaiBM,"drawable")

    static final String CREATE_TABLE_ADMIN =
            "CREATE TABLE ADMIN(" +
                    "ID_ADMIN INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "TEN_AD TEXT NOT NULL, " +
                    " EMAIL_AD TEXT NOT NULL," +
                    "MATKHAU_AD TEXT NOT NULL)";
    static final String CREATE_TABLE_KHACH_HANG =
            "CREATE TABLE KHACH_HANG(" +
                    "ID_KHACH_HANG INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "TEN_KH TEXT NOT NULL, " +
                    " EMAIL_KH TEXT NOT NULL," +
                    "MATKHAU_KH TEXT NOT NULL)";

//    static final String CREATE_TABLE_MON_AN =
//            "CREATE TABLE MON_AN(" +
//                    "ID_MON_AN INTEGER PRIMARY KEY AUTOINCREMENT," +
//                    "TEN_MON TEXT NOT NULL," +
//                    "MO_TA TEXT," +
//                    "GIA DOUBLE NOT NULL)";
    static final String CREATE_TABLE_MON_AN =
            "CREATE TABLE MON_AN(" +
                    "ID_MON_AN INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "TEN_MON TEXT NOT NULL," +
                    "MO_TA TEXT," +
                    "GIA DOUBLE NOT NULL," +
                    "ANH BLOB," +
                    "ID_LOAI_MON INTEGER," +
                    "FOREIGN KEY (ID_LOAI_MON) REFERENCES LOAI_MON_AN(ID_LOAI_MON)" +
                    ")";
    static final String CREATE_TABLE_DON_HANG =
            "CREATE TABLE DON_HANG(" +
                    "ID_DON_HANG INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "NGAY_DAT TEXT NOT NULL," +
                    "TRANG_THAI_THANH_TOAN INTEGER NOT NULL," +
                    "TONG_GIA DOUBLE NOT NULL," +
                    "ID_KHACH_HANG INTEGER NOT NULL," +
                    "FOREIGN KEY (ID_KHACH_HANG) REFERENCES KHACH_HANG(ID_KHACH_HANG)" +
                    ")";
    static final String CREATE_TABLE_CHI_TIET_DON_HANG =
            "CREATE TABLE CHI_TIET_DON_HANG(" +
                    "ID_CHI_TIET_DON_HANG INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "ID_DON_HANG INTEGER NOT NULL," +
                    "ID_MON_AN INTEGER NOT NULL," +
                    "SO_LUONG INTEGER NOT NULL," +
                    "GIA DOUBLE NOT NULL," +
                    "FOREIGN KEY (ID_DON_HANG) REFERENCES DON_HANG(ID_DON_HANG)," +
                    "FOREIGN KEY (ID_MON_AN) REFERENCES MON_AN(ID_MON_AN)" +
                    ")";
    static final String CREATE_TABLE_LOAI_MON_AN =
            "CREATE TABLE LOAI_MON_AN(" +
                    "ID_LOAI_MON INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "TEN_LOAI_MON TEXT NOT NULL," +
                    "ANH BLOB)";


    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(CREATE_TABLE_ADMIN);
    db.execSQL(CREATE_TABLE_KHACH_HANG);
    db.execSQL(CREATE_TABLE_MON_AN);
    db.execSQL(CREATE_TABLE_DON_HANG);
    db.execSQL(CREATE_TABLE_CHI_TIET_DON_HANG);
    db.execSQL(CREATE_TABLE_LOAI_MON_AN);


        db.execSQL("INSERT INTO ADMIN VALUES (1,'ADMIN','Admin@gmail.com','123456')");
        db.execSQL("INSERT INTO KHACH_HANG VALUES (1,'Khach_hang_1','hung123@gmail.com','hung_2003')" +
                ",(2,'x_Bac','bac@gmail.com','bac_2004')" +
                ",(3,'hai','hai@gmail.com','hai_2004')");

    db.execSQL("INSERT INTO MON_AN VALUES (1,'Bánh mì áp chảo','Bánh mì áp chảo thơm ngon , giòn đến miếng cuối cùng.',2000,'buasang2.png','Bánh mì')" +
            ",(2,'Bún hải sản','Nước dùng là loại nước cốt ninh các loại hải sản như tôm, cua, ghẹ,...',2500,'buasang2.png','Bún')" +
            ",(3,'Phở bò',' phở bò ngon chuẩn vị, nước dùng đậm đà',2200,'buasang1.png','Phở')");

    db.execSQL("INSERT INTO DON_HANG VALUES (1,'01/11/1998',1,4000,'Khach_hang_1')" +
            ",(2,'20/06/2003',2,5000,'x_Bac')" +
            ",(3,'20/10/2004',2,4400,'hai')");

    db.execSQL("INSERT INTO CHI_TIET_DON_HANG VALUES (1,1,'Bánh mì áp chảo',2,4000)" +
            ",(2,2,'Bún hải sản',2,5000)" +
            ",(3,3,'Phở bò',2,4400)");

    db.execSQL("INSERT INTO LOAI_MON_AN VALUES (1,'Bánh mì'," +
            "'loaibanhmi.png')" +
            ",(2,'Bún','loaibun.png')" +
            ",(3,'Phở','loaipho.png')");

    }





    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTableADMIN = "drop table if exists ADMIN";
        db.execSQL(dropTableADMIN);
        String dropTableKHACH_HANG = "drop table if exists KHACH_HANG";
        db.execSQL(dropTableKHACH_HANG);
        String dropTableMON_AN= "drop table if exists MON_AN";
        db.execSQL(dropTableMON_AN);
        String dropTableDON_HANG= "drop table if exists DON_HANG";
        db.execSQL(dropTableDON_HANG);
        String dropTableCHI_TIET_DON_HANG= "drop table if exists CHI_TIET_DON_HANG";
        db.execSQL(dropTableCHI_TIET_DON_HANG);
        String dropTableLOAI_MON_AN= "drop table if exists LOAI_MON_AN";
        db.execSQL(dropTableLOAI_MON_AN);

        onCreate(db);
    }
}
