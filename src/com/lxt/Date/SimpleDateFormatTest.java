package com.lxt.Date;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleDateFormatTest {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static Date parseStr(String dateStr) throws ParseException {
        return sdf.parse(dateStr);
    }

    @Test
    public void test1() {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 10; j++) {
                    try {
                        System.out.println(parseStr("2013-09-22 00:00:00").getTime());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
    }

    /**
     * 不使用static
     */
    @Test
    public void test2() {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 10; j++) {
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        System.out.println(sdf.parse("2013-09-22 00:00:00").getTime());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
    }

    /**
     * 使用synchronized关键字
     */
    @Test
    public void test3() {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 10; j++) {
                    try {
                        synchronized (SimpleDateFormatTest.class) {
                            System.out.println(sdf.parse("2013-09-22 00:00:00").getTime());
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
    }

    /**
     * 使用ThreadLocal
     */
    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    @Test
    public void test4() {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 10; j++) {
                    try {
                        System.out.println(threadLocal.get().parse("2013-09-22 00:00:00").getTime());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
    }

    /**
     * 使用DateTimeFormatter
     * TODO 为什么DateTimeFormatter是线程安全的
     */
    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Test
    public void test5() {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 10; j++) {
                    System.out.println(LocalDate.now().format(dtf));
                }
            });
        }
        executorService.shutdown();
    }
}
