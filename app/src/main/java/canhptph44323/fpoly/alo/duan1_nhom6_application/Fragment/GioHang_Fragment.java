package canhptph44323.fpoly.alo.duan1_nhom6_application.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import canhptph44323.fpoly.alo.duan1_nhom6_application.Adapters.GioHang_Adapter;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Dao.Food_Dao;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Dao.GioHang_Dao;
import canhptph44323.fpoly.alo.duan1_nhom6_application.ItemTouchHelperListener;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Models.Foods;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Models.Gio_Hang;
import canhptph44323.fpoly.alo.duan1_nhom6_application.R;
import canhptph44323.fpoly.alo.duan1_nhom6_application.RecycleViewItemTouchHelper;


public class GioHang_Fragment extends Fragment implements GioHang_Adapter.OnQuantityUpClickListener, GioHang_Adapter.OnQuantityDownClickListener, ItemTouchHelperListener {
    RecyclerView recyclerView;
    TextView tv_sumPrice;
    Button btn_confirm;
    ImageView backBtn;
    GioHang_Dao gioHang_dao;
    Food_Dao foodDAO;
    ArrayList<Gio_Hang> list_gioHang;
    ArrayList<Foods> listFood;
    GioHang_Adapter  gioHang_adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_gio_hang_, container, false);
        recyclerView = view.findViewById(R.id.recy_fragment_cart_listFood);
        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("USER_FILE", Context.MODE_PRIVATE);
        String InUsername1 = sharedPreferences.getString("USERNAME", "");
        gioHang_dao = new GioHang_Dao(getContext());
        list_gioHang = gioHang_dao.getByUser(InUsername1);
        tv_sumPrice = view.findViewById(R.id.tv_fragment_cart_sumPrice);
        btn_confirm = view.findViewById(R.id.btn_fragment_cart_confirm);
        backBtn=view.findViewById(R.id.backBtn);
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                requireActivity().onBackPressed();
            }
        });
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        ItemTouchHelper.SimpleCallback simpleCallback = new RecycleViewItemTouchHelper(0, ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(simpleCallback).attachToRecyclerView(recyclerView);
        reloadData();
        updateTotalSum();
        return view;
    }
    private void reloadData() {
        gioHang_dao = new GioHang_Dao(getActivity());
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("USER_FILE", Context.MODE_PRIVATE);
        String loggedInUserName = sharedPreferences.getString("USERNAME", "");
        list_gioHang = gioHang_dao.getByUser(loggedInUserName);
        gioHang_adapter = new GioHang_Adapter(getContext(), list_gioHang, gioHang_dao);
        gioHang_adapter.setOnQuantityUpClickListener(this);
        gioHang_adapter.setOnQuantityDownClickListener(this);
        recyclerView.setAdapter(gioHang_adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));

    }

    @Override
    public void onQuantityUpClick(int position) {
        updateTotalSum();
    }

    @Override
    public void onQuantityDownClick(int position) {
        updateTotalSum();
    }
    private void updateTotalSum() {
        int totalSum = calculateTotalSum();
        tv_sumPrice.setText(String.valueOf(totalSum) + " VND");
    }

    private int calculateTotalSum() {
        int totalSum = 0;
        for (Gio_Hang gio_hang : list_gioHang) {
            totalSum += gio_hang.getSum();
        }
        return totalSum;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof GioHang_Adapter.ViewHolder) {
            int id = list_gioHang.get(viewHolder.getAdapterPosition()).getIdCart();
            if (gioHang_dao.delete(id) > 0) {
                Toast.makeText(getContext(), "Xóa thành công", Toast.LENGTH_SHORT).show();
                reloadData();
                updateTotalSum();
            } else {
                Toast.makeText(getContext(), "Xóa không thành công", Toast.LENGTH_SHORT).show();

            }


        }
    }


}