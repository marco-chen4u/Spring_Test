package com.marco.petclinic.utils;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

public class Utils {

    public static long getRandomID() {
        return RandomUtils.nextLong();
    }

    public static Integer getRandomIntID() {
        return RandomUtils.nextInt();
    }
}
