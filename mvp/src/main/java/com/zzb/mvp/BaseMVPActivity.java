package com.zzb.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * mvp activity 基类
 * Created by ZZB on 2015/9/6.
 */
public class BaseMVPActivity extends AppCompatActivity implements MvpView{
    protected List<MvpPresenter> mPresenters = new ArrayList<>();
    /**
     *如果要实现mvp，需要实现该方法，把activity的presenter添加到mPresenters
     */
    protected void initPresenters() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenters();
        if (mPresenters != null && mPresenters.size() > 0) {
            for (MvpPresenter p : mPresenters) {
                p.attachView(this);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenters != null && mPresenters.size() > 0) {
            for (MvpPresenter p : mPresenters) {
                p.detachView(false);
            }
        }
    }
}
