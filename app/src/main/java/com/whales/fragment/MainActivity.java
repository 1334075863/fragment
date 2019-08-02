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

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout mLr_main, mLr_other, mLr_location, mLr_myself;
    private ImageView mIv_bottom;
    private TextView mTv_bottom;
    private ImageView mIv_main, mIv_other, mIv_location, mIv_myself;
    private TextView mTv_main, mTV_other, mTv_location, mTv_myself;
    boolean isChecked;
    View mView;

    private int mainState;
    private int otherState;
    private int locationState;
    private int myselfState;

    private static final int SELECT_TAB_STATE = 1;
    private static final int UNSELECT_TAB_STATE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        setTabSelectMain();
        initClick();


        Timber.d("inttMainActivity");
    }

    private void initView() {
        mLr_main = (LinearLayout) findViewById(R.id.lr_main);
        mLr_other = (LinearLayout) findViewById(R.id.lr_other);
        mLr_location = (LinearLayout) findViewById(R.id.lr_location);
        mLr_myself = (LinearLayout) findViewById(R.id.lr_myself);
        mIv_bottom = (ImageView) findViewById(R.id.iv_bottom);
        mTv_bottom = (TextView) findViewById(R.id.tv_bottom);

        mIv_main = findViewById(R.id.iv_main);
        mIv_other = findViewById(R.id.iv_other);
        mIv_location = findViewById(R.id.iv_location);
        mIv_myself = findViewById(R.id.iv_myself);

        mTv_main = findViewById(R.id.tv_main);
        mTv_location = findViewById(R.id.tv_location);
        mTV_other = findViewById(R.id.tv_other);
        mTv_myself = findViewById(R.id.tv_myself);

    }

    private void initClick() {
        mLr_main.setOnClickListener(this);
        mLr_other.setOnClickListener(this);
        mLr_location.setOnClickListener(this);
        mLr_myself.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lr_main:
                setTabSelectMain();
                Timber.d("onClick0");
                break;
            case R.id.lr_other:
                setTabSelectOther();
                Timber.d("onClick1");
                break;
            case R.id.lr_location:
                setTabSelectLocation();
                Timber.d("onClick2 ");
                break;
            case R.id.lr_myself:
                setTabSelectMyself();
                Timber.d("onClick3  ");
                break;
        }
        showAllTabWithState();
    }

    private void changeBackground(View view) {
        if (mView == null) mView = view;

        if (!(mView == view)) {
            mView.setBackgroundColor(Color.RED);
        }
        view.setBackgroundColor(Color.BLUE);
        mView = view;
    }




    private void showAllTabWithState() {

        switch (mainState) {
            case UNSELECT_TAB_STATE:
                mIv_main.setImageResource(R.mipmap.ic_vb_home);
                mTv_main.setTextColor(Color.BLACK);
                break;
            case SELECT_TAB_STATE:
                mIv_main.setImageResource(R.mipmap.ic_vb_homet);
                mTv_main.setTextColor(Color.BLUE);
                break;
        }


        switch (otherState) {
            case UNSELECT_TAB_STATE:
                mIv_other.setImageResource(R.mipmap.ic_vb_other);
                mTV_other.setTextColor(Color.BLACK);
                break;
            case SELECT_TAB_STATE:
                mIv_other.setImageResource(R.mipmap.ic_vb_othert);
                mTV_other.setTextColor(Color.BLUE);
                break;
        }

        switch (locationState) {
            case UNSELECT_TAB_STATE:
                mIv_location.setImageResource(R.mipmap.ic_vb_location);
                mTv_location.setTextColor(Color.BLACK);
                break;
            case SELECT_TAB_STATE:
                mIv_location.setImageResource(R.mipmap.ic_vb_locationt);
                mTv_location.setTextColor(Color.BLUE);
                break;
        }

        switch (myselfState) {
            case UNSELECT_TAB_STATE:
                mIv_myself.setImageResource(R.mipmap.ic_vb_myself);
                mTv_myself.setTextColor(Color.BLACK);
                break;
            case SELECT_TAB_STATE:
                mIv_myself.setImageResource(R.mipmap.ic_vb_myselft);
                mTv_myself.setTextColor(Color.BLUE);
                break;
        }

    }

    private void setAllTabStateSelect() {
        mainState = SELECT_TAB_STATE;
        otherState = SELECT_TAB_STATE;
        locationState = SELECT_TAB_STATE;
        myselfState = SELECT_TAB_STATE;
    }

    private void setAllTabStateUnselect() {
        mainState = UNSELECT_TAB_STATE;
        otherState = UNSELECT_TAB_STATE;
        locationState = UNSELECT_TAB_STATE;
        myselfState = UNSELECT_TAB_STATE;
    }

    private void setTabSelectMain(){
        mainState = SELECT_TAB_STATE;
        otherState = UNSELECT_TAB_STATE;
        locationState = UNSELECT_TAB_STATE;
        myselfState = UNSELECT_TAB_STATE;
    }

    private void setTabSelectOther(){
        mainState = UNSELECT_TAB_STATE;
        otherState = SELECT_TAB_STATE;
        locationState = UNSELECT_TAB_STATE;
        myselfState = UNSELECT_TAB_STATE;
    }

    private void setTabSelectLocation(){
        mainState = UNSELECT_TAB_STATE;
        otherState = UNSELECT_TAB_STATE;
        locationState = SELECT_TAB_STATE;
        myselfState = UNSELECT_TAB_STATE;
    }

    private void setTabSelectMyself(){
        mainState = UNSELECT_TAB_STATE;
        otherState = UNSELECT_TAB_STATE;
        locationState = UNSELECT_TAB_STATE;
        myselfState = SELECT_TAB_STATE;
    }
}