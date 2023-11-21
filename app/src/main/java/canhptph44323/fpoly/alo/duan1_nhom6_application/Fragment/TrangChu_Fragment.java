package canhptph44323.fpoly.alo.duan1_nhom6_application.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

import canhptph44323.fpoly.alo.duan1_nhom6_application.Adapters.LoaiMA_Adapter;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Adapters.MonAn_Adapter;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Dao.MonAn_Dao;
import canhptph44323.fpoly.alo.duan1_nhom6_application.KhachHang_pk.Banhmi_MainActivity_KH;
import canhptph44323.fpoly.alo.duan1_nhom6_application.KhachHang_pk.Bun_MainActivity_KH;
import canhptph44323.fpoly.alo.duan1_nhom6_application.KhachHang_pk.Pho_MainActivity_KH;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Models.LoaiMon;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Models.MonAN;
import canhptph44323.fpoly.alo.duan1_nhom6_application.R;


public class TrangChu_Fragment extends Fragment implements LoaiMA_Adapter.OnItemClickListener  {

    RecyclerView recyclerViewDSMA,rcv_trangchu_Loai_mA;
    private RecyclerView.Adapter adapter_loaimonan;

    List<MonAN>list= new ArrayList<>();
    private ArrayList<LoaiMon> items;

    MonAn_Dao monAn_dao;
    MonAn_Adapter monAn_adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trang_chu_, container, false);
        // khoi tạo danh sach đồ ăn
        recyclerViewDSMA= view.findViewById(R.id.rcv_trangChu_DS_MA);
        rcv_trangchu_Loai_mA=view.findViewById(R.id.rcv_trangchu_Loai_mA);

        khoiTao();
        initRecyclerview();

        monAn_dao= new MonAn_Dao(getContext());
        list= monAn_dao.getAll();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewDSMA.setLayoutManager(layoutManager);
        monAn_adapter= new MonAn_Adapter(getContext(),list);
        recyclerViewDSMA.setAdapter(monAn_adapter);
        monAn_adapter.notifyDataSetChanged();


        ArrayList<SlideModel> imageList = new ArrayList<>(); // Create image list

// imageList.add(new SlideModel("String Url" or R.drawable);
// imageList.add(new SlideModel("String Url" or R.drawable, "title"); You can add title

        imageList.add(new SlideModel(R.drawable.bunhaisan, "Nước dùng là loại nước cốt ninh các loại hải sản như tôm, cua, ghẹ,...", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.buasang1, "Đặc sản nổi tiếng từ 3 miền.",ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.buasang2, "Bánh mì áp chảo thơm ngon , giòn đến miếng cuối cùng.",ScaleTypes.CENTER_CROP));

        ImageSlider imageSlider = view.findViewById(R.id.image_slider);
        imageSlider.setImageList(imageList);



        return view;

    }
    private void anhxa(){

    }
    private void khoiTao(){
        items = new ArrayList<>();

        items.add(new LoaiMon(1,"Bánh mì", "banhmi2d"));
        items.add(new LoaiMon(2,"Bún", "bun2d"));
        items.add(new LoaiMon(3,"Phở", "loaipho"));
    }
    private void initRecyclerview() {

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rcv_trangchu_Loai_mA.setLayoutManager(layoutManager1);
        adapter_loaimonan = new LoaiMA_Adapter(items,this::onItemClick);
        rcv_trangchu_Loai_mA.setAdapter(adapter_loaimonan);
    }

    @Override
    public void onItemClick(int position) {
        try {
            if (items != null && position >= 0 && position < items.size()) {
                LoaiMon loaiMon = items.get(position);
                if (loaiMon != null) {
                    Log.d("ItemClick", "Item clicked: " + loaiMon.getTenMonAn());

                    if (loaiMon.getTenMonAn().equals("Bún")) {
                        Intent intent = new Intent(requireActivity(), Bun_MainActivity_KH.class);
                        startActivity(intent);
                    } else if (loaiMon.getTenMonAn().equals("Phở")) {
                        Intent intent = new Intent(requireActivity(), Pho_MainActivity_KH.class);
                        startActivity(intent);
                    } else if (loaiMon.getTenMonAn().equals("Bánh mì")) {
                        Intent intent = new Intent(requireActivity(), Banhmi_MainActivity_KH.class);
                        startActivity(intent);
                    }
                } else {
                    Log.e("ItemClick", "LoaiMon object at position " + position + " is null");
                }
            } else {
                Log.e("ItemClick", "Invalid position or items list is null");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            Log.e("ItemClick", "NullPointerException occurred: " + e.getMessage());
        }
    }
}