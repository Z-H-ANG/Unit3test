package com.example.a_test;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView text01, text02, text03;

    FragmentManager fm;

    private tab_01 t1;
    private tab_02 t2;
    private tab_03 t3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        text01.setTextColor(Color.RED);

    }

    private void initview() {

        text01 = (TextView) findViewById(R.id.tv01);
        text02 = (TextView) findViewById(R.id.tv02);
        text03 = (TextView) findViewById(R.id.tv03);

        text01.setOnClickListener(this);
        text02.setOnClickListener(this);
        text03.setOnClickListener(this);

        fm = getSupportFragmentManager();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv01:
                setTabSelection(0);
                text01.setTextColor(Color.RED);

                break;

            case R.id.tv02:
                setTabSelection(1);
                text02.setTextColor(Color.RED);

                break;

            case R.id.tv03:
                setTabSelection(2);
                text03.setTextColor(Color.RED);

                break;
        }
    }

    private void setTabSelection(int index) {
        FragmentTransaction ft = fm.beginTransaction();
        hideFragment(ft);
        switch (index) {
            case 0:
                if (t1 == null) {

                    t1 = new tab_01();
                    ft.add(R.id.vp, t1);

                    text02.setTextColor(Color.BLACK);
                    text03.setTextColor(Color.BLACK);


                } else {
                    ft.show(t1);

                    text02.setTextColor(Color.BLACK);
                    text03.setTextColor(Color.BLACK);
                }
                break;

            case 1:
                if (t2 == null) {
                    t2 = new tab_02();
                    ft.add(R.id.vp, t2);

                    text01.setTextColor(Color.BLACK);
                    text03.setTextColor(Color.BLACK);
                } else
                    ft.show(t2);
                text01.setTextColor(Color.BLACK);
                text03.setTextColor(Color.BLACK);

                break;

            case 2:
                if (t3 == null) {
                    t3 = new tab_03();
                    ft.add(R.id.vp, t3);

                    text01.setTextColor(Color.BLACK);
                    text02.setTextColor(Color.BLACK);
                } else
                    ft.show(t3);

                text01.setTextColor(Color.BLACK);
                text02.setTextColor(Color.BLACK);
                break;
        }
        ft.commit();
    }

    //用于隐藏fragment
    private void hideFragment(FragmentTransaction ft){
        if(t1!=null){
            ft.hide(t1);
        }if(t2!=null){
            ft.hide(t2);
        }
        if(t3!=null){
            ft.hide(t3);
        }
    }

    private void PopupMenu(){
        findViewById(R.id.option_normal_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu=new PopupMenu(MenuActivity.this,view);//1.实例化PopupMenu
                getMenuInflater().inflate(R.menu.activity_popup_menu,popupMenu.getMenu());//2.加载Menu资源

                //3.为弹出菜单设置点击监听
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.popup_add:
                                Toast.makeText(MainActivity.this,"添加",Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.popup_delete:
                                Toast.makeText(MenuActivity.this,"删除",Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.popup_more:
                                Toast.makeText(MenuActivity.this,"更多",Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popupMenu.show();//4.显示弹出菜单
            }
        });
    }




    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu_normal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_normal_1:
                Toast.makeText(this, "下载", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.option_normal_2:
                Toast.makeText(this, "搜索", Toast.LENGTH_SHORT).show();

            default:
                return super.onOptionsItemSelected(item);
        }


    }



}



