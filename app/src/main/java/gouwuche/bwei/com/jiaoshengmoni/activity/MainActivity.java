package gouwuche.bwei.com.jiaoshengmoni.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import java.util.ArrayList;

import gouwuche.bwei.com.jiaoshengmoni.R;
import gouwuche.bwei.com.jiaoshengmoni.adapter.MyAdapter;
import gouwuche.bwei.com.jiaoshengmoni.util.ImageUtil;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));

        adapter = new MyAdapter(MainActivity.this);
        recyclerView.setAdapter(adapter);

        adapter.replaceAll(getData());


    }

    public ArrayList<String> getData() {
        ArrayList<String> list = new ArrayList<>();
        for (String url : ImageUtil.imageUrls) {
            list.add(url);
        }
        Log.i("--------", list.toString());

        return list;
    }

}
