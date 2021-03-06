package com.hebut.triptogether.UI.Main;

import android.content.Intent;
import android.os.Bundle;

import com.hebut.triptogether.UI.Address.AddressFragment;
import com.hebut.triptogether.R;
import com.hebut.triptogether.UI.PersonalInfor.PersonalCenterFragment;
import com.hebut.triptogether.UI.PushList.ShowFragment;
import com.hebut.triptogether.UI.Route.Route;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements OnClickListener {
    // 底部菜单4个Linearlayout
    private LinearLayout ll_home;
    private LinearLayout ll_address;
    private LinearLayout ll_friend;
    private LinearLayout ll_setting;

    // 底部菜单4个ImageView
    private ImageView iv_home;
    private ImageView iv_address;
    private ImageView iv_friend;
    private ImageView iv_setting;

    // 底部菜单4个菜单标题
    private TextView tv_home;
    private TextView tv_address;
    private TextView tv_friend;
    private TextView tv_setting;

    // 4个Fragment
    private Fragment homeFragment;
    private Fragment addressFragment;
    private Fragment routeFragment;
    private Fragment settingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化控件
        initView();
        // 初始化底部按钮事件
        initEvent();
        // 初始化并设置当前Fragment
        initFragment(0);

    }

    @Override
    protected void onResume() {
        int id = getIntent().getIntExtra("userloginflag", 0);
        if (id == 1 ) {
            /*FragmentManager fragmentManager = getSupportFragmentManager();
            // 开启事务
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            routeFragment = new Route();
            transaction.replace(R.id.fl_content,routeFragment);
            transaction.commit();*/
            restartBotton();
            tv_friend.setTextColor(0xff1B940A);
            initFragment(2);

            //transaction.add(R.id.fl_content, routeFragment);
            //3代表”我的京东“所在条目的位置，参考下面的源码即可理解
        }
        super.onResume();
    }

    private void initFragment(int index) {
        // 由于是引用了V4包下的Fragment，所以这里的管理器要用getSupportFragmentManager获取
        FragmentManager fragmentManager = getSupportFragmentManager();
        // 开启事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 隐藏所有Fragment
        hideFragment(transaction);
        switch (index) {
            case 0:
                if (homeFragment == null) {

                    homeFragment = new ShowFragment();
                    transaction.add(R.id.fl_content, homeFragment);
                } else {
                    transaction.show(homeFragment);
                }
                break;
            case 1:
                if (addressFragment == null) {
                    addressFragment = new AddressFragment();
                    transaction.add(R.id.fl_content, addressFragment);
                } else {
                    transaction.show(addressFragment);
                }

                break;
            case 2:
                if (routeFragment == null) {
                    routeFragment = new Route();
                    transaction.add(R.id.fl_content, routeFragment);
                } else {
                    transaction.show(routeFragment);
                }

                break;
            case 3:
                if (settingFragment == null) {
                    settingFragment = new PersonalCenterFragment();
                    transaction.add(R.id.fl_content, settingFragment);
                } else {
                    transaction.show(settingFragment);
                }

                break;

            default:
                break;
        }

        // 提交事务
        transaction.commit();

    }

    //隐藏Fragment
    private void hideFragment(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (addressFragment != null) {
            transaction.hide(addressFragment);
        }
        if (routeFragment != null) {
            transaction.hide(routeFragment);
        }
        if (settingFragment != null) {
            transaction.hide(settingFragment);
        }

    }

    private void initEvent() {
        // 设置按钮监听
        ll_home.setOnClickListener(this);
        ll_address.setOnClickListener(this);
        ll_friend.setOnClickListener(this);
        ll_setting.setOnClickListener(this);

    }

    private void initView() {

        // 底部菜单4个Linearlayout
        this.ll_home = (LinearLayout) findViewById(R.id.ll_home);
        this.ll_address = (LinearLayout) findViewById(R.id.ll_address);
        this.ll_friend = (LinearLayout) findViewById(R.id.ll_friend);
        this.ll_setting = (LinearLayout) findViewById(R.id.ll_setting);

        // 底部菜单4个ImageView
        this.iv_home = (ImageView) findViewById(R.id.iv_home);
        this.iv_address = (ImageView) findViewById(R.id.iv_address);
        this.iv_friend = (ImageView) findViewById(R.id.iv_friend);
        this.iv_setting = (ImageView) findViewById(R.id.iv_setting);

        // 底部菜单4个菜单标题
        this.tv_home = (TextView) findViewById(R.id.tv_home);
        this.tv_address = (TextView) findViewById(R.id.tv_address);
        this.tv_friend = (TextView) findViewById(R.id.tv_friend);
        this.tv_setting = (TextView) findViewById(R.id.tv_setting);

    }

    @Override
    public void onClick(View v) {

        // 在每次点击后将所有的底部按钮(ImageView,TextView)颜色改为灰色，然后根据点击着色
        restartBotton();
        // ImageView和TetxView置为绿色，页面随之跳转
        switch (v.getId()) {
            case R.id.ll_home:
                //iv_home.setImageResource(R.mipmap.tuijian);
                //iv_address.setImageResource(R.mipmap.address);
                //iv_friend.setImageResource(R.mipmap.createtask_fill);
                //iv_setting.setImageResource(R.mipmap.set);
                tv_home.setTextColor(0xff1B940A);
                initFragment(0);
                break;
            case R.id.ll_address:
                //iv_address.setImageResource(R.mipmap.address);
                tv_address.setTextColor(0xff1B940A);
                initFragment(1);
                break;
            case R.id.ll_friend:
                //iv_friend.setImageResource(R.mipmap.createtask_fill);
                tv_friend.setTextColor(0xff1B940A);
                initFragment(2);
                break;
            case R.id.ll_setting:
                //iv_setting.setImageResource(R.mipmap.set);
                tv_setting.setTextColor(0xff1B940A);
                initFragment(3);
                break;

            default:
                break;
        }

    }

    private void restartBotton() {
        // ImageView置为灰色
        iv_home.setImageResource(R.drawable.tab_tuijian_normal);
        iv_address.setImageResource(R.drawable.tab_address_normal);
        iv_friend.setImageResource(R.drawable.tab_xingcheng_normal);
        iv_setting.setImageResource(R.drawable.tab_settings_normal);
        // TextView置为白色
        tv_home.setTextColor(0xffffffff);
        tv_address.setTextColor(0xffffffff);
        tv_friend.setTextColor(0xffffffff);
        tv_setting.setTextColor(0xffffffff);
    }

}