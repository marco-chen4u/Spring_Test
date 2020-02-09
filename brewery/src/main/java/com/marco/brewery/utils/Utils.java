package com.marco.brewery.utils;

import org.apache.commons.lang3.RandomUtils;

public class Utils {

    public static long getRandomValue() {
        return RandomUtils.nextLong();
    }

    public static Integer getRandomIntValue() {
        return RandomUtils.nextInt();
    }
}
