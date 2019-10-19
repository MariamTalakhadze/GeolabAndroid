import java.util.Arrays;

public class daVinci {
    public static void main(String[] args) {
        String a = "geekforgeEks!i,";
        String b = "geekforgeeski";
        sortString(a, b);
        System.out.print(sortString("abc", "bca"));
        System.out.print(sortString("abc", "bcad"));
    }

    private static boolean sortString(String inputString, String b) {
        String inputString2 = inputString.toLowerCase();
        char[] chars = inputString2.toCharArray();
        char[] chars2 = b.toCharArray();
        Arrays.sort(chars2);
        int length = chars.length;
        String newchars2 = new String(chars2);
        String newchars = "";
        Arrays.sort(chars);
        for (int i = 0 ; i<length; i++){
            if((int)chars[i]>96 && (int)chars[i]<123){
//                System.out.print(chars[i]);
                newchars+=chars[i];
            }
        }
        if(newchars.equals(newchars2)){
//            System.out.println("true");
            return true;
        }
        return false;
    }
}
