package cn.eric.net.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : junlinchen
 * @date: 2019/7/1 17:27
 * @version: 1.0
 * @Des :
 */
public class mergeData {
    public static void main(String[] args) {
        List<Map<String, String>> l = new ArrayList<Map<String, String>>();
        Map<String, String> oneMap = new HashMap<String, String>();
        oneMap.put("gsId", "8000");
        oneMap.put("gsName", "总部集中处理中心");
        oneMap.put("type", "D");
        oneMap.put("yybcount", "3");
        l.add(oneMap);
        Map<String, String> twoMap = new HashMap<String, String>();
        twoMap.put("gsId", "8008");
        twoMap.put("gsName", "南京长江路证券营业部");
        twoMap.put("type", "H");
        twoMap.put("yybcount", "14");
        l.add(twoMap);

        List<Map<String, String>> twoList = new ArrayList<Map<String, String>>();
        Map<String, String> oneMap1 = new HashMap<String, String>();
        oneMap1.put("gsId", "8008");
        oneMap1.put("gsName", "南京长江路证券营业部");
        oneMap1.put("type", "H");
        oneMap1.put("yybcount", "5");
        twoList.add(oneMap1);
        Map<String, String> twoMap2 = new HashMap<String, String>();
        twoMap2.put("gsId", "8008");
        twoMap2.put("gsName", "南京止马营证券营业部");
        twoMap2.put("type", "F");
        twoMap2.put("yybcount", "9");
        twoList.add(twoMap2);

        l.addAll(twoList);

        List<Map<String, String>> countList = new ArrayList<Map<String, String>>();
        for (int i = 0; i < l.size(); i++) {
            String gsId = l.get(i).get("gsId");
            String type = l.get(i).get("type");
            int flag = 0;// 0为新增数据，1为增加count
            for (int j = 0; j < countList.size(); j++) {
                String gsId_ = countList.get(j).get("gsId");
                String type_ = countList.get(j).get("type");

                if (gsId.equals(gsId_) && type.equals(type_)) {
                    int sum = Integer.parseInt(l.get(i).get("yybcount"))
                            + Integer.parseInt(countList.get(j).get("yybcount"));
                    countList.get(j).put("yybcount", sum + "");
                    flag = 1;
                    continue;
                }
            }
            if (flag == 0) {
                countList.add(l.get(i));
            }
        }
        for (Map<String, String> map : countList) {
            System.out.println(map);
        }
    }
}
