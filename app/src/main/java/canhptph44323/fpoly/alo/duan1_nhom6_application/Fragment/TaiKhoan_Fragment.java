package canhptph44323.fpoly.alo.duan1_nhom6_application.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import canhptph44323.fpoly.alo.duan1_nhom6_application.Login_MainActivity;
import canhptph44323.fpoly.alo.duan1_nhom6_application.R;


public class TaiKhoan_Fragment extends Fragment {
    private  View view;
    private Intent intent;
    private TextView txtDangXuat;



    public TaiKhoan_Fragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_tai_khoan_, container, false);
        txtDangXuat = view.findViewById(R.id.txtDangXuat);

        txtDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Login_MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        });
        return  view;


    }
}