package com.vise.xsnow.http.func;

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

    public ApiFunc(Type type) {
        this.type = type;
    }

    @Override
    public T apply(ResponseBody responseBody) throws Exception {
        Gson gson = new Gson();
        String json;
        try {
            json = responseBody.string();
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
            e.printStackTrace();
        } finally {
            responseBody.close();
        }
        return null;
    }
}
