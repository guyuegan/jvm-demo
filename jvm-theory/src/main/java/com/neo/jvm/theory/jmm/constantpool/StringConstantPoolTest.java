package com.neo.jvm.theory.jmm.constantpool;

public class StringConstantPoolTest {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = "a"+"b"+"c";
        String s4 = s2.intern();
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);

        System.out.println(s2 == s3);
        System.out.println(s2 == s4);

        System.out.println(s3 == s4);
    }
}
