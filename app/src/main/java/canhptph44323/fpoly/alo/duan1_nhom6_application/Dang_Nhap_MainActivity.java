package canhptph44323.fpoly.alo.duan1_nhom6_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import canhptph44323.fpoly.alo.duan1_nhom6_application.Dao.Admin_Dao;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Dao.KhachHang_Dao;

public class Dang_Nhap_MainActivity extends AppCompatActivity {
    EditText edtTaiKhoanDN,edtMatKhauDN;
    Button btnDangNhap;
    TextView txtchuyenDKi;
    KhachHang_Dao khachHang_dao;
    Admin_Dao admin_dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap_main);
        edtTaiKhoanDN=findViewById(R.id.edtTaiKhoanDN);
        edtMatKhauDN=findViewById(R.id.edtMatKhauDN);
        btnDangNhap=findViewById(R.id.btnDangNhap);
        txtchuyenDKi=findViewById(R.id.txtchuyenDKi);
        khachHang_dao= new KhachHang_Dao(this);
        admin_dao= new Admin_Dao(this);
        txtchuyenDKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity( new Intent(Dang_Nhap_MainActivity.this, Dang_ki_MainActivity.class));
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tk_DN = edtTaiKhoanDN.getText().toString();
                String mk_DN = edtMatKhauDN.getText().toString();
                if (tk_DN.isEmpty() || mk_DN.isEmpty()){
                    Toast.makeText(Dang_Nhap_MainActivity.this, "thiếu TK hoặc MK", Toast.LENGTH_SHORT).show();
                }else {
                    if(admin_dao.checkLogin(tk_DN,mk_DN)==1){
                        Intent intent= new Intent(Dang_Nhap_MainActivity.this, MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(Dang_Nhap_MainActivity.this, "Đăng nhập Tk admin ", Toast.LENGTH_SHORT).show();
                    } else if (khachHang_dao.checkLogin(tk_DN,mk_DN)==1) {
                        Intent intent= new Intent(Dang_Nhap_MainActivity.this, TrangChu_MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(Dang_Nhap_MainActivity.this, "Đăng nhập TK Khach hàng", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(Dang_Nhap_MainActivity.this, "Sai Tk hoặc Mk", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}