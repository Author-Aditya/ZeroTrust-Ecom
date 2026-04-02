package com.dailymart.store.util;


import java.time.LocalDateTime;

public class DateUtil {

    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    public static LocalDateTime plusMinutes(int minutes) {
        return LocalDateTime.now().plusMinutes(minutes);
    }
}