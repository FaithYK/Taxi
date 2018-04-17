package com.yk.mytaxi.common.http.impl;

import com.yk.mytaxi.common.http.IHttpClient;
import com.yk.mytaxi.common.http.IRequset;
import com.yk.mytaxi.common.http.IResponse;

import java.io.IOException;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lenovo on 2018/4/16.
 */

public class OkHttpClientImpl implements IHttpClient {

    //创建OkHttpClient 对象
    OkHttpClient okHttpClient = new OkHttpClient.Builder().
            build();

    @Override
    public IResponse get(IRequset requset, boolean forceCache) {

        /**
         * 解析业务参数
         * */
        //指定请求方式
        requset.setMethod(IRequset.GET);
        //解析头部
        Map<String , String> header = requset.getHeader();
        //OkHttp的Request.Builder
        Request.Builder builder = new Request.Builder();
        for (String key : header.keySet()){
           //组装成的OkHttp的header
            builder.header(key,header.get(key));
        }
        //获取url
        String url = requset.getUrl();
        builder.url(url)
                .get();
        Request request = builder.build();
        //执行Request
        return execute(request);
    }

    /**
     * 请求执行过程
     * */
    private IResponse execute(Request request) {

        BaseResponse baseResponse = new BaseResponse();

        try {
            Response response = okHttpClient.newCall(request).execute();
            //状态码
            baseResponse.setCode(response.code());
            String body = response.body().string();
            //请求体
            baseResponse.setData(body);
        } catch (IOException e) {
            e.printStackTrace();
            baseResponse.setCode(baseResponse.STATE_UNKOWN_ERROR);
            baseResponse.setData(e.getMessage());
        }
        return baseResponse;
    }


    @Override
    public IResponse post(IRequset requset, boolean forceCache) {

        //指定请求方式
        requset.setMethod(IRequset.POST);
        return null;
    }
}
