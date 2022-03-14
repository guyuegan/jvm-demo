package com.neo.jvm.theory.jmm.oom;

public class StackOverFlow {
    // 默认虚拟机栈大小1m (-Xss1m)
    public static void main(String[] args) {
        f();
    }

    // 死递归：不停压入栈帧
    private static void f() {
        f();
    }
}
