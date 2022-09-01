package com.yama.function;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * 有时候我们需要对某种类型的数据进行判断，从而得到一个boolean值结果。
 * @FunctionalInterface
 * public interface Predicate<T>------>函数式接口
 * 方法解析：
 *      Boolean test(t):传递方法实现类，根据传递的参数进行操作进而获取结果的Boolean值。
 *      and方法：进行两次判断，对原始参数进行两次操作，用&&合并判断进行返回
 *      negate：将结果进行取反操作
 *      or：将两次比较，用or连接进行获取结果
 *
 *
 */
public class PredicateDemo01 {
    public static void judgeString(Predicate<String> str){
        boolean howLong = str.test("hello world");
        System.out.println("字符串是不是挺长的："+(howLong?"是":"否"));
    }
    public static void judgeAndMethod(Predicate<String> str1,Predicate<String> str2){
        boolean andResult = str1.and(str2).test("yama");
        System.out.println("字符串是jack并且大于3吗："+andResult);
    }

    public static void main(String[] args) {
        judgeString(s->{
            if (s.length()>5){
                return true;
            }else {
                return false;
            }
        });
        judgeAndMethod(
                s->s.length()>3?true:false,
                s->Objects.equals(s,"jack"));
    }
}
