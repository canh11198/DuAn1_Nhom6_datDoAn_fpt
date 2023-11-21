package canhptph44323.fpoly.alo.duan1_nhom6_application.Adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import canhptph44323.fpoly.alo.duan1_nhom6_application.Dao.MonAn_Dao;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Fragment.TrangChu_Fragment;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Models.MonAN;
import canhptph44323.fpoly.alo.duan1_nhom6_application.R;


public class MonAn_Adapter extends RecyclerView.Adapter<MonAn_Adapter.MonAN_Viewholder> {
    private Context context;
    TrangChu_Fragment fragment;
    List<MonAN> list;
    MonAn_Dao monAn_dao;
//    ImageView img_item_trangchu;
//    TextView txtgiatien_item_trangchu,txtAdd_cart_trangchu,txt_tenMon_item_TT;
    public MonAn_Adapter(Context context,List<MonAN> list) {
        this.context = context;
        this.list = list;
        monAn_dao= new MonAn_Dao(context);
    }
    @NonNull
    @Override
    public MonAN_Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_danhsachmon_frmt_trangchu,parent,false);
        return new MonAN_Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonAN_Viewholder holder, int position) {
        MonAN monAN= list.get(position);
        Log.d("MonAN_Adapter", "Tên món ăn: " + monAN.getTEN_MON());
        Log.d("MonAN_Adapter", "Giá: " + monAN.getGIA());
        Log.d("MonAN_Adapter", "Đường dẫn ảnh: " + monAN.getANH());

        holder.txt_tenMon_item_TT.setText(monAN.getTEN_MON());
        holder.txtgiatien_item_trangchu.setText("Giá "+ monAN.getGIA());
        Glide.with(holder.itemView.getContext()).load(monAN.getANH()).into(holder.img_item_trangchu);
        holder.txtAdd_cart_trangchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //    public MonAn_Adapter(Context context, TrangChu_Fragment fragment,List<MonAN> list) {
//        super(context, 0,list);
//        this.context = context;
//        this.fragment = fragment;
//        this.list = list;
//public MonAn_Adapter(Context context, List<MonAN> list) {
//
//    this.context = context;
//
//    this.list = list;
//}
public class MonAN_Viewholder extends RecyclerView.ViewHolder{
    ImageView img_item_trangchu;
    TextView txt_tenMon_item_TT,txtgiatien_item_trangchu,txtAdd_cart_trangchu;
    public MonAN_Viewholder(@NonNull View itemView) {
        super(itemView);
        img_item_trangchu=itemView.findViewById(R.id.img_item_trangchu);
        txt_tenMon_item_TT=itemView.findViewById(R.id.txt_tenMon_item_TT);
        txtgiatien_item_trangchu=itemView.findViewById(R.id.txtgiatien_item_trangchu);
        txtAdd_cart_trangchu=itemView.findViewById(R.id.txtAdd_cart_trangchu);
    }
}


}
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        View v = convertView;
//        if (v == null) {
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            v = inflater.inflate(R.layout.item_danhsachmon_frmt_trangchu, null);
//        }
//        final MonAN monan = list.get(position);
//        if (monan != null) {
//            txt_tenMon_item_TT = v.findViewById(R.id.txt_tenMon_item_TT);
//            txtgiatien_item_trangchu=v.findViewById(R.id.txtgiatien_item_trangchu);
//            txtAdd_cart_trangchu=v.findViewById(R.id.txtAdd_cart_trangchu);
//            img_item_trangchu= v.findViewById(R.id.img_item_trangchu);
//
//            if(txt_tenMon_item_TT != null){
//                txt_tenMon_item_TT.setText(monan.getTEN_MON());
//            }
//            if(txtgiatien_item_trangchu!= null){
//                txtgiatien_item_trangchu.setText("Giá "+ monan.getGIA());
//            }
//            if (img_item_trangchu != null){
//                Glide.with(context).load(monan.getANH()).into(img_item_trangchu);
//            }
//            txtAdd_cart_trangchu.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
//
//
//        }
//
//        return v;
//    }

