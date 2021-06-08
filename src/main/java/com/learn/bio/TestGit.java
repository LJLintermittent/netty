package com.learn.bio;

import java.sql.SQLOutput;
import java.util.HashMap;

/**
 * Description:
 * date: 2021/6/8 22:42
 * Package: com.learn.bio
 *
 * @author 李佳乐
 * @version 1.0
 */
public class TestGit {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>(10);
        hashMap.put("1", 1);
        hashMap.put("2", 2);
        hashMap.put("3", 3);
        hashMap.put("4", 4);
//        System.out.println(hashMap.size());
        for (int i = 1; i <= hashMap.size(); i++) {
            System.out.println(hashMap.get(i + ""));
        }
    }
}
