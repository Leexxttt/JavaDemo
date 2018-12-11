package com.lxt.Serializable.Singleton;

import java.io.Serializable;

/**
 * 双重校验锁的方式实现单例
 */
public class Singleton implements Serializable {

    private volatile static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    //防止序列化 反序列化破坏单例
    private Object readResolve() {
        return singleton;
    }
}
