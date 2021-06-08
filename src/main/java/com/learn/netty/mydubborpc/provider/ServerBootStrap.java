package com.learn.netty.mydubborpc.provider;

import com.learn.netty.mydubborpc.netty.NettyServer;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/11/29 22:27<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
public class ServerBootStrap {
    public static void main(String[] args) {
        NettyServer.serverStart("127.0.0.1",7000);
    }
}
