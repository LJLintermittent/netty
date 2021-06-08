package com.learn.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/11/23 22:27<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
public class NettyByteBuf01 {
    public static void main(String[] args) {

        ByteBuf buffer = Unpooled.buffer(10);
        for (int i = 0; i < 10; i++) {
            buffer.writeByte(i);
        }
//        for (int i = 0; i < buffer.capacity(); i++) {
//            System.out.println(buffer.getByte(i));
//        }
        for (int i = 0; i < buffer.capacity(); i++) {
            System.out.println(buffer.readByte());
        }
    }
}
