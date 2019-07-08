package cn.eric.net.map;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : junlinchen
 * @date: 2019/7/1 16:04
 * @version: 1.0
 * @Des :
 */
public class TestHan {
    /**
     * 处理重复数据与不重复数据，以重复数据为唯一，合并数据的方法。
     */
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("张三", 1));
        list.add(new Student("李四", 1));
        list.add(new Student("王五", 2));
        list.add(new Student("赵六", 1));
        list.add(new Student("孙七", 2));
        list.add(new Student("周八", 1));
        list.add(new Student("吴九", 2));

        //对于上面的学生、如果根据班级进行区分？！
        Map<Integer,List<Student>> map = new HashMap<>();
        List<Student> students;
        for(Student s : list) {
            /**
             * put不管什么直接存入，返回旧值
             * putIfAbsent如果为null才存入，返回旧值。
             */
            students = map.putIfAbsent(s.getInClass(),new ArrayList<Student>(list.size()));
            if (null == students) {
                students = map.get(s.getInClass());
            }
            students.add(s);
        }

        //循环Map
        map.forEach((key,value) -> {
            System.out.println("班级:" + key + ",人员:" + JSON.toJSONString(value));
        });
    }

}
