package com.learn.netty.inboundhandlerandoutboundhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/11/24 22:02<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
public class MyLongToByteEncoder extends MessageToByteEncoder<Long> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {
        System.out.println("MyLongToByteEncoder encode 方法被调用");
        System.out.println("msg = " + msg);
        out.writeLong(msg);
    }
}
