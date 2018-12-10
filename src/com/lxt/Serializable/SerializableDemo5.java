package com.lxt.Serializable;

import java.io.*;

public class SerializableDemo5 {

    public static void main(String[] args) throws IOException {
        //反序列化
        File file =new File("tempFile");
        ObjectInputStream ois =null;
        try {
            ois=new ObjectInputStream(new FileInputStream(file));
            Person3 newP=(Person3)ois.readObject();
            System.out.println(newP);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            ois.close();
            file.deleteOnExit();
        }

    }
}
