package canhptph44323.fpoly.alo.duan1_nhom6_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Man_Hinh_Cho_MainActivity extends AppCompatActivity {
    Button btnRegister;
    TextView txtSign_in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_cho_main);
        btnRegister=findViewById(R.id.btnRegister);
        txtSign_in=findViewById(R.id.txtSign_in);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Man_Hinh_Cho_MainActivity.this, Dang_ki_MainActivity.class));
            }
        });
        txtSign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Man_Hinh_Cho_MainActivity.this, Dang_Nhap_MainActivity .class));
            }
        });
    }
}