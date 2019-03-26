package com.lxt.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileNIO {

    public static void main(String[] args) throws IOException {
        String infile = "infile.txt";
        String outfile = "outfile.txt";
        FileInputStream inputStream = new FileInputStream("infile.txt");
        FileOutputStream outputStream = new FileOutputStream("outfile.txt");
        //从FileInputStream中获取channel
        FileChannel fcin = inputStream.getChannel();
        FileChannel fcon = outputStream.getChannel();
        //创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //将数据从通道读取到缓冲区
        while(true){
            //重设缓冲区，使它可以接受读入的数据
            buffer.clear();
            //从输入通道中将数据读取到缓冲区
            int result = fcin.read(buffer);
            if(result==-1){
                break;
            }
            //flip方法让缓冲区可以将新读入的数据写入另一个通道
            buffer.flip();
            fcon.write(buffer);
        }

    }
}
