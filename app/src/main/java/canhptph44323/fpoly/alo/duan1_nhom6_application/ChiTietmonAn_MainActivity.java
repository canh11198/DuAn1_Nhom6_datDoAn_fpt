package canhptph44323.fpoly.alo.duan1_nhom6_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import canhptph44323.fpoly.alo.duan1_nhom6_application.Adapters.BinhLuan_Adapter;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Dao.BinhLuan_Dao;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Models.BinhLuan;

public class ChiTietmonAn_MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tietmon_an_main);

    }
}