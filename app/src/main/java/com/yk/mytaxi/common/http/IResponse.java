package com.yk.mytaxi.common.http;

/**
 * Created by lenovo on 2018/4/16.
 */

public interface IResponse {

    //状态码
    int getCode();

    //请求体
    String getData();

}
