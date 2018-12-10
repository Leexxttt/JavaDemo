package com.lxt.Serializable;

import java.io.*;

public class SerializableDemo4 {

    public static void main(String[] args) throws IOException {
        /**
         * 现将信息系列化到文件中 然后去掉serialVersionUID 再进行反序列化
         */
        Person3 p1 = new Person3();
        p1.setName("lxxx");
        p1.setAge(18);
        System.out.println(p1);
        //将对象写入文件中
        ObjectOutputStream oss =null;
        try {
            oss=new ObjectOutputStream(new FileOutputStream("tempFile"));
            oss.writeObject(p1);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            oss.close();
        }
    }
}
