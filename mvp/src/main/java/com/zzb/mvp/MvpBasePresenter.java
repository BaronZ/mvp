package com.zzb.mvp;

import android.content.Context;

/**
 * Created by ZZB on 2015/6/4 9:29
 */
public class MvpBasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private V mView;
    protected Context mContext;

    public MvpBasePresenter() {
    }

    public MvpBasePresenter(Context context) {
        mContext = context;
    }

    @Override
    public void attachView(V view) {
        mView = view;
    }

    @Override
    public void detachView(boolean retainInstance) {
        if (mView != null) {
            mView = null;
        }
        if (mContext != null) {
            mContext = null;
        }
    }

    /**
     * 调用这个方法的时候，需要先调用 {@link #isViewAttached()} 查看View是否存在，避免空指针
     * @return mvp view
     */
    protected V getView() {
        return mView;
    }

    /**
     * 查看View是否存在
     */
    protected boolean isViewAttached() {
        return mView != null;
    }

}
