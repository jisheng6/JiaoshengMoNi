package gouwuche.bwei.com.jiaoshengmoni.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

import gouwuche.bwei.com.jiaoshengmoni.R;
import gouwuche.bwei.com.jiaoshengmoni.ShopActivity;

/**
 * Created by Adminjs on 2017/11/18.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.SViewHolder>{
    Context context;
    List<String>list1 = new ArrayList<>();
    public MyAdapter(Context context) {
        this.context = context;
       ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));
    }

    public void replaceAll(ArrayList<String> list) {
        list1.clear();
        if (list != null && list.size() > 0) {
            list1.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override
    public SViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.item_layout,null);
        SViewHolder holder = new SViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(SViewHolder holder, int position) {
        ImageLoader.getInstance().displayImage(list1.get(position),holder.image);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShopActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }


    class SViewHolder extends RecyclerView.ViewHolder {
           ImageView image;
        public SViewHolder(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.item_simageview);
        }
    }

}
