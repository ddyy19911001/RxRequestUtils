package com.vise.xsnow.base;


import com.vise.xsnow.http.callback.ACallback;

/**
 * 回调接口实现类，用于自定义接口时使用
 * @param <T>
 */
public  class MyCallBackBind<T> extends ACallback<T>{
    MyCallBackImp<T> callBackImp;

    public MyCallBackBind(MyCallBackImp<T> callBackImp) {
        this.callBackImp = callBackImp;
    }

    @Override
    public void onSuccess(T data) {
        callBackImp.onRequestSuccess(data);
    }

    @Override
    public void onFail(int errCode, String errMsg) {
        callBackImp.onRequestFail(errCode, errMsg);
    }

}
