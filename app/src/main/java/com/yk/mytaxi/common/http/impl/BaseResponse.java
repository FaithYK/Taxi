package com.yk.mytaxi.common.http.impl;

import com.yk.mytaxi.common.http.IResponse;

/**
 * Created by lenovo on 2018/4/16.
 */

public class BaseResponse implements IResponse {

    public static final int STATE_UNKOWN_ERROR = 100001;
    public static final int STATE_OK = 200;

    //状态码
    private int code;
    //响应数据
    private String data;


    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(String data) {
        this.data = data;
    }
}
