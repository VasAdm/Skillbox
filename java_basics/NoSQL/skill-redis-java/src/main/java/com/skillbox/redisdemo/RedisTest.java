package com.skillbox.redisdemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static java.lang.System.out;

public class RedisTest {


    public static void main(String[] args) throws InterruptedException {

        RedisStorage redis = new RedisStorage();
        redis.init();

        for (int i = 0; i < 20; i++) {
            int user_id = i + 1;
            redis.logPageVisit(user_id);
        }


        while(true) {
            out.println("На главной странице показываем пользователя " + redis.getNextUser());
            Thread.sleep(1000);
        }
//        redis.shutdown();
    }
}