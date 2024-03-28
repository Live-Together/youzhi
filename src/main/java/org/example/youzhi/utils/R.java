package org.example.youzhi.utils;

import java.util.HashMap;

public class R extends HashMap<String, Object> {

    private static final String CODE_TAG = "code";
    private static final String MSG_TAG = "msg";
    private static final String DATA_TAG = "data";

    R(){
        super();
    }

    R(int code, String msg){
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    R(int code, String msg, Object data){
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if(data != null){
            super.put(DATA_TAG, data);
        }
    }

    public static R success(String msg, Object data){
        return new R(200, msg, data);
    }

    public static R success(){
        return new R(200, null, null);
    }

    public static R error(){
        return new R(500, null, null);
    }
    public static R error(String msg, Object data){
        return new R(500, msg, data);
    }
}
