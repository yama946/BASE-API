package com.yama.stream;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 中间操作（延迟方法）：返回Stream流，支持链式调用
 * 最终操作（终结方法）：不再返回Stream流，开始执行之前的中间操作进行计算结果。
 *
 * Stream流中常用方法：
 *
 * 1、  void forEach(Consumer<? super T> action);最终操作
 *          该方法接收一个 Consumer 接口函数，会将每一个流元素交给该函数进行处理。
 * 2、Stream<T> filter(Predicate<? super T> predicate);中间操作
 *          该方法将会产生一个boolean值结果，代表指定的条件是否满足。如果结果为true，那么Stream流的 filter 方法
 *          将会留用元素；如果结果为false，那么 filter 方法将会舍弃元素。
 * 3、<R> Stream<R> map(Function<? super T, ? extends R> mapper);
 *          该接口需要一个 Function 函数式接口参数，可以将当前流中的T类型数据转换为另一种R类型的流。
 * 4、long count();
 *           正如旧集合 Collection 当中的 size 方法一样，流提供 count 方法来数一数其中的元素个数
 *          该方法返回一个long值代表元素个数（不再像旧集合那样是int值）。
 * 5、Stream<T> limit(long maxSize);
 *          limit 方法可以对流进行截取，只取用前n个.这里的不操作会直接获取当前所有的元素
 *          参数是一个long型，如果流当前长度大于参数则进行截取；否则不进行操作。
 * 6、Stream<T> skip(long n);
 *          如果希望跳过前几个元素，可以使用 skip 方法获取一个截取之后的新流：
 *          如果流的当前长度大于n，则跳过前n个；否则将会得到一个长度为0的空流
 * 7、public static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
 *          如果有两个流，希望合并成为一个流，那么可以使用 Stream 接口的静态方法 concat
 *          这是一个静态方法，与 java.lang.String 当中的 concat 方法是不同的。
 */
public class MethodOfStream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("王阳明");
        list.add("于谦");
        list.add("郭德纲");
        list.add("岳云鹏");
        list.add("李三");
        //1.通过list获取Stream流
        Stream<String> stream1 = list.stream();
        Stream<String> stream = list.stream();
        System.out.println(stream);//java.util.stream.ReferencePipeline$Head@6d6f6e28
        System.out.println(stream1);//java.util.stream.ReferencePipeline$Head@135fbaa4
        //2.通过流进行处理
//        stream.forEach((t)-> System.out.println(t));
        //当前流第二次被使用，视为流重用，返回IllegalStateException异常
//        stream.filter(s -> s.startsWith("郭"));
//        stream.map(t->Integer.valueOf(t));
//        System.out.println(stream.count());
//        stream.filter(s ->s.startsWith("于")).limit(3).forEach(s -> System.out.println(s));
        //会形成一个新的Stream流
        Stream.concat(stream,stream1).forEach(s -> System.out.println(s));
    }

}
