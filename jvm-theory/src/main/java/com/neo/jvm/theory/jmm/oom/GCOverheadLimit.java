package com.neo.jvm.theory.jmm.oom;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * JVM花费了98%的时间进行垃圾回收，而只得到2%可用的内存，
 * 频繁的进行内存回收(最起码已经进行了5次连续的垃圾回收)，
 * JVM就会曝出java.lang.OutOfMemoryError: GC overhead limit exceeded错误
 */
// https://zhuanlan.zhihu.com/p/88956975
public class GCOverheadLimit {
    // -Xms20m -Xmx20m
    public static void main(String[] args) throws InterruptedException {
        List<Object> list = new LinkedList<>();
        int i = 0;
        while (true) {
            i++;
            if (i % 1000 == 0)
                TimeUnit.MILLISECONDS.sleep(20);
            list.add(new Object());
        }
    }
}
