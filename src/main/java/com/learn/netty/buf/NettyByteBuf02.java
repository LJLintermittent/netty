package com.learn.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/11/24 11:21<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
public class NettyByteBuf02 {
    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.copiedBuffer("hello,world! 西安", CharsetUtil.UTF_8);
        if (byteBuf.hasArray()) {
            byte[] content = byteBuf.array();
            System.out.println(new String(content, CharsetUtil.UTF_8));
            System.out.println(byteBuf);
            System.out.println(byteBuf.arrayOffset());
            System.out.println(byteBuf.readerIndex());
            System.out.println(byteBuf.writerIndex());
//            for (int i = 0; i < byteBuf.capacity(); i++) {
//                System.out.println(byteBuf.readByte());
//            }
            int len = byteBuf.readableBytes();
            for (int i = 0; i < len; i++) {
                System.out.println((char) byteBuf.getByte(i));
            }
            System.out.println(byteBuf.getCharSequence(0,6,CharsetUtil.UTF_8));
        }
    }
}
