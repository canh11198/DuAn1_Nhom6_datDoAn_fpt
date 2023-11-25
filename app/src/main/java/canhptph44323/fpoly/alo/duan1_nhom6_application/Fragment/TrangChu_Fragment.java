package canhptph44323.fpoly.alo.duan1_nhom6_application.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
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
import android.widget.ImageView;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

import canhptph44323.fpoly.alo.duan1_nhom6_application.Adapters.MonAn_Adapter;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Dao.MonAn_Dao;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Models.MonAN;
import canhptph44323.fpoly.alo.duan1_nhom6_application.R;

//implements LoaiMA_Adapter.OnItemClickListener
public class TrangChu_Fragment extends Fragment   {

//    RecyclerView recyclerViewDSMA,rcv_trangchu_Loai_mA;
//    private RecyclerView.Adapter adapter_loaimonan;
//
//    List<MonAN>list= new ArrayList<>();
//    private ArrayList<LoaiMon> items;
//
//    MonAn_Dao monAn_dao;
//    MonAn_Adapter monAn_adapter;
    RecyclerView recyclerView;
    MonAn_Dao monAn_dao;
    ArrayList<MonAN> listMonAn;
    MonAn_Adapter monAn_adapter;
    Context context;
    private GradientDrawable selectedBorder;
    private GradientDrawable normalBorder;
    private View selectedView = null;

    public static TrangChu_Fragment newInstance() {
        TrangChu_Fragment fragment = new TrangChu_Fragment();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trang_chu_, container, false);
        // khoi tạo danh sach đồ ăn
//        recyclerViewDSMA= view.findViewById(R.id.rcv_trangChu_DS_MA);
//        //rcv_trangchu_Loai_mA=view.findViewById(R.id.rcv_trangchu_Loai_mA);
//
//        khoiTao();
//        initRecyclerview();
//
//        monAn_dao= new MonAn_Dao(getContext());
//        list= monAn_dao.getAll();
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
//        recyclerViewDSMA.setLayoutManager(layoutManager);
//        monAn_adapter= new MonAn_Adapter(getContext(),list);
//        recyclerViewDSMA.setAdapter(monAn_adapter);
//        monAn_adapter.notifyDataSetChanged();


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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recy_fragment_Trangchu_listFood);
        ImageButton imgTap_Search= view.findViewById(R.id.btn_fragment_Trangchu_tapSearch);
        EditText edSearch = view.findViewById(R.id.ed_fragment_Trangchu_search);

        ImageView ivTypeFood1,ivTypeFood2,ivTypeFood3;
        TextView tvTypeFood1,tvTypeFood2,tvTypeFood3, tvGetAll;


        ivTypeFood1 = view.findViewById(R.id.iv_home_typeFood1);
        ivTypeFood2 = view.findViewById(R.id.iv_home_typeFood2);
        ivTypeFood3 = view.findViewById(R.id.iv_home_typeFood3);
        tvTypeFood1 = view.findViewById(R.id.tv_home_typeFood1);
        tvTypeFood2 = view.findViewById(R.id.tv_home_typeFood2);
        tvTypeFood3 = view.findViewById(R.id.tv_home_typeFood3);
        tvGetAll = view.findViewById(R.id.tv_home_getAll);

        // tạo ra hiệu ứng viền được chọn cho một phần tử trong giao diện người dùng.
        selectedBorder= new GradientDrawable();
        selectedBorder.setShape(GradientDrawable.RECTANGLE);// vẽ một hình chữ nhật.
        selectedBorder.setStroke(5, Color.BLACK);//đặt viền với độ dày là 5 pixel và màu
        selectedBorder.setCornerRadius(10);// được bo tròn với bán kính là 10 pixel.

        normalBorder= new GradientDrawable();
        normalBorder.setShape(GradientDrawable.RECTANGLE);
        normalBorder.setStroke(0,Color.TRANSPARENT);// màu bình thường sẵn có
        normalBorder.setCornerRadius(10);

        imgTap_Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edSearch.length()>0){
                    String searchToName =edSearch.getText().toString().trim();
                    LinearLayoutManager layoutManager=new GridLayoutManager(getContext(),1);
                    recyclerView.setLayoutManager(layoutManager);
                    MonAn_Dao monAn_dao1= new MonAn_Dao(getContext());
                    listMonAn=new ArrayList<>();
                    listMonAn=monAn_dao1.search(searchToName);
                    monAn_adapter.setData(listMonAn);
                    recyclerView.setAdapter(monAn_adapter);
                }
            }
        });
        ivTypeFood1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String typeName = tvTypeFood1.getText().toString();
                selectTypeFood(v, typeName);
            }
        });
        ivTypeFood2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String typeName = tvTypeFood2.getText().toString();
                selectTypeFood(v, typeName);
            }
        });
        ivTypeFood3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String typeName = tvTypeFood3.getText().toString();
                selectTypeFood(v, typeName);
            }
        });
        tvGetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reloadData();
            }
        });

        reloadData();
    }
    private void selectTypeFood(View view, String typeName) {
        // Kiểm tra nếu mục được chọn trước đó không null và khác mục mới
        if (selectedView != null && selectedView != view) {
            // Bỏ viền của mục cũ
            selectedView.setBackground(normalBorder);
        }

        // Set viền mới cho mục mới được chọn
        view.setBackground(selectedBorder);

        // Lưu trạng thái mục mới được chọn
        selectedView = view;

        // Xử lý logic tương ứng với việc nhấn vào từng mục ở đây
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(linearLayoutManager);
        MonAn_Dao monAnDao1 = new MonAn_Dao(getContext());
        listMonAn = new ArrayList<>();
        listMonAn = monAnDao1.TypeName(typeName);
        monAn_adapter.setData(listMonAn);
        recyclerView.setAdapter(monAn_adapter);
    }
    private void reloadData(){
        monAn_dao = new MonAn_Dao(getContext());
        listMonAn = monAn_dao.getAllData();
        monAn_adapter = new MonAn_Adapter(getContext(),listMonAn,monAn_dao);
        monAn_adapter.setData(listMonAn);
        recyclerView.setAdapter(monAn_adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
    }
    //    private void anhxa(){
//
//    }
//    private void khoiTao(){
//        items = new ArrayList<>();
//
//        items.add(new LoaiMon(1,"Bánh mì", "banhmi2d"));
//        items.add(new LoaiMon(2,"Bún", "bun2d"));
//        items.add(new LoaiMon(3,"Phở", "loaipho"));
//    }
//    private void initRecyclerview() {
//
//        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
//        rcv_trangchu_Loai_mA.setLayoutManager(layoutManager1);
//        adapter_loaimonan = new LoaiMA_Adapter(items,this::onItemClick);
//        rcv_trangchu_Loai_mA.setAdapter(adapter_loaimonan);
//    }
//
//    @Override
//    public void onItemClick(int position) {
//        try {
//            if (items != null && position >= 0 && position < items.size()) {
//                LoaiMon loaiMon = items.get(position);
//                if (loaiMon != null) {
//                    Log.d("ItemClick", "Item clicked: " + loaiMon.getTenMonAn());
//
//                    if (loaiMon.getTenMonAn().equals("Bún")) {
//                        Intent intent = new Intent(requireActivity(), Bun_MainActivity_KH.class);
//                        startActivity(intent);
//                    } else if (loaiMon.getTenMonAn().equals("Phở")) {
//                        Intent intent = new Intent(requireActivity(), Pho_MainActivity_KH.class);
//                        startActivity(intent);
//                    } else if (loaiMon.getTenMonAn().equals("Bánh mì")) {
//                        Intent intent = new Intent(requireActivity(), Banhmi_MainActivity_KH.class);
//                        startActivity(intent);
//                    }
//                } else {
//                    Log.e("ItemClick", "LoaiMon object at position " + position + " is null");
//                }
//            } else {
//                Log.e("ItemClick", "Invalid position or items list is null");
//            }
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//            Log.e("ItemClick", "NullPointerException occurred: " + e.getMessage());
//        }
//    }
}