package cn.eric.net.map;

/**
 * @author : junlinchen
 * @date: 2019/7/1 16:04
 * @version: 1.0
 * @Des :
 */
public class Student {
    private String name; //姓名
    private Integer inClass;//所属班级

    Student(String name,Integer inClass) {
        this.name = name;
        this.inClass = inClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInClass() {
        return inClass;
    }

    public void setInClass(Integer inClass) {
        this.inClass = inClass;
    }
}
