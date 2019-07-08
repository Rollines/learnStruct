package cn.eric.net.map;

import java.util.HashMap;

/**
 * @author : junlinchen
 * @date: 2019/7/1 15:06
 * @version: 1.0
 * @Des :
 */
public class jdkHashMap {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("DEMO1",1);
        map.put("DEMO2",2);

        System.out.println(map);
        System.out.println(map.putIfAbsent("DEMO1",1212));
        System.out.println(map.putIfAbsent("DEMO3",122222));
        System.out.println(map);
    }
}
