package com.lxt.IO.Buffer;

import org.junit.Test;

import java.nio.ByteBuffer;

public class TestBuffer {
    @Test
    public void test1() {
        /**
         * Invariants: mark <= position <= limit <= capacity
         *capacity:容量，由于Buffer的实现就是通过数组，capacity就是数组的长度
         * limit:限定 数组中可以用来操作的数据的大小的下标 limit之后的数据不可操作
         * position:位置 读写操作之后 当前定位的位置
         *  mark :用来标记position
         */
        String str = "abcde";
        ByteBuffer buffer = ByteBuffer.allocate(2048);
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        System.out.println("-----------PUT--------------");
        buffer.put(str.getBytes());
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        System.out.println("-----------mark 标记position的位置 reset恢复mark标记的位置--------------");
        buffer.mark();
        buffer.put("fg".getBytes());
        System.out.println(buffer.position());
        buffer.reset();
        System.out.println(buffer.position());


        System.out.println("-----------flip--------------");
        buffer.flip();
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        System.out.println("-----------get--------------");
        byte[] dest = new byte[buffer.limit()];
        buffer.get(dest);
        System.out.println(new String(dest,0,dest.length));
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        System.out.println("-----------rewind position置为0 可以重复读取Buffer中的数据--------------");
        buffer.rewind();
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());


        System.out.println("-----------clear position置为0 limit为capacity 数据并没有清空 还存在 --------------");
        buffer.clear();
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

    }
}
