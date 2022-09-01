package com.yama.function;

import java.util.function.Consumer;

/**
 *public interface Consumer<T>接口
 * 特点：
 *      主要用来处理数据
 *
 * 方法解析：
 * andThen(t):
 *      返回一个Consumer实现类。相当于将传递的参数处理两次，并且每次的处理都是处理原始参数
 *
 */
public class ConsumerDemo01 {

    public static void consumerString(Consumer<String> consumer,String data){
        consumer.accept(data);
    }

    public static void dubleConsumerString(Consumer<String> consumer1,Consumer<String> consumer2){
        consumer1.andThen(consumer2).accept("name");
    }

    public static void main(String[] args) {
        //调用
        consumerString(s-> System.out.println(s),"hello");
        //调用andThen
        dubleConsumerString(
                (s)->{
                    System.out.println(s+"1");
                },
                (s)->{
                    System.out.println(s+"2");
                }
        );

    }
}
