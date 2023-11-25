package canhptph44323.fpoly.alo.duan1_nhom6_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import canhptph44323.fpoly.alo.duan1_nhom6_application.Dao.KhachHang_Dao;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Models.KhachHang;

public class Register_MainActivity extends AppCompatActivity {
    EditText edtTaiKhoanDK, edtMl_sdtDK, edtMatKhauDK, edtMatKhauDK2;
    TextView txtchuyenDN;
    Button btnDangKi;
    KhachHang khachHang;
    KhachHang_Dao khachHang_dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki_main);
        edtTaiKhoanDK = findViewById(R.id.edtTaiKhoanDK);
        edtMl_sdtDK = findViewById(R.id.edtMl_sdtDK);
        edtMatKhauDK = findViewById(R.id.edtMatKhauDK);
        edtMatKhauDK2 = findViewById(R.id.edtMatKhauDK2);
        txtchuyenDN = findViewById(R.id.txtchuyenDN);
        btnDangKi = findViewById(R.id.btnDangKi);

        txtchuyenDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register_MainActivity.this, Login_MainActivity.class));
            }
        });
        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taikhoanDK = edtTaiKhoanDK.getText().toString();
                String sdt = edtMl_sdtDK.getText().toString();
                String mk_DK = edtMatKhauDK.getText().toString();
                int validationResult = validate();
                if (validationResult == 1) {
                    khachHang_dao = new KhachHang_Dao(Register_MainActivity.this);
                    khachHang = new KhachHang();
                    khachHang.setTEN_KH(taikhoanDK);
                    khachHang.setEMAIL_KH(sdt);
                    khachHang.setMAT_KHAU_KH(mk_DK);

                    long result = khachHang_dao.insert(khachHang);
                    if (result > 0) {
                        Toast.makeText(Register_MainActivity.this, "Đăng kí thành Công", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Register_MainActivity.this, Login_MainActivity.class));
                    } else {
                        Toast.makeText(Register_MainActivity.this, "đăng kí thất bại", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }

    public int validate() {
        int check = 1;
        if (edtTaiKhoanDK.getText().length() == 0 || edtMl_sdtDK.getText().length() == 0 || edtMatKhauDK.getText().length() == 0 || edtMatKhauDK2.getText().length() == 0) {
            Toast.makeText(this, "Ba cần điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            check = -1;
        } else {
            String pass = edtMatKhauDK.getText().toString();
            String pass2 = edtMatKhauDK2.getText().toString();
            if (!pass.equals(pass2)) {
                Toast.makeText(this, "mật kẩu bạn nhập không khop", Toast.LENGTH_SHORT).show();
                check = -1;
            }
        }
        return check;
    }
}