package com.learn.netty.inboundhandlerandoutboundhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/11/25 12:50<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
public class MyByteToLongDecoder2 extends ReplayingDecoder<Void> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyByteToLongDecoder2 被调用");
        out.add(in.readLong());
    }
}
