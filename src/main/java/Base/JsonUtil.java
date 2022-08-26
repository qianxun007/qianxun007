package Base;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

public class JsonUtil {

    public static List<String> readUsingJsonPath(String json, String path) {
        if (json == null) {

            return null;
        }
        if (path == null) {

            return null;
        }
        try {
            List<String> resJsonList = new ArrayList<>();

            if (path.equals(".")) {
                resJsonList.add(json);
                return resJsonList;
            }
            //1. 解析Json结果为一个对象
            ReadContext context = JsonPath.parse(json);
            Object jsonRes = context.read("$." + path);
            //2.对当前的对象进行判断，如果是一个List，把其分解开来，并再次进行解析，直到最后都是单个String对象，再放到List中
            Queue<Object> resQueue = new LinkedList<>();
            resQueue.add(jsonRes);
            while (!resQueue.isEmpty()) {
                Object top = resQueue.poll();
                if (top instanceof Collection) {
                    //本质上是强制转换，即将父类对象强制转换为子类对象
                    List<?> list = List.class.cast(top);
                    resQueue.addAll(list);
                } else {
                    resJsonList.add(top.toString());
                }
            }
            return resJsonList;
        } catch (Exception ex) {
        }
        return null;
    }
}
