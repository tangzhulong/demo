package tangzhulong.org.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import tangzhulong.org.recyclerviewdemo.adapter.MyRecyclerAdapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> datas = new ArrayList<String>();
    private MyRecyclerAdapter myRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        initData();
        recyclerView.setAdapter(myRecyclerAdapter=new MyRecyclerAdapter(datas, getApplicationContext()));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initData() {
        for (int i = 'A'; i <= 'z'; i++) {
            datas.add("" + (char) i);
        }
    }

    private void findView() {
        recyclerView = findViewById(R.id.recycler_view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case  R.id.action_add:
                myRecyclerAdapter.add(2);
                break;
            case  R.id.action_delete:
                myRecyclerAdapter.delete(2);
                break;
            case R.id.action_gridview:
                recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
                break;
            case R.id.action_listview:
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.action_staggered:
                recyclerView.setLayoutManager(
                        new StaggeredGridLayoutManager(5,
                                StaggeredGridLayoutManager.VERTICAL));
                break;
            case R.id.action_horizontal_grid:
                recyclerView.setLayoutManager(
                        new GridLayoutManager(this,6,
                                GridLayoutManager.HORIZONTAL,false));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
