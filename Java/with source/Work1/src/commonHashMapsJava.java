import java.util.HashMap;
import java.util.Map;

public class commonHashMapsJava {
    public static void main(String[] args) {
        HashMap<String, String> hashmap1 = new HashMap<>();
        HashMap<String, String> hashmap2 = new HashMap<>();
        hashmap1.put("Irakli", "Mdzinara");
        hashmap1.put("Geolab", "Dzerski");
        hashmap1.put("Harry", "Potter");
        hashmap1.put("Tbilisoba", "Mwvadi");
        hashmap1.put("Aba", "He");
        hashmap2.put("Geolab", "Dzerski");
        hashmap2.put("Seriali", " Silicon Valley");
        hashmap2.put("Zamtari", "Civi");
        hashmap2.put("Irakli", "Mdzinara");
        hashmap2.put("Aba", "Ho");

//        commonKeyValuePairs(hashmap1, hashmap2);
        System.out.println(commonKeyValuePairs(hashmap1, hashmap2));
    }

    public static int commonKeyValuePairs(HashMap<String, String> map1, HashMap<String, String> map2){
        int count =0;
        for(Map.Entry<String, String> entry : map1.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            for(Map.Entry<String, String> entry2 : map2.entrySet()){
                String key2 = entry2.getKey();
                String value2 = entry2.getValue();
                if(key == key2){
                    if(value==value2){
//                        System.out.println(key+value);
                        count+=1;
                    }
                }
            }
            // do what you have to do here
            // In your case, another loop.
        }
        return count;

    }
}
