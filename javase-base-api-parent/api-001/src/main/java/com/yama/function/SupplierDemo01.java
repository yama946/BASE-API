package com.yama.function;

import java.util.function.Supplier;

/**
 * public interface Supplier<T>接口函数
 * 作用：
 *          T get();主要用来生产数据
 */
public class SupplierDemo01 {
    public static String getString(Supplier<String> supplier){
        return supplier.get();
    }

    public static void main(String[] args) {
        String a = "这是哪里?\n";
        String b = "这是一个地方";
        String str = getString(() -> a + b);
        System.out.println(str);
    }
}
