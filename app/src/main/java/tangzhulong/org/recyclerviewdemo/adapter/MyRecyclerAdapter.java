package tangzhulong.org.recyclerviewdemo.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tangzhulong.org.recyclerviewdemo.R;

/**
 * Created by tangzhulong on 2018/12/20.
 */

public class MyRecyclerAdapter extends Adapter<MyViewHolder> {
    private List<String> datas = new ArrayList<String>();
    private Context context;
    private LayoutInflater layoutInflater;

    public MyRecyclerAdapter(List<String> datas, Context context) {
        this.datas = datas;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.item_simple, viewGroup, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.textView.setText(datas.get(i));
    }

    public void add(int pos) {
        datas.add(pos, "Insert");
        notifyItemInserted(pos);
    }

    public void delete(int pos) {
        datas.remove(pos);
        notifyItemRemoved(pos);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.tv_content);
    }
}
