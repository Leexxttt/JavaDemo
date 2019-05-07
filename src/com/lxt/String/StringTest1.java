package com.lxt.String;


import com.lxt.tree.BinaryTree;
import org.junit.Test;

public class StringTest1 {
//    @Test
//    public void test1(){
//        String str1 = new String();
//        System.out.println(str1);
//        String original = "acc";
//        String str2 = new String(original);
//        char[] chars = {'a','b','c'};
//        String str3 = new String(chars);
//
//        //trim()
//
//    }
//
//    public void test(){
//        String str1 = "abc";
//        String str2 = "def";
//        String str3 = "abc"+"def";
//        String newStr = str1+str2;//new StringBuilder(); StringBuilder.append(str1);StringBuilder.append(str2); StringBuilder.toString()
//        System.out.println(newStr=="abcdef");
//        System.out.println(str3=="abcdef");
//    }
//
//    public void test2(){
//        String str = "abc";
//        String newStr =  new String(str);
//    }
//
//    public void test3(){
//        String newStr =  new String("abc");
//    }
//

    public void tesst3(String str){
        switch(str){
            case "Sping":
                System.out.println("spring");
                break;
            case"Summer":
                System.out.println("summer");
                break;
        }
    }
    @Test
    public void testIntern(){
        //String中intern()方法 如果常量池存在当前字符串，则直接返回 如果不存在 则将该字符串放入常量池 再返回
        String str1 = new String("abc");
        str1.intern();
        String str2 = "abc";
        System.out.println(str1==str2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);

    }

    @Test
    public void testFormat(){
        String hi = String.format("%s", "hi");
        System.out.println(hi);

    }

    @Test
    public void testToCharArray(){
        //new 一个char数组 String实现是char数组 然后char数组拷贝
        //TODO System.arraycopy
    }
    @Test
    public void testTrim(){
        String s1 ="sdasdjak  ";
        System.out.println(s1);
        System.out.println(s1.trim());
        //实现 空格的十进制ASCII是32 最小
        /**
         *   int len = value.length;
         *         int st = 0;
         *         char[] val = value;
         *
         *while ((st < len) && (val[st] <= ' ')) {
         *st++;
         *}
         *while ((st < len) && (val[len - 1] <= ' ')) {
         *len--;
         *}
         *return ((st > 0) || (len < value.length)) ? substring(st, len) : this;
         */
        char[] val = new char[]{' ',' ','a','b',' ',' ',' '};
        int len=7;
        int st=0;
        while ((st<len)&&val[st]<=' '){
            st++;
        }
        while ((st < len) && (val[len - 1] <= ' ')) {
            len--;
         }
        System.out.println(st+"==="+len);
    }

    @Test
    public void testToUpperCase(){
        String s1="aabbcc";
        String s = s1.toUpperCase();
        try {
            Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass("BinaryTree");
            Object o = clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }
}
