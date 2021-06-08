package com.learn.nio;

import java.nio.ByteBuffer;

/**
 * Description:
 * date: 2021/6/6 19:53
 * Package: com.learn.nio
 *
 * @author 李佳乐
 * @version 1.0
 */
@SuppressWarnings("all")
public class BufferDemo {
    public static void main(String[] args) {
        System.out.println("测试nio");
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println(byteBuffer);
        byteBuffer.putInt(1);
        byteBuffer.putInt(2);
        byteBuffer.putInt(3);
        System.out.println(byteBuffer);
        /**
         * flip()
         * limit = position;
         * position = 0;
         * mark = -1;
         * 将buffer从写模式切换为读模式
         */
        byteBuffer.flip();
        /**
         * remaining()
         * limit - position;
         * 返回可读的大小
         */
        System.out.println(byteBuffer.remaining());
        System.out.println(byteBuffer);
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        System.out.println(byteBuffer);
        System.out.println(byteBuffer.remaining());
        byteBuffer.clear();
        System.out.println(byteBuffer);
        System.out.println(byteBuffer.remaining());
    }
}
