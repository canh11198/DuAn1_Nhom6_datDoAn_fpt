package canhptph44323.fpoly.alo.duan1_nhom6_application.Databases;
// bài code trên git nhóm
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



//    public byte[] convertDrawableToByteArray(Drawable drawable) {
//        // Convert khi đúng cấu trúc bitmap
//        if (drawable instanceof BitmapDrawable) {
//            ByteArrayOutputStream stream = new ByteArrayOutputStream();
//            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
//            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
//            return stream.toByteArray();
//        }
//        // Không cùng cấu trúc bitmap
//        final int width = !drawable.getBounds().isEmpty() ? drawable
//                .getBounds().width() : drawable.getIntrinsicWidth();
//
//        final int height = !drawable.getBounds().isEmpty() ? drawable
//                .getBounds().height() : drawable.getIntrinsicHeight();
//
//        final Bitmap bitmap = Bitmap.createBitmap(width <= 0 ? 1 : width,
//                height <= 0 ? 1 : height, Bitmap.Config.ARGB_8888);
//
//        // Vẽ hình
//        Canvas canvas = new Canvas(bitmap);
//        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
//        drawable.draw(canvas);
//
//        // Chuyển kiểu
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
//        return stream.toByteArray();
//    }
//
//    public static Bitmap convertByteArrayToBitmap(byte[] image) {
//        return BitmapFactory.decodeByteArray(image, 0, image.length);
//    }

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


public static final String TABLE_REQUEST_CREATE = "CREATE TABLE IF NOT EXISTS " +
        "tbl_request (" +
        "request_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
        "request_name TEXT ," +
        "request_email TEXT ," +
        "request_phone TEXT ," +
        "request_content TEXT " +
        ")";
    public static final String TABLE_TYPE_CREATE = "CREATE TABLE IF NOT EXISTS " +
            "tbl_typeFood (" +
            "typeFood_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "typeFood_typeName TEXT NOT NULL" +
            ")";


    public static final String TABLE_FOOD_CREATE = "CREATE TABLE IF NOT EXISTS " +
            "tbl_food (" +
            "food_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "typeFood_typeName TEXT REFERENCES tbl_typeFood(typeFood_typeName)," +
            "food_img TEXT NOT NULL, " +
            "food_name TEXT NOT NULL, " +
            "food_description TEXT NOT NULL, " +
            "food_price DOUBLE NOT NULL" +
            ")";

    public static final String TABLE_CART_CREATE = "CREATE TABLE IF NOT EXISTS " +
            "tbl_cart (" +
            "cart_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "food_id INTEGER REFERENCES tbl_food(food_id), " +
            "user_name TEXT REFERENCES tbl_user(user_name)," +
            "cart_quantity INTEGER NOT NULL, " +
            "cart_sum DOUBLE NOT NULL" +
            ")";

    public static final String TABLE_INVOICE_CREATE = "CREATE TABLE IF NOT EXISTS " +
            "tbl_invoice (" +
            "invoice_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "user_name TEXT REFERENCES tbl_user(user_name)," +
            "cart_id INTEGER REFERENCES tbl_cart(cart_id), " +
            "cart_phone TEXT NOT NULL, " +
            "cart_address TEXT NOT NULL, " +
            "invoice_content TEXT NOT NULL, " +
            "invoice_sum DOUBLE NOT NULL, " +
            "invoice_status TEXT ," +
            "invoice_time TEXT NOT NULL" +
            ")";
    public static final String TABLE_COMMENT_CREATE = "CREATE TABLE IF NOT EXISTS " +
            "tbl_comment (" +
            "comment_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "comment_content TEXT ," +
            "user_name TEXT REFERENCES tbl_user(user_name)," +
            "food_id INTEGER REFERENCES tbl_food(food_id)," +
            "rating INTEGER )";
    public static final String TABLE_NOTI_CREATE = "CREATE TABLE IF NOT EXISTS " +
            "tbl_noti (" +
            "noti_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "noti_time TEXT NOT NULL, " +
            "invoice_content TEXT REFERENCES tbl_invoice(invoice_content), " +
            "invoice_status TEXT  REFERENCES tbl_invoice(invoice_status)," +
            "user_name TEXT REFERENCES tbl_invoice(user_name)" +
            ")";
    public static final String insert_cmt = "Insert into tbl_comment(comment_content,user_name,food_id,rating) values" +
            "('ngon , tuyệt vời','canh','1','4'), ('nhất quán mình','hung','2','5'),('hết nước chấm','bac','1','5'),('xời, tuyệt vời','bao','2','3'),('mlem','vanh','2','5'),('okkkk','minhQuan','2','4')";



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ADMIN);
        db.execSQL(CREATE_TABLE_KHACH_HANG);
        db.execSQL(TABLE_FOOD_CREATE);

        db.execSQL(TABLE_CART_CREATE);

        db.execSQL(TABLE_REQUEST_CREATE);

        db.execSQL(TABLE_INVOICE_CREATE);
        db.execSQL(TABLE_TYPE_CREATE);

        db.execSQL(TABLE_COMMENT_CREATE);
        db.execSQL(TABLE_NOTI_CREATE);
//    db.execSQL(CREATE_TABLE_MON_AN);
//    db.execSQL(CREATE_TABLE_DON_HANG);
//    db.execSQL(CREATE_TABLE_CHI_TIET_DON_HANG);
//    db.execSQL(CREATE_TABLE_LOAI_MON_AN);


        db.execSQL("INSERT INTO ADMIN VALUES (1,'ADMIN','Admin@gmail.com','123456')");
        db.execSQL("INSERT INTO KHACH_HANG VALUES (1,'Khach_hang_1','hung123@gmail.com','hung_2003')" +
                ",(2,'x_Bac','bac@gmail.com','bac_2004')" +
                ",(3,'hai','hai@gmail.com','hai_2004')");
        db.execSQL("INSERT INTO tbl_request(request_name,request_email,request_phone,request_content ) VALUES ('hung','hungsike@gmail.com','0377671671','bún rất là ngon nhưng quán cho hơi ít rau'),('bac','bac2k4@gmail.com','0377666666','bún ngon qua anh oi')");
        db.execSQL("INSERT INTO tbl_typeFood(typeFood_typeName) VALUES ('Phở'),('Bún'),('Bánh mì')");
        db.execSQL("INSERT INTO tbl_food(typeFood_typeName,food_img,food_name,food_description,food_price) VALUES ('Phở','https://cdn.tgdd.vn/2021/06/content/phocuon-800x450.jpg'" +
                ", 'Phở cuốn'," +
                " 'Miếng bánh phở tươi, trắng nõn nà cuộn bên trong những cọng rau xanh mướt, miếng thịt chiên thơm, vàng, giò lụa trắng trắng, cà rốt đỏ đỏ, đúng là khiến ...'" +
                ",35000), " +
                "('Bún','https://static.vinwonders.com/production/bun-dau-mam-tom-ha-noi-1.jpg', " +
                "'Bún đậu', " +
                "'Một mẹt bún đậu mắm tôm với đầy đủ các nguyên liệu hấp dẫn, sạch sẽ chắc hẳn là món ngon mà bất cứ ai cũng khó có thể chối từ.'," +
                " 30000), " +
                "('Phở','https://cdn.tgdd.vn/2021/06/content/phoga-800x450.jpg', " +
                "'Phở gà', " +
                "'Nước dùng phở gà có màu vàng nhạt nhưng vẫn giữ được độ trong chuẩn phở Việt. Bánh phở mềm, ngập trong nước dùng ngọt thanh, thơm mùi gừng, quế, hồi.'," +
                " 35000), " +
                "('Phở','https://cdn.tgdd.vn/Files/2022/01/25/1412805/cach-nau-pho-bo-nam-dinh-chuan-vi-thom-ngon-nhu-hang-quan-202201250230038502.jpg', " +
                "'Phở Bo', " +
                "'Vị bò thơm ngọt nhiều dưỡng chất, bánh phở dai dai cùng với nước dùng đậm đà, hoà huyện với hương thơm của các loai rau thơm ăn kèm.'," +
                " 35000), " +
                "('Bún','https://statics.vinpearl.com/bun-ca-ha-noi-1_1686916725.png', " +
                "'Bún Cá', " +
                "'Trụng bún qua nước sôi xếp vào tô, thêm cá rán, cà chua, rau cần chần, hành lá, rau thì là rồi múc nước dùng chan nóng lên. Ăn kèm với rau sống'," +
                " 30000), " +
                "('Bún','https://pastaxi-manager.onepas.vn/content/uploads/articles/cach-lam-14-mon-bun/14-mon-bun-ngon-1.jpg', " +
                "'Bún sườn chua', " +
                "'Món bún ngon thanh mát cho ngày hè nóng nực.'," +
                " 40000), " +
                "('Bún','https://pastaxi-manager.onepas.vn/content/uploads/articles/cach-lam-14-mon-bun/14-mon-bun-ngon-3.jpg', " +
                "'Bún ốc', " +
                "'Ngọt mát tô bún ngon với ốc xào và đậu rán.'," +
                " 45000), " +
                "('Phở','https://cdn.tgdd.vn/2021/06/content/phoxao-800x450.jpg', " +
                "'Phở xào', " +
                "'Phở xào với những miếng thịt bò mềm, ngọt, quyện cùng với cải thìa, cà rốt, hành tây, vừa tươi, vừa giòn, vừa ngọt, thêm một chút ngò rí, hành lá thơm lừng'," +
                " 25000), " +
                "('Phở','https://cdn.tgdd.vn/2021/06/content/phokhoGL-800x450.jpg', " +
                "'Phở khô Gia lai', " +
                "'Từng sợi phở thấm đẫm nước sốt bò băm đậm đà, mặn mặn, ngọt ngọt vừa ăn. Thịt gà được nấu mềm, ngọt thịt, phần bò xào vừa chín nên vẫn giữ được độ mềm ngọt...'," +
                " 30000), " +
                "('Bún','https://pastaxi-manager.onepas.vn/content/uploads/articles/cach-lam-14-mon-bun/14-mon-bun-ngon-4.jpg', " +
                "'Bún riêu cua', " +
                "'Một trong những món bún ngon khó cưỡng của ngày hè. '," +
                " 40000), " +
                "('Phở','https://haisancoto.com/uploads/images/muc-chien-toi-thom-ngon.jpg', " +
                "' Phở bò viên', " +
                "'Bò viên có gân nên khi ăn nhai sựt sựt, rất thú vị, nạm bò được hầm mềm, dễ ăn vô cùng. Thêm một chút thịt bò tái ngọt mềm cho đủ chất.'," +
                " 40000), " +

                "('Bún','https://pastaxi-manager.onepas.vn/content/uploads/articles/cach-lam-14-mon-bun/14-mon-bun-ngon-7.jpg', " +
                "' Bún hải sản', " +
                "'Bát bún được bày biện cầu kỳ và ngon mắt, mang đậm hương vị miền biển.'," +
                " 40000), " +
                "('Bánh mì','https://cdn.tgdd.vn/Files/2022/03/09/1419200/top-10-loai-nhan-kep-banh-mi-thom-ngon-dinh-duong-cho-bua-sang-202203090747065534.jpg', " +
                "'bánh mì thập cẩm', " +
                "'bánh mì thập cẩm đặc trưng không thể thiếu chả lụa thơm ngon. Đôi khi chỉ cần một ổ bánh mì nhét chả lụa, rắc một ít muối tiêu hay thêm pa tê là đã đủ ngon rồi.'," +
                " 20000), " +
                "('Bánh mì','https://cdn.tgdd.vn/Files/2022/03/09/1419200/top-10-loai-nhan-kep-banh-mi-thom-ngon-dinh-duong-cho-bua-sang-202203090747300400.jpg', " +
                "'bánh mì trứng', " +
                "'Trứng ốp-la có thể kẹp trong bánh mì nướng hoặc bánh sandwich đều rất ngon.'," +
                " 15000), " +
                "('Bánh mì','https://cdn.tgdd.vn/Files/2022/03/09/1419200/top-10-loai-nhan-kep-banh-mi-thom-ngon-dinh-duong-cho-bua-sang-202203090749186172.jpg', " +
                "'bánh mì Xíu mại', " +
                "'Loại xíu mại thường thấy nhất là viên tròn to, thịt băm nửa nạc, nửa mỡ, dai dẻo, nấu ngập trong sốt thơm béo. Xíu mại có thể cho vào nhân bánh mì thịt hoặc làm bánh mì chảo đều hợp.'," +
                " 20000), " +
                "('Bánh mì','https://cdn.tgdd.vn/Files/2022/03/09/1419200/top-10-loai-nhan-kep-banh-mi-thom-ngon-dinh-duong-cho-bua-sang-202203090749373595.jpg', " +
                "'bánh mì Heo quay', " +
                "' kết hợp heo quay, dưa leo, đồ chua, ngò, ớt với nước chan đậm đà (hoặc nước tương) là thưởng thức được rồi.'," +
                " 25000), " +



                "('Bánh mì','https://cdn.tgdd.vn/Files/2022/03/09/1419200/top-10-loai-nhan-kep-banh-mi-thom-ngon-dinh-duong-cho-bua-sang-202203121118090435.jpg'," +
                " 'bánh mì Cá mồi', " +
                "'bánh mì còn có thể kết hợp với nhiều loại nhân khác như cá hộp, khô bò, thịt dê, chà bông… bắt vị không kém.', " +
                "30000)");

        db.execSQL(insert_cmt);

    }





    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists ADMIN");
        db.execSQL("drop table if exists KHACH_HANG");
        db.execSQL("DROP TABLE IF EXISTS tbl_request");
        db.execSQL("DROP TABLE IF EXISTS tbl_food");
        db.execSQL("DROP TABLE IF EXISTS tbl_cart");
        db.execSQL("DROP TABLE IF EXISTS tbl_invoice");

        onCreate(db);
    }
}
