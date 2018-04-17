package com.yk.mytaxi;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by lenovo on 2018/4/12.
 */

public class TestOkHttp3 {

    /**
     * 测试OkHttp Get方法测试
     * */
    @Test
    public void testGet(){
        //创建OkHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        //创建Request对象
        Request request = new Request.Builder()
                .url("http://httpbin.org/get?id=id")
                .build();
        //创建Response对象
        try {
            Response response = okHttpClient.newCall(request).execute();
            System.out.println("response : " + response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试OkHttp Post方法
     * */
    @Test
    public void testPost(){

        //创建OkHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        //创建MediaType
        MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
        //创建RequestBody对象
        RequestBody requestBody = RequestBody.create(mediaType,"{\"name\" : \"FaithYK\"}");
        //创建Request对象
        Request request = new Request.Builder()
                .url("http://httpbin.org/post")
                .post(requestBody)
                .build();

        //创建Response对象
        try {
            Response response = okHttpClient.newCall(request).execute();
            System.out.println("response : " + response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试 拦截器
     * */
    @Test
    public void testInterceptor(){

        //创建Interceptor对象
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                long start = System.currentTimeMillis();
                Request request = chain.request();
                Response response = chain.proceed(request);
                long end = System.currentTimeMillis();

                System.out.println("Interceptor cost time: " + (end - start));

                return response;
            }
        };
        //创建OkHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        //创建Request对象
        Request request = new Request.Builder()
                .url("http://httpbin.org/get?id=id")
                .build();
        //创建Response对象
        try {
            Response response = okHttpClient.newCall(request).execute();
            System.out.println("response : " + response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试缓存
     * */
    @Test
    public void testCache(){

        //创建Cache对象
        Cache cache = new Cache(new File("cache.cache"),1024 * 1024);
        //创建OkHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .build();
        //创建Request对象
        Request request = new Request.Builder()
                .url("http://httpbin.org/get?id=id")
                //.cacheControl(CacheControl.FORCE_CACHE)//强制使用缓存
                .build();

        //创建Response对象
        try {
            Response response = okHttpClient.newCall(request).execute();

            Response responseCache = response.cacheResponse();
            Response responseNet = response.networkResponse();

            if (responseCache != null){
                //缓存响应
                System.out.println("response from cache");
            }else {
                System.out.println("No response!");
            }
            if (responseNet != null){
                //网络响应
                System.out.println("response from net");
            }
            System.out.println("response : " + response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
