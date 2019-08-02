package com.whales.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.whales.fragment.base.BaseActivity;

import timber.log.Timber;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private LinearLayout mLr_main,mLr_other,mLr_location,mLr_myself;
    private ImageView mIv_bottom;
    private TextView mTv_bottom;
    private ImageView mIv_main,mIv_other,mIv_location,mIv_myself;
    boolean isChecked;
    View mView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        initClick();
        Timber.d("inttMainActivity");
    }

    private void initView(){
        mLr_main = (LinearLayout)findViewById(R.id.lr_main);
        mLr_other = (LinearLayout)findViewById(R.id.lr_other);
        mLr_location = (LinearLayout)findViewById(R.id.lr_location);
        mLr_myself = (LinearLayout)findViewById(R.id.lr_myself);
        mIv_bottom = (ImageView)findViewById(R.id.iv_bottom);
        mTv_bottom = (TextView)findViewById(R.id.tv_bottom);

        mIv_main = findViewById(R.id.iv_main);
        mIv_other = findViewById(R.id.iv_other);
        mIv_location = findViewById(R.id.iv_location);
        mIv_myself = findViewById(R.id.iv_myself);

    }

    private void initClick(){
        mLr_main.setOnClickListener(this);
        mLr_other.setOnClickListener(this);
        mLr_location.setOnClickListener(this);
        mLr_myself.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lr_main:
                Timber.d("onClick0");
                setBackground(v);
                break;
            case R.id.lr_other:
                setBackground(v);
                Timber.d("onClick1");
                break;
            case R.id.lr_location:
                setBackground(v);
                Timber.d("onClick2 ");
                break;
            case R.id.lr_myself:
                Timber.d("onClick3  ");
                break;
        }
    }

    private void changeBackground(View view){
        if (mView == null) mView = view;

        if (!(mView == view)){
            mView.setBackgroundColor(Color.RED);
        }
        view.setBackgroundColor(Color.BLUE);
        mView = view;
    }

    private void setBackground(View view){
        if (view.getId()==R.id.lr_main){
            mIv_main.setImageResource(R.mipmap.ic_vb_homet);
        }else if (view.getId()==R.id.lr_other){
            mIv_other.setImageResource(R.mipmap.ic_vb_othert);
        }else if (view.getId()==R.id.lr_location){
            mIv_location.setImageResource(R.mipmap.ic_vb_locationt);
        }else if (view.getId()==R.id.lr_myself){
            mIv_myself.setImageResource(R.mipmap.ic_vb_myselft);
        }
    }

}
