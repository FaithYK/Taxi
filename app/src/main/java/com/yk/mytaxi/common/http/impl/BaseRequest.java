package com.yk.mytaxi.common.http.impl;

import com.google.gson.Gson;
import com.yk.mytaxi.common.http.IRequset;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2018/4/16.
 */

public class BaseRequest implements IRequset {

    private String method = POST;
    private String url;
    private Map<String,String> header;
    private Map<String,Object> body;

    public BaseRequest(String url) {
        this.url = url;

        header = new HashMap<>();
        body = new HashMap<>();
        header.put("application-Id","myTaxiID");
        header.put("application-Key","myTaxiKey");
    }

    @Override
    public void setMethod() {
        this.method = method;
    }

    @Override
    public void setHeader(String key, String value) {
        header.put(key,value);
    }

    @Override
    public void setBody(String key, String value) {
        body.put(key,value);
    }


    @Override
    public String getUrl() {

        if (GET.equals(method)){
            //组织 Get请求参数
            for (String key : body.keySet()){
                url = url.replace("${" + key + "}",body.get(key).toString());
            }
        }
        return url;
    }

    @Override
    public Map<String, String> getHeader() {
        return header;
    }

    @Override
    public Object getBody() {
        if (body != null){

            return new Gson().toJson(this.body,HashMap.class);
        }else {
            return "{}";
        }
    }
}
