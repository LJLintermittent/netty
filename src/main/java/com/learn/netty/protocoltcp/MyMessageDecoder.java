package com.learn.netty.protocoltcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/11/25 18:37<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
public class MyMessageDecoder extends ReplayingDecoder<Void> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyMessageDecoder decode方法被调用");
        int length = in.readInt();
        byte[] content = new byte[length];
        in.readBytes(content);
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLen(length);
        messageProtocol.setContent(content);
        out.add(messageProtocol);
    }
}
