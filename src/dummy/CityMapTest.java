package dummy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CityMapTest {
    public static void main(String[] args) {
        //1.遍历省份
        CityMap cityMap = new CityMap();
        Map model = cityMap.model;
        Set provinces = model.keySet();
        for (Object province : provinces) {
            System.out.println(province + "\t\t");
        }

        //2.根据提示 判断是否存在此省份 如果存在 遍历其value的值
        //如果不存在 提示用户输入省份有误
        Scanner scanner = new Scanner(System.in);
        String[] cities;
        while (true) {
            System.out.println("请输入您的省份：");
            String province = scanner.next();
            cities = (String[]) model.get(province);

            if (cities == null || cities.length == 0) {
                System.out.println("您输入的省份有误，请重新输入");
            } else break;

        }
        for (int i = 0; i < cities.length; i++) {
            System.out.println(cities[i] + "\t\t");
        }


        //3.根据提示 从键盘获取城市数值 遍历各个城市 判断城市是否在此数组中
        //如果不存在 提示用户输入城市有误
        boolean exitLoop = false;
        while (!exitLoop) {
            System.out.println("请输入您的城市：");
            String city = scanner.next();

            for (int i = 0; i < cities.length; i++) {
                if (city.equals(cities[i])) {
                    System.out.println("信息登记完毕");
                } else {
                    System.out.println("城市信息输入有误");
                    exitLoop = true;
                    break;
                }
            }
        }
        scanner.close();
    }
}

class CityMap {
    public static Map model = new HashMap();

    static {
        model.put("北京", new String[]{"北京"});
        model.put("上海", new String[]{"上海"});
        model.put("天津", new String[]{"天津"});
        model.put("重庆", new String[]{"重庆"});
        model.put("黑龙江", new String[]{"哈尔滨", "齐齐哈尔", "牡丹江", "大庆", "伊春", "双鸭山", "绥化"});
        model.put("吉林", new String[]{"长春", "延边", "吉林", "白山", "白 城", "四平", "松原"});
        model.put("河北", new String[]{"石家庄", "张家口", "邯郸", "邢台 ", "唐山", "保定", "秦皇岛"});
    }
}