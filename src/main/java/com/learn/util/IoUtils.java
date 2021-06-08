package com.learn.util;


import java.io.*;
import java.util.concurrent.*;

/**
 * Description:
 * date: 2021/6/6 20:21
 * Package: com.learn.util
 *
 * @author 李佳乐
 * @version 1.0
 */
@SuppressWarnings("all")
public class IoUtils {
    private static final String HTTP_SEPARATOR = "\r\n";
    public static final int DEFAULT_PORT = 8888;
    public static final int BACK_LOG = 1024;

    public static String buildHttpResp() {
        StringBuilder stringBuilder = new StringBuilder();
        String str = "<h1>xyzxyzxyzxyzxyz</h1>";
        stringBuilder.append("HTTP/1.1 200 OK").append(HTTP_SEPARATOR);
        stringBuilder.append("connection: Close").append(HTTP_SEPARATOR);
        stringBuilder.append("content-type: text/html").append(HTTP_SEPARATOR);
        stringBuilder.append("content-length: " + str.length()).append(HTTP_SEPARATOR);
        stringBuilder.append(HTTP_SEPARATOR);
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    /**
     * int corePoolSize,
     * int maximumPoolSize,
     * long keepAliveTime,
     * TimeUnit unit,
     * BlockingQueue<Runnable> workQueue,
     * ThreadFactory threadFactory,
     * RejectedExecutionHandler handler
     */
    public static ThreadPoolExecutor buildThreadPoolExecutor() {
        return new ThreadPoolExecutor(100,
                100,
                0,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public static BufferedWriter buildBufferedWriter(OutputStream outputStream) {
        return new BufferedWriter(new OutputStreamWriter(outputStream));
    }

    public static BufferedReader buildBufferedReader(InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    public static void deSomeWork() throws InterruptedException {
        Thread.sleep(500);
    }
}
