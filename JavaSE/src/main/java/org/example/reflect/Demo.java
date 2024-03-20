package org.example.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @ClassName Demo
 * @Description
 * @Author chenxu
 * @Date 2024/3/20 15:40
 **/
public class Demo {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();

            // 获取类的信息
            Class<?> clazz = Class.forName("org.example.reflect.Class" + s);

            // 创建对象
            Object obj = clazz.getDeclaredConstructor().newInstance();

            // 获取方法(指定方法名和参数类型)
            Method method = clazz.getMethod("print");

            // 调用方法
            method.invoke(obj);

//            // 获取方法
//            Method method = clazz.getMethod("sayHello", String.class);
//
//            // 调用方法
//            method.invoke(obj, "John");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
