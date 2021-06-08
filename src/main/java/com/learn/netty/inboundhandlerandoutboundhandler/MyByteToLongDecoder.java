package com.learn.netty.inboundhandlerandoutboundhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/11/24 21:55<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
public class MyByteToLongDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyByteToLongDecoder 被调用");
        if (in.readableBytes() >= 8){
            out.add(in.readLong());
        }
    }
}
