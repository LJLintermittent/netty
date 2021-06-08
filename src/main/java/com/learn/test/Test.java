package com.learn.test;

import io.netty.util.NettyRuntime;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/11/23 18:06<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(NettyRuntime.availableProcessors());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH点mm分ss秒");
        System.out.println(simpleDateFormat.format(new Date()));
        System.out.println(LocalDateTime.now());
    }
}
