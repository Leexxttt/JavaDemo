package com.lxt.Serializable;

import java.io.*;

public class SerializableDemo3 {

    public static void main(String[] args) throws IOException {
        Person2 p1 = new Person2();
        p1.setName("lxxx");
        p1.setAge(18);
        p1.setAddress("shanghai");
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
        //反序列化
        File file =new File("tempFile");
        ObjectInputStream ois =null;
        try {
            ois=new ObjectInputStream(new FileInputStream(file));
            Person2 newP=(Person2)ois.readObject();
            System.out.println(newP);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            ois.close();
            file.deleteOnExit();
        }

    }
}
