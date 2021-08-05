package com.example.mytestapplication.utils;

import com.example.mytestapplication.bean.User;

public class Constant {
    public static final ThreadLocal<User> globalThreadLocal = new ThreadLocal<>();
}
