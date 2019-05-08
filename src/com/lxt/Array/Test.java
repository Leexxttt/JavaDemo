package com.lxt.Array;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String search="http://blog.lixueteng.top/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/2019/05/01/singleton.html";
        String urlDecode = URLDecoder.decode(search, "UTF-8");
        System.out.println(urlDecode);
    }

}
