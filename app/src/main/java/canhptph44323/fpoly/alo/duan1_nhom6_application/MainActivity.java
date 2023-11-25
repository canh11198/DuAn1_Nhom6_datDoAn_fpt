package canhptph44323.fpoly.alo.duan1_nhom6_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;

import canhptph44323.fpoly.alo.duan1_nhom6_application.Fragment.QuanLy_DoanhThu_Fragment;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Fragment.QuanLy_MonAn_Fragment;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Fragment.QuanLy_donDathang_Fragment;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Fragment.QuanLy_lichSu_dat_Fragment;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Fragment.Quanly_LoaiMonAn_Fragment;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    FrameLayout frameLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
    }

    private void anhXa() {
        drawerLayout = findViewById(R.id.drawlayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigation_view_Admin);
        frameLayout = findViewById(R.id.frame_layout);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Quản Lý Món Ăn");
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        doifgm(new QuanLy_MonAn_Fragment());
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                FragmentManager fragmentManager= getSupportFragmentManager();
                FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
                if(id==R.id.item_QuanLyMonAn){
                    doifgm(new QuanLy_MonAn_Fragment());
                    toolbar.setTitle(item.getTitle());
                }else if (id == R.id.item_QuanLyLoaiMonAn){
                    doifgm(new Quanly_LoaiMonAn_Fragment());
                    toolbar.setTitle(item.getTitle());
                } else if (id== R.id.item_QuanLydoanhThu) {
                    doifgm(new QuanLy_DoanhThu_Fragment());
                    toolbar.setTitle(item.getTitle());
                } else if (id==R.id.item_QuanLydonDathang) {
                    doifgm(new QuanLy_donDathang_Fragment());
                    toolbar.setTitle(item.getTitle());
                } else if (id==R.id.item_QuanLyLichSu) {
                    doifgm(new QuanLy_lichSu_dat_Fragment());
                    toolbar.setTitle(item.getTitle());
                }

                else if (item.getItemId()==R.id.item_DangXuat) {
                    Intent intent = new Intent(MainActivity.this,Login_MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }
    public void doifgm(Fragment fragment){
        FragmentManager fragmentManager =getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_layout,fragment).commit();
    }
}