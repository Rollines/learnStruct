package cn.eric.net.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : junlinchen
 * @date: 2019/7/8 15:41
 * @version: 1.0
 * @Des : 运行时常量池溢出
 *
 * 如果要向运行时常量池中添加内容，最简单的做法就是使用String.intern()这个Native方法。
 * 该方法的作用是：如果池中已经包含一个等于此String对象的字符串，则返回代表池中这个字符串的String对象；
 * 否则，将此String对象包含的字符串添加到常量池中，并且返回此String对象的引用。
 * 由于常量池分配在方法区内，我们可以通过-XX:PermSize和-XX:MaxPermSize限制方法区的大小，从而间接限制其中常量池的容量，
 *
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        // 使用List保持着常量池引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<String>();
        // 10MB的PermSize在integer范围内足够产生OOM了
        int i = 0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
