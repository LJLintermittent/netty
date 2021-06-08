package com.learn.netty.mydubborpc.consumer;

import com.learn.netty.mydubborpc.netty.NettyClient;
import com.learn.netty.mydubborpc.publicinterface.HelloService;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/11/30 11:59<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
public class ClientBootStrap {

    public static final String providerName = "HelloService#hello#";

    public static void main(String[] args) throws Exception {
        NettyClient consumer = new NettyClient();
        HelloService service = (HelloService) consumer.getBean(HelloService.class, providerName);
        for (; ; ) {
            Thread.sleep(2 * 1000);
            String res = service.hello("你好 Dubbo");
            System.out.println("调用的结果 res = " + res);
        }
    }
}
