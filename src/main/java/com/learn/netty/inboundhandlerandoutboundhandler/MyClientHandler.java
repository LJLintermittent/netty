package com.learn.netty.inboundhandlerandoutboundhandler;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/11/24 22:04<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
public class MyClientHandler extends SimpleChannelInboundHandler<Long> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {
        System.out.println("服务器的ip：" + ctx.channel().remoteAddress());
        System.out.println("收到服务器的消息：" + msg);

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyClientHandler 发送数据");
//        ctx.writeAndFlush(Unpooled.copiedBuffer());
        ctx.writeAndFlush(123456L);
//        ctx.writeAndFlush(Unpooled.copiedBuffer("abcdabcdabcdabcd", CharsetUtil.UTF_8));
    }
}
