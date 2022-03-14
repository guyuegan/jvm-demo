package com.neo.jvm.theory.jmm.oom;

import java.nio.ByteBuffer;

public class DirectMemoryOOM {
    // -XX:MaxDirectMemorySize=20m
    public static void main(String[] args) {
        ByteBuffer direct = ByteBuffer.allocateDirect(21 * 1024 * 1024);
    }
}
