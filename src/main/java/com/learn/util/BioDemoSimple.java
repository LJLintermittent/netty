package com.learn.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static com.learn.util.IoUtils.*;
import static com.learn.util.IoUtils.buildHttpResp;

/**
 * Description:
 * date: 2021/6/6 20:57
 * Package: com.learn.util
 *
 * @author 李佳乐
 * @version 1.0
 */
@SuppressWarnings("all")
public class BioDemoSimple {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(DEFAULT_PORT, BACK_LOG, null);
        System.out.println("服务器启动");
        for (; ; ) {
            Socket socket = serverSocket.accept();
            System.out.println(socket.getRemoteSocketAddress());
            OutputStream outputStream = socket.getOutputStream();
            BufferedWriter bufferedWriter = buildBufferedWriter(outputStream);
            deSomeWork();
            bufferedWriter.write(buildHttpResp());
            bufferedWriter.flush();
        }
    }
}

