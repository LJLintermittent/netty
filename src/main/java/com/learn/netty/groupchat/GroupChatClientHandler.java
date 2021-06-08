package com.learn.netty.groupchat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/11/24 12:29<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
public class GroupChatClientHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg.trim());
    }
}
