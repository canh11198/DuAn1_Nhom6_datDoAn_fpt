package canhptph44323.fpoly.alo.duan1_nhom6_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import canhptph44323.fpoly.alo.duan1_nhom6_application.Fragment.GioHang_Fragment;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Fragment.TaiKhoan_Fragment;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Fragment.TrangChu_Fragment;

public class TrangChu_MainActivity extends AppCompatActivity {
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu_main);
        doifrg(new TrangChu_Fragment());
         //fragment= findViewById(R.id.FameLayout);
        BottomNavigationView bottomNavigationView= findViewById(R.id.navigation_TrangChu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment1;
                int id =item.getItemId();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                if(id== R.id.item_TrangChu){
                    doifrg(new TrangChu_Fragment());
                } else if (id== R.id.item_gioHang) {
                    doifrg(new GioHang_Fragment());
                }else if (id== R.id.item_TaiKhoan){
                    doifrg(new TaiKhoan_Fragment());
                }
                return false;
            }
        });
        

    }
    public void doifrg(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.FameLayout,fragment).commit();

    }

}