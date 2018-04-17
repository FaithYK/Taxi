package com.yk.mytaxi.common.http.api;

/**
 * Created by lenovo on 2018/4/16.
 */

public class API {

    public static final String TEST_GET = "/get?uid=${uid}";
    public static final String TEST_POST = "/post";

    public static class Config{

        private static final String TEST_DOMAIN = "http://httpbin.org";
        private static final String RELEASE_DOMAIN = "https://httpbin.org";
        private static String domain = TEST_GET;

        public static void setDebug(boolean debug){

            domain = debug ? TEST_GET : TEST_POST;
        }

        public static String getDomain() {
            return domain;
        }
    }
}
