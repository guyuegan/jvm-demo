package com.neo.jvm.theory.jmm.constantpool;

public class internTest {
    public static void main(String[] args) {
        String s1 = new String("abc").intern();
        String s2 = new String("abc").intern();
        System.out.println(s1 == s2);
    }
}
