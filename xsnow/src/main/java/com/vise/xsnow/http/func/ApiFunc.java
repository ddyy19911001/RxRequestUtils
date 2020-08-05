package com.vise.xsnow.http.func;

import android.util.Log;

import com.google.gson.Gson;
import com.vise.xsnow.http.ViseHttp;

import java.io.IOException;
import java.lang.reflect.Type;

import io.reactivex.functions.Function;
import okhttp3.ResponseBody;

/**
 * @Description: ResponseBody转T
 * @author: <a href="http://www.xiaoyaoyou1212.com">DAWI</a>
 * @date: 2017-01-05 14:39
 * 响应类
 */
public class ApiFunc<T> implements Function<ResponseBody, T> {
    private Type type;
    private String keyRequestUrl;

    public ApiFunc(Type type,String keyRequestUrl) {
        this.type = type;
        this.keyRequestUrl=keyRequestUrl;
    }

    @Override
    public T apply(ResponseBody responseBody) throws Exception {
        ViseHttp.CONFIG().timers.remove(keyRequestUrl);
        ViseHttp.CONFIG().onRequestWatingDialogListener.onRequestOverLoadingNeedClose();
        Gson gson = new Gson();
        String json;
        if(type.equals(ResponseBody.class)){
            return (T) responseBody;
        }
        try {
            json = responseBody.string();
            Log.w(ViseHttp.CONFIG().getTag(), "原始数据：\n"+json);
            if (type.equals(String.class)) {
                T obj= (T) json;
                ViseHttp.CONFIG().onInfoGet(obj);
                return obj;
            } else {
                T obj = gson.fromJson(json, type);
                ViseHttp.CONFIG().onInfoGet(obj);
                return obj;
            }
        } catch (IOException e) {
            Log.i(ViseHttp.CONFIG().getTag(), "解析出错："+e.getMessage()+","+e.getCause());
            e.printStackTrace();
        } finally {
            responseBody.close();
        }
        return null;
    }
}
