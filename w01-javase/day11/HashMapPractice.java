package day11;
import java.util.HashMap;
import java.util.Map;
public class HashMapPractice {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("202401","张三");
        map.put("202402","李四");
        map.put("202403","王五");
        System.out.println("202402>"+map.get("202402"));
        System.out.println("map.size>"+map.size());
        System.out.println("202401"+">"+map.get("202401"));
        map.put("202401","张三三");
        System.out.println("202401>"+map.get("202401"));
        System.out.println("202402 is "+map.containsKey("202402"));
        for(String key: map.keySet()){
            System.out.println(key+">"+map.get(key));
        }
        for(HashMap.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+">"+entry.getValue());
        }
    }
}
