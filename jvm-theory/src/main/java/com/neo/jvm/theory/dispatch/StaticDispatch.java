package com.neo.jvm.theory.dispatch;

/**
 * 静态分派--方法的重载--编译阶段
 * 根据变量的依赖静态类型来决定方法执行版本的分派动作，称为静态分派，
 * 因此，Java中的方法重载就是静态分派，且静态分派是在编译器就已经完成的了。
 * 运行期不会改变，所以也有把静态分派归为类加载的解析范畴的
 */
public class StaticDispatch {

    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public void sayHello(Human guy) {
        System.out.println("hello,guy!");
    }

    public void sayHello(Man guy) {
        System.out.println("hello,gentleman!");
    }

    public void sayHello(Woman guy) {
        System.out.println("hello,lady!");
    }

    public static void main(String[] args) {
        demo1();
        demo2();
    }

    // 变量本身的静态类型不会被改变，并且最终的静态类型是在编译期可知的
    private static void demo1() {
        Human man = new Man();
        Human woman = new Woman();
        //输出什么呢？
        StaticDispatch sr = new StaticDispatch();
        sr.sayHello(man);
        sr.sayHello(woman);
    }

    private static void demo2() {
        // 实际类型变化
        Human human = new Man();
        //输出什么呢？
        StaticDispatch sr = new StaticDispatch();
        sr.sayHello((Man) human);
        human = new Woman();
        sr.sayHello((Woman) human);
    }
}

