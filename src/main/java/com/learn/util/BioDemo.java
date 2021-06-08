package com.learn.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ThreadPoolExecutor;

import static com.learn.util.IoUtils.*;

/**
 * Description:
 * date: 2021/6/6 20:41
 * Package: com.learn.bio
 *
 * @author 李佳乐
 * @version 1.0
 */
@SuppressWarnings("all")
public class BioDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(DEFAULT_PORT, BACK_LOG, null);
        System.out.println("服务器启动");
        ThreadPoolExecutor threadPoolExecutor = buildThreadPoolExecutor();
        for (; ; ) {
            Socket socket = serverSocket.accept();
            threadPoolExecutor.execute(() -> {
                OutputStream outputStream;
                BufferedWriter bufferedWriter;
                try {
                    System.out.println(socket.getRemoteSocketAddress());
                    outputStream = socket.getOutputStream();
                    bufferedWriter = buildBufferedWriter(outputStream);
                    deSomeWork();
                    bufferedWriter.write(buildHttpResp());
                    bufferedWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
