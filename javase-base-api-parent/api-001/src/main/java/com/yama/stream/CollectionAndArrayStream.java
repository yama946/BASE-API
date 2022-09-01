package com.yama.stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * java.util.stream.Stream<T> 是Java 8新加入的最常用的流接口。（这并不是一个函数式接口。）
 * 获取一个流非常简单，有以下几种常用的方式：
 *          1、所有的 Collection 集合都可以通过 stream 默认方法获取流；
 *          2、Stream 接口的静态方法 of 可以获取数组对应的流。
 *          3、java.util.Map 接口不是 Collection 的子接口，且其K-V数据结构不符合流元素的单一特征，所以获取对应的流
 *              需要分key、value或entry等情况。
 *
 */
public class CollectionAndArrayStream {
    public static void main(String[] args) {
        /**
         * 根据Collection获取流
         */
        List<String> list = new ArrayList<>();
        // ...
        Stream<String> stream1 = list.stream();
        Set<String> set = new HashSet<>();
        // ...
        Stream<String> stream2 = set.stream();
        Vector<String> vector = new Vector<>();
        // ...
        Stream<String> stream3 = vector.stream();

        /**
         * 根据Map获取流
         */
        Map<String, String> map = new HashMap<>();
        // ...
        Stream<String> keyStream = map.keySet().stream();
        Stream<String> valueStream = map.values().stream();
        Stream<Map.Entry<String, String>> entryStream = map.entrySet().stream();
        /**
         * 根据数组获取流
         */
        String[] array = { "张无忌", "张翠山", "张三丰", "张一元" };
        Stream<String> stream = Stream.of(array);
    }
}
