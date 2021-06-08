package com.learn.netty.protocoltcp;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/11/25 18:21<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
public class MessageProtocol {
    private int len;
    private byte[] content;

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
