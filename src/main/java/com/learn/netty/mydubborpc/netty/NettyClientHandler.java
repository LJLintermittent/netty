package com.learn.netty.mydubborpc.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/11/29 22:51<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {

    private ChannelHandlerContext context;
    private String result; //返回的结果
    private String param; //客户端调用方法时传入的参数
//    private static final int port = 7000;
//    private static final String host = "127.0.0.1";

    //服务器连接创立后，就会调用该方法
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive 被调用");
        context = ctx;
    }

    //收到服务器的数据后，调用该方法
    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("channelRead 被调用");
        result = msg.toString();
        notify();//唤醒等待的线程
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
//        cause.printStackTrace();
    }

    @Override
    public synchronized Object call() throws Exception {
        System.out.println("call1 被调用");
        context.writeAndFlush(param);
        wait();
        System.out.println("call2 被调用");
        return result;
    }

    void setParam(String param){
        System.out.println("setParam 被调用");
        this.param = param;
    }
}
