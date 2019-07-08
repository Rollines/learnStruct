package cn.eric.net.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author : junlinchen
 * @date: 2019/7/1 16:42
 * @version: 1.0
 * @Des :
 */
public class MapTest {
    public static void main(String[] args) {
        // Map集合,键是字符串,值是一个list集合
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        // 第一个List集合存放字符串元素
        ArrayList<String> a1 = new ArrayList<String>();
        // List集合存放4个元素
        a1.add("a1_1");
        a1.add("a1_2");
        a1.add("a1_3");
        a1.add("a1_4");
        // 第二个list集合
        ArrayList<String> a2 = new ArrayList<String>();
        // List集合存放4个元素
        a2.add("a2_a");
        a2.add("a2_b");
        a2.add("a2_c");
        a2.add("a2_d");
        // 第二个list集合
        ArrayList<String> a3 = new ArrayList<String>();
        // List集合存放4个元素
        a3.add("a3_大");
        a3.add("a3_家");
        a3.add("a3_好");
        a3.add("a3_啊");
        // map存放list集合:键对应的n开头,值就上面的list三个集合;
        map.put("N1", a1);
        map.put("N2", a2);
        map.put("N3", a3);
        // 取你所说的value值:<---------------实际value就是一个list集合;
        // Map里面拿到第1个集合;
        System.out.println(map.get("N1"));
        // Map里面拿到第2个集合;
        System.out.println(map.get("N2"));
        // Map里面拿到第3个集合;
        System.out.println(map.get("N3"));
        System.out.println("\r\n--------------------分割线--------------\r\n");
        // 如果不清楚键都是什么,那么就直接迭代:迭代方式1
        for (Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
            String key = it.next();
            System.out.println("key="+key);
            System.out.println("value="+map.get(key));
        }
        System.out.println("\r\n---------------分割线------------------\r\n");
        // 也可以这么迭代:迭代方式2;
        for (Iterator<Map.Entry<String, ArrayList<String>>> it = map.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, ArrayList<String>> me = it.next();
            String key = me.getKey();
            ArrayList<String> value = me.getValue();
            System.out.println("key=" + key);
            System.out.println("value=" + value);
        }
    }
}
