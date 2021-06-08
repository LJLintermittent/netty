package com.learn.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/11/22 21:35<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        Thread.sleep(5000);
//        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端2",CharsetUtil.UTF_8));

        //解决方案一，用户程序自定义的普通任务
        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端2",CharsetUtil.UTF_8));
                } catch (InterruptedException e) {
                    System.out.println("发生异常： " + e.getMessage());
                }
            }
        });

        //用户自定义定时任务
        ctx.channel().eventLoop().schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端3",CharsetUtil.UTF_8));
                } catch (InterruptedException e) {
                    System.out.println("发生异常： " + e.getMessage());
                }
            }
        },5, TimeUnit.SECONDS);

        System.out.println("go on....");

//        System.out.println("服务器读取的线程：" + Thread.currentThread().getName());
//        System.out.println("server ctx : " + ctx);
//        ByteBuf buf = (ByteBuf) msg;
//        System.out.println("客户端发送的消息是：" + buf.toString(CharsetUtil.UTF_8));
//        System.out.println("客户端地址：" + ctx.channel().remoteAddress());

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端1", CharsetUtil.UTF_8));

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
