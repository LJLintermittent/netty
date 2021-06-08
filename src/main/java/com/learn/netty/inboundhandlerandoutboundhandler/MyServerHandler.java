package com.learn.netty.inboundhandlerandoutboundhandler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/11/24 21:57<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
public class MyServerHandler extends SimpleChannelInboundHandler<Long> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {
        System.out.println("从客户端 " + ctx.channel().remoteAddress() + "读取到long " + msg);
        ctx.writeAndFlush(51651L);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
