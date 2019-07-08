package cn.eric.net.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author : junlinchen
 * @date: 2019/7/8 16:07
 * @version: 1.0
 * @Des :本机直接溢出
 * DirectMemory容量可通过-XX:MaxDirectMemorySize指定，如果不指定，则默认与Java堆的最大值（-Xmx指定）一样。
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
