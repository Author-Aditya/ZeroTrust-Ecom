package com.dailymart.store.util;


public class PasswordUtil {

    public static boolean matches(String rawPassword, String storedPassword) {
        return rawPassword.equals(storedPassword);
    }
}