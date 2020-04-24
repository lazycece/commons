package com.lazycece.commons.utils;

import java.util.Random;

/**
 * @author lazycece
 * @date 2018/4/5
 */
public class RandomUtils {

    private static final Random random = new Random();


    public static int randomInt() {
        return random.nextInt();
    }

    /**
     * @param number int
     * @return value between 0 and number
     */
    public static int randomInt(int number) {
        return random.nextInt(number);
    }

    /**
     * init a int value between min and max
     *
     * @param min min value
     * @param max max value
     * @return value
     */
    public static int randomInt(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}
