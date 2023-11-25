package canhptph44323.fpoly.alo.duan1_nhom6_application.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import canhptph44323.fpoly.alo.duan1_nhom6_application.Dao.GioHang_Dao;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Dao.MonAn_Dao;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Fragment.TrangChu_Fragment;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Models.Gio_Hang;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Models.MonAN;
import canhptph44323.fpoly.alo.duan1_nhom6_application.R;


public class MonAn_Adapter extends RecyclerView.Adapter<MonAn_Adapter.MonAN_Viewholder> {
    private Context context;
    TrangChu_Fragment fragment;
    List<MonAN> list;
    List<Gio_Hang> gio_hangList;
    MonAn_Dao monAn_dao;
    GioHang_Dao gioHang_dao;
    GioHang_Adapter gioHang_adapter;

    public MonAn_Adapter(Context context, List<MonAN> list, MonAn_Dao monAn_dao) {
        this.context = context;
        this.list = list;
        this.monAn_dao = monAn_dao;
    }

    public void setData(ArrayList<MonAN> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MonAN_Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_danhsachmon_frmt_trangchu, parent, false);
        return new MonAN_Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonAN_Viewholder holder, int position) {
        //gio_hangList = gioHang_dao.getAllData();
        MonAN monAN = list.get(position);
        holder.tv_name.setText(list.get(position).getName());
        String img = list.get(position).getImg();
        Picasso.get().load(img).into(holder.iv_img);
        holder.tv_des.setText(monAN.getDes());
        holder.tv_price.setText(String.valueOf(list.get(position).getPrice()) + " VND");
        holder.btn_addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.dialog_item_them_cart);

                Window window = dialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                AppCompatButton btnSubmit, btnCancel;
                btnSubmit = dialog.findViewById(R.id.btn_dialog_item_add_cart);
                btnCancel = dialog.findViewById(R.id.btn_dialog_item_cancel_cart);

                btnSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        GioHang_Dao gioHang_dao = new GioHang_Dao(context);
//                        Gio_Hang gio_hang = new Gio_Hang();
//                        gio_hang.setIdFood(monAN.getId());
//                        gio_hang.setQuanti(1);
//                        gio_hang.setSum(monAN.getPrice());
//                        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_FILE", Context.MODE_PRIVATE);
//                        String usernameLogged = sharedPreferences.getString("USERNAME", "");
//                        gio_hang.setUsername(usernameLogged);
//                        if (!gioHang_dao.FoodExists(gio_hang.getIdFood(), gio_hang.getUsername())) {
//                            if (gioHang_dao.insert(gio_hang) > 0) {
//                                Toast.makeText(context, "đã thêm vào giỏ hàng", Toast.LENGTH_SHORT).show();
//                                dialog.dismiss();
//                            }else {
//                                Toast.makeText(context, "không Thêm Vào Giỏ Hàng", Toast.LENGTH_SHORT).show();
//                            }
//
//                    }else {
//                            Toast.makeText(context, "Món ăn đã được chọn", Toast.LENGTH_SHORT).show();
//                            dialog.dismiss();
//                        }

                }
            });
                btnCancel.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){
                dialog.dismiss();
            }
            });


                dialog.show();
        }
    });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
//        MonAN monAN= list.get(position);
//        Log.d("MonAN_Adapter", "Tên món ăn: " + monAN.getTEN_MON());
//        Log.d("MonAN_Adapter", "Giá: " + monAN.getGIA());
//        Log.d("MonAN_Adapter", "Đường dẫn ảnh: " + monAN.getANH());
//
//        holder.txt_tenMon_item_TT.setText(monAN.getTEN_MON());
//        holder.txtgiatien_item_trangchu.setText("Giá "+ monAN.getGIA());
//        Glide.with(holder.itemView.getContext()).load(monAN.getANH()).into(holder.img_item_trangchu);
//        holder.txtAdd_cart_trangchu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
}

    @Override
    public int getItemCount() {
        return list.size();
    }


public class MonAN_Viewholder extends RecyclerView.ViewHolder {
    ImageView iv_img;
    TextView tv_name, tv_price, tv_des;
    ImageView btn_addCart;

    public MonAN_Viewholder(@NonNull View itemView) {
        super(itemView);
        iv_img = itemView.findViewById(R.id.iv_item_food_foodImg);
        tv_name = itemView.findViewById(R.id.tv_item_food_foodName);
        tv_price = itemView.findViewById(R.id.tv_item_food_foodPrice);
        btn_addCart = itemView.findViewById(R.id.btn_item_food_addCart);
        tv_des = itemView.findViewById(R.id.tv_item_food_des);
    }
}


}

//                Intent i = new Intent(context, ItemInforFood.class);
//                i.putExtra("foodImg", list.get(position).getImg());
//                i.putExtra("foodName", list.get(position).getName());
//                i.putExtra("foodDes", list.get(position).getDes());
//                i.putExtra("foodPrice", list.get(position).getPrice());
//                i.putExtra("foodId",list.get(position).getId());
//                context.startActivity(i);
