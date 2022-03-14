package com.neo.jvm.theory.dispatch;

public class MethodTableDispatch {
    static class QQ {
    }

    static class WX {
    }

    public static class Father {
        public void hardChoice(QQ arg) {
            System.out.println("father choose qq");
        }

        public void hardChoice(WX arg) {
            System.out.println("father choose weixin");
        }
    }

    public static class Son extends Father {
        public void hardChoice(QQ arg) {
            System.out.println("son choose qq");
        }

        public void hardChoice(WX arg) {
            System.out.println("son choose weixin");
        }
    }

    // Son 重写了来自 Father 的全部方法，因此 Son 的方法表没有指向 Father 类型数据的箭头
    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new WX());
        son.hardChoice(new QQ());
    }
}
