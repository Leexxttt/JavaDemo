package com.lxt.Serializable.Singleton;

import java.io.*;

public class SerializableDemo1 {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
            oos.writeObject(Singleton.getSingleton());

            File file = new File("tempFile");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Singleton newInstance = (Singleton) ois.readObject();

            //输出false
            //添加readResolve方法之后返回true
            System.out.println(newInstance == Singleton.getSingleton());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
