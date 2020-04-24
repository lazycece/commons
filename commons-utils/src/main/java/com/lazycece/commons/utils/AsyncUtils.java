package com.lazycece.commons.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lazycece
 * @date 2018/4/6
 */

public class AsyncUtils {

    private static AsyncUtils instance;

    private ExecutorService executorService;

    private AsyncUtils() {
        executorService = Executors.newFixedThreadPool(100);
    }

    public static AsyncUtils getInstance() {
        if (instance == null) {
            instance = new AsyncUtils();
        }
        return instance;
    }

    public void execute(Runnable runnable) {
        executorService.execute(runnable);
    }
}
