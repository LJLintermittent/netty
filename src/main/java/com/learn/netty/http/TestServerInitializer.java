package com.learn.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/11/23 20:08<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("myHttpServerCodec",new HttpServerCodec());
        pipeline.addLast("myTestHttpServerHandler",new TestHttpServerHandler());
//        System.out.println("ok");

    }
}
