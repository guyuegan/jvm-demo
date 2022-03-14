package com.neo.jvm.theory.dispatch;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleDemo {

    static class Bike {
        String who() {
            return "我是自行车";
        }
    }

    static class Animal {
        String who() {
            return "我是动物";
        }
    }

    static class Man extends Animal {
        @Override
        String who() {
            return "我是高级动物-人";
        }
    }

    /**
     * 在Java从最初发布时就支持反射，通过反射可以在运行时获取类型信息，但其有个缺点就是执行速度较慢。
     * 于是从Java 7开始提供了另一套API MethodHandle 。其与反射的作用类似，可以在运行时访问类型信息，
     * 但是据说其执行效率比反射更高，也被称为Java的 现代化反射。
     */

    public static void main(String[] args) throws Throwable {
        System.out.println(who(new Bike()));
        System.out.println(who(new Animal()));
        System.out.println(who(new Man()));
    }

    private static String who(Object obj) throws Throwable {
        //方法句柄--工厂方法Factory
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        //方法类型表示接受的参数和返回类型（第一个参数是返回参数）,这里是toString()的签名
        MethodType methodType = MethodType.methodType(String.class);
        //拿到具体的MethodHandle(findVirtual相当于字节码)
        MethodHandle methodHandle = lookup.findVirtual(obj.getClass(), "who", methodType);
        return (String) methodHandle.invoke(obj);
    }

}
