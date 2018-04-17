package com.wwwy.liuxing.message.util;

import java.util.Random;

/**
 * Created by Administrator on 2018/4/13.
 */
public class RandomNumUtil {
    public static String num;
    private static Random random = new Random();

    public static String getRand() {
        num="";
        for (int i = 1; i < 7; i++) {
            String index = random.nextInt(10) + "";
            num += index;
        }
        return num;
    }

    public static void main(String[] args) {
        String rand = getRand();
        String rand1 = getRand();
        System.out.println("rand=="+rand);
        System.out.println("rand1=="+rand1);
        System.out.println(num);
    }
}
