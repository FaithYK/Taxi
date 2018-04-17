package com.yk.mytaxi.common.http;

import java.util.Map;

/**
 * Created by lenovo on 2018/4/16.
 * 定义请求数据的封装
 */

public interface IRequset {

    public static final String GET = "GET";
    public static final String POST = "POST";

    /**
     * 定义请求方法
     * */
    void setMethod(String method);

    /**
     * 定义请求头
     * */
    void setHeader(String key,String value);

    /**
     * 定义请求体
     * */
    void setBody(String key,String value);

    /**
     * 提供给请求库的URL
     * */
    String getUrl();

    /**
     * 提供给请求库的请求头
     * */
    Map<String ,String> getHeader();

    /**
     * 提供给请求库的请求体
     * */
    Object getBody();

}
