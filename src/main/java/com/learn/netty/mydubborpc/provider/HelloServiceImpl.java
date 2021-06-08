package com.learn.netty.mydubborpc.provider;

import com.learn.netty.mydubborpc.publicinterface.HelloService;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/11/29 22:26<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
public class HelloServiceImpl implements HelloService {

    private static int count = 0;

    @Override
    public String hello(String msg) {
        System.out.println("收到客户端消息=" + msg);
        if (msg != null) {
            return "你好客户端，我已经收到你的消息[" + msg + "]第" + (++count) + "次";
        } else {
            return "你好客户端，我已经收到你的消息";
        }
    }
}
