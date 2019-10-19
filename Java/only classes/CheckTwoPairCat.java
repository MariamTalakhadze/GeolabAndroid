import java.util.Arrays;
public class CheckTwoPairCat {
    public static void main(String[] args) {
        int[] array1={1,2,3,4,5};
        int[] array2={4,4,5,2,5};
//        CheckTwoPairCategory(array1);
        CheckTwoPairCategory(array2);
        System.out.print(CheckTwoPairCategory(array1));
        System.out.print(CheckTwoPairCategory(array2));
    }
    public static boolean CheckTwoPairCategory(int[] dice){
        Arrays.sort(dice);
        int result = 0;
        for ( int i = 0 ; i < dice.length-1 ; i++ ) {
            if(dice[i]==dice[i+1]){
               result+=1;
            }
        }
        if(result==2){
            return true;
        }
        return false;
    }
}
