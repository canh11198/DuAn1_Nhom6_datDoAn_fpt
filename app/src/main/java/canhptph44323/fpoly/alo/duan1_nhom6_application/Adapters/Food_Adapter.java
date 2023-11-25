package canhptph44323.fpoly.alo.duan1_nhom6_application.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import canhptph44323.fpoly.alo.duan1_nhom6_application.Dao.Food_Dao;
import canhptph44323.fpoly.alo.duan1_nhom6_application.Models.Foods;
import canhptph44323.fpoly.alo.duan1_nhom6_application.R;

public class Food_Adapter extends RecyclerView.Adapter<Food_Adapter.ViewHolder> {
    Context context;
    private ArrayList<Foods> list;
    private Food_Dao dao;

    public Food_Adapter(Context context, ArrayList<Foods> list, Food_Dao dao) {
        this.context = context;
        this.list = list;
        this.dao = dao;
    }
    public void setData(ArrayList<Foods> list){
        this.list = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_admin_food,null);
        return new Food_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_name.setText(list.get(position).getName());
        String img=list.get(position).getImg();
        Picasso.get().load(img).into(holder.iv_img);
        holder.tv_des.setText(list.get(position).getDes());
        holder.tv_price.setText(String.valueOf(list.get(position).getPrice())+" VND");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_img;
        TextView tv_name, tv_des, tv_price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_img = itemView.findViewById(R.id.iv_item_listFood_foodImg);
            tv_name = itemView.findViewById(R.id.tv_item_listFood_foodName);
            tv_des = itemView.findViewById(R.id.tv_item_listFood_foodContent);
            tv_price = itemView.findViewById(R.id.tv_item_listFood_foodPrice);
        }
    }
}
