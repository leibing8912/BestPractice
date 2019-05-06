package com.yy.bestpractice.regionzoom;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.yy.bestpractice.R;

/**
 * 演示点击区域放大
 * add by leibing
 */
public class RegionZoomActivity extends AppCompatActivity {
    private final static String TAG = "RegionZoomActivity";
    Button btn_click;
    LinearLayout ly_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region_zoom);
        ly_container = (LinearLayout) findViewById(R.id.ly_container);
        btn_click = (Button) findViewById(R.id.btn_click);
        ly_container.post(new Runnable() {
            @Override
            public void run() {
                btn_click.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.v(TAG, "#onClick v = " + v);
                    }
                });
                // 扩大控件点击范围
                // 1、设置 ImageButton 可点击的范围
                Rect delegateArea = new Rect();
                btn_click.getHitRect(delegateArea);

                // Extend the touch area of the button beyond its bound on the right and bottom
                // 2、扩大 ImageButton 的点击范围
                delegateArea.right += 500;
                delegateArea.bottom += 500;

                // Instantiate a TouchDelegate
                // 3、实例化 TouchDelegate
                TouchDelegate touchDelegate = new TouchDelegate(delegateArea, btn_click);

                // Sets the TouchDelegate on the parent view, such that touches within the touch delegate
                // are routed to the child.
                ///4、将 touchDelegate 设置到 ImageButton 的父视图上。
                if (View.class.isInstance(btn_click.getParent())) {
                    ((View) btn_click.getParent()).setTouchDelegate(touchDelegate);
                }
            }
        });
    }
}
