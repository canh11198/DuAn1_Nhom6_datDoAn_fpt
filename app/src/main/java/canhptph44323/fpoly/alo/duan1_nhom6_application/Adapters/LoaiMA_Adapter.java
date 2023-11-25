package canhptph44323.fpoly.alo.duan1_nhom6_application.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;

import java.util.ArrayList;

import canhptph44323.fpoly.alo.duan1_nhom6_application.Models.LoaiMon;
import canhptph44323.fpoly.alo.duan1_nhom6_application.R;

public class LoaiMA_Adapter extends RecyclerView.Adapter<LoaiMA_Adapter.Loai_viewholder>{
    ArrayList<LoaiMon> items;
    Context context;
     OnItemClickListener listener; // Biến interface

    public LoaiMA_Adapter(ArrayList<LoaiMon> items,OnItemClickListener listener) {
        this.items = items;
        this.listener=listener;
    }
    public LoaiMA_Adapter(){

    }

    @NonNull
    @Override
    public Loai_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loai_ma_fgm_trangchu,parent,false);

        context = parent.getContext();
        return new Loai_viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Loai_viewholder holder, int position) {
//    holder.txt_tenloai_item_TT.setText(items.get(position).getTenMonAn());
//        int drawableResourceId = holder.itemView.getResources().getIdentifier(items.get(position).getANH_LOAI(),
//                "drawable",holder.itemView.getContext().getPackageName());
//        Glide.with(holder.itemView.getContext())
//                .load(drawableResourceId).transform(new GranularRoundedCorners(30,30,0,0))
//                .into(holder.img_itemLoai_trangchu);
//
//        holder.itemView.setOnClickListener(v -> {
//            if (listener != null) {
//                listener.onItemClick(position);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Loai_viewholder extends RecyclerView.ViewHolder{
        TextView txt_tenloai_item_TT;
        ImageView img_itemLoai_trangchu;

        public Loai_viewholder(@NonNull View itemView) {
            super(itemView);
            txt_tenloai_item_TT=itemView.findViewById(R.id.txt_tenloai_item_TT);
            img_itemLoai_trangchu=itemView.findViewById(R.id.img_itemLoai_trangchu);
        }
    }
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
}
