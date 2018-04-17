package com.yk.mytaxi.common.http;

import com.yk.mytaxi.common.http.IRequset;
import com.yk.mytaxi.common.http.IResponse;

/**
 * Created by lenovo on 2018/4/16.
 */

public interface IHttpClient {

    IResponse get(IRequset requset,boolean forceCache);
    IResponse post(IRequset requset,boolean forceCache);
}
