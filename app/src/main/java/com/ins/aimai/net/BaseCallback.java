package com.ins.aimai.net;

import com.google.gson.Gson;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/4/5.
 * 统一处理请求回调，提供全局功能控制，
 * 例如：
 * 返回异地登录后，强制当前用户下线
 * 账户被冻结，锁定APP
 */

public abstract class BaseCallback<T> implements Callback<ResponseBody> {

    private Gson gson = new Gson();
    private Type type;

    public BaseCallback(Type type) {
        this.type = type;
    }

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        try {
            ResponseBody body = response.body();
            if (body == null) {
                onError(0, "服務器异常：" + response.code());
                return;
            }
            String res = body.string();
            JSONTokener jsonParser = new JSONTokener(res);
            JSONObject root = (JSONObject) jsonParser.nextValue();
            int status = 0;
            String msg = "";
            String data = "";
            if (root.has("code")) {
                status = root.getInt("code");
            }
            if (root.has("msg")) {
                msg = root.getString("msg");
            }
            if (root.has("data")) {
                data = root.getString("data");
            }
            T t;
            if (data != null && !data.equals("")) {
                t = gson.fromJson(data, type);
            } else {
                t = null;
            }
            switch (status) {
                case 200:
                    onSuccess(status, t, msg);
                    break;
                case 1005:
                    onError(status, msg);
                    break;
                default:
                    onError(status, msg);
                    break;
            }
        } catch (Exception e) {
            onError(0, "未知错误");
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        onError(0, "请求失败");
    }

    abstract public void onSuccess(int status, T t, String msg);

    abstract public void onError(int status, String msg);
}
