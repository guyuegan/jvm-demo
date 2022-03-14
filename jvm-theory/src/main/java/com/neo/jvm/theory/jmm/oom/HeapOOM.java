package com.neo.jvm.theory.jmm.oom;

public class HeapOOM {
    // -Xms20m -Xmx20m
    public static void main(String[] args) {
        byte[] heap = new byte[21 * 1024 * 1024];
    }
}
