package com.yama.function;

import java.util.Objects;
import java.util.function.Function;

/**
 * java.util.function.Function<T,R> 接口用来根据一个类型的数据得到另一个类型的数据，前者称为前置条件，后者称为后置条件。
 *
 * 方法解析：
 *       R apply(T t) ，根据类型T的参数获取类型R的结果。
 *       使用的场景例如：将 String 类型转换为 Integer 类型。
 *       compose与andThen，都是将处理结果返回继续处理。
 *
 */
public class FunctionDemo01 {
    public static Integer transferTypeMethod(Function<String,Integer> function){
        return function.apply("123");
    }

    public static void main(String[] args) {
        Object num = transferTypeMethod(t-> Integer.valueOf(t));
        System.out.println(num instanceof Integer);


    }
}
