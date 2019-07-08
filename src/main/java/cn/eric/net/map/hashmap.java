package cn.eric.net.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author : junlinchen
 * @date: 2019/7/1 14:51
 * @version: 1.0
 * @Des : 3种遍历的方法 遍历hashmap；用keySet遍历；用entrySet遍历
 */
public class hashmap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("1", "aaa");
        map.put("2", "bbb");
        map.put("3", "ccc");
        map.put("4", "ddd");
        map.put("5", "eee");
        map.put("6", "fff");
        map.put("7", "ggg");
        map.put("8", "hhh");
        map.put("9", "iii");

        /*
         * 遍历hashmap
         */
        hashmap1(map);
        line();
        /*
         * 用keySet遍历
         */
        hashmap2(map);
        line();
        /*
         * 用entrySet遍历 速度快
         */
        hashmap3(map);
        line();
    }

    public static void hashmap1(HashMap<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Key:" + entry.getKey() + "   value:" + entry.getValue().toString());
        }

    }

    public static void hashmap2(HashMap<String, String> map) {
        Iterator<String> it=map.keySet().iterator();//这是取得键对象
        while(it.hasNext())   {
            System.out.println("value: "+map.get(it.next()));   //获得键所对应的值。
        }
    }

    public static void hashmap3(HashMap<String, String> map) {
        Iterator<Entry<String, String>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Entry<String, String>  entry=(Entry<String, String>)it.next();
            System.out.println("key:"+entry.getKey()+"   value:"+entry.getValue());

        }
    }
    public static void line(){
        System.out.println("========================华丽的分割线===============================");
    }
}
