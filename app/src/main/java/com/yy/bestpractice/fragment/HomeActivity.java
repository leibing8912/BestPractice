package com.yy.bestpractice.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.yy.bestpractice.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    // 创建button对象
    private Button ManBtn;
    private Button WomanBtn;
    // 创建fragment对象
    private FragmentMan fragmentMan;
    private FragmentWoman fragmentWoman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //绑定ID
        bangID();

    }

    private void bangID() {
        ManBtn = findViewById(R.id.man_tv);
        WomanBtn = findViewById(R.id.woman_tv);
        ManBtn.setOnClickListener(this);
        WomanBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.man_tv:
                // 判断fragmentMan是否为空，无则创建fragment对象
                if (fragmentMan == null) {
                    fragmentMan = new FragmentMan();
                }
                // 创建FragmentManager对象
                FragmentManager manager = getFragmentManager();
                // 创建FragmentTransaction事务对象
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                // 使用replace（将要替换位置的i的，替换的页面）方法实现页面的替换
                fragmentTransaction.replace(R.id.shop_content, fragmentMan);
                // 提交事务
                fragmentTransaction.commit();
                break;
            case R.id.woman_tv:
                if (fragmentWoman == null) {
                    fragmentWoman = new FragmentWoman();
                }
                FragmentManager manager1 = getFragmentManager();
                FragmentTransaction fragmentTransaction1 = manager1.beginTransaction();
                fragmentTransaction1.replace(R.id.shop_content, fragmentWoman);
                fragmentTransaction1.commit();
                break;
            default:
                break;
        }
    }
}
