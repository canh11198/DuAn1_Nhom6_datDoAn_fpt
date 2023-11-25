package canhptph44323.fpoly.alo.duan1_nhom6_application.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Collections;

import canhptph44323.fpoly.alo.duan1_nhom6_application.Adapters.Food_Adapter;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Dao.Food_Dao;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Models.Foods;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Models.LoaiMon;
import canhptph44323.fpoly.alo.duan1_nhom6_application.R;


public class QuanLy_MonAn_Fragment extends Fragment {

    RecyclerView recyclerView;
    Food_Dao foodDAO;
    ArrayList<Foods> listFood;
    ArrayList<LoaiMon> llist;
    Food_Adapter adapter;
    Context context;

    public QuanLy_MonAn_Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quan_ly__mon_an_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recy_fragment_listFood_ad);

        ImageButton img_tapSearch = view.findViewById(R.id.btn_fragment_listFood_tapSearch_ad);
        ImageButton img_tapAdd = view.findViewById(R.id.btn_fragment_listFood_tapAdd_ad);
        EditText edSearch = view.findViewById(R.id.ed_fragment_listFood_search_ad);

        img_tapSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edSearch.length() > 0) {
                    String searchName = edSearch.getText().toString().trim();
                    LinearLayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
                    recyclerView.setLayoutManager(layoutManager);
                    Food_Dao food_dao1 = new Food_Dao(getContext());
                    listFood= new ArrayList<>();
                    listFood=food_dao1.Search(searchName);
                    adapter.setData(listFood);
                    recyclerView.setAdapter(adapter);
                }else {
                    reloadData();
                }
            }
        });

        img_tapAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        reloadData();
    }
    private void reloadData(){
        foodDAO = new Food_Dao(getContext());
        listFood = foodDAO.getAllData();
        Collections.reverse(listFood);
        adapter = new Food_Adapter(getContext(),listFood,foodDAO);
        adapter.setData(listFood);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
    }
}