package com.yama.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * stream流主要是用来优化集合或者数组的遍历操作，lambda思想：强调做什么，而不是怎么做
 *
 * filter 、 map 、 skip 等方法都是在对函数模型进行操作，集合元素并没有真正被处理。
 * 只有当终结方法 count、foreach方法执行的时候
 * 整个模型才会按照指定策略执行操作。而这得益于Lambda的延迟执行特性。
 *
 * “Stream流”其实是一个集合元素的函数模型，它并不是集合，也不是数据结构，其本身并不存储任何元素（或其地址值）
 */
public class StreamHello {
    /**
     * 要求：
     * 1. 首先筛选所有姓张的人；
     * 2. 然后筛选名字有三个字的人；
     * 3. 最后进行对结果进行打印输出。
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        //以前操作，使用多个循环，这里的循环就是怎么做的形式，我们要使用函数式编程思想优化强调作什么
        List<String> zhangList = new ArrayList<>();
        for (String name : list) {
            if (name.startsWith("张")) {
                zhangList.add(name);
            }
        }
        List<String> shortList = new ArrayList<>();
        for (String name : zhangList) {
            if (name.length() == 3) {
                shortList.add(name);
            }
        }
        for (String name : shortList) {
            System.out.println(name);
        }
        System.out.println("-------------------------分界线---------------------------------");
        //使用Stream流及进行完成
        list
                .stream()
                .filter(s->s.startsWith("张"))
                .forEach(t-> System.out.println(t));
    }
}
