import java.util.ArrayList;
import java.util.List;

/**
 * @author Guo Yan
 * @date 2020/5/27-10:54
 */
public class Main {

    public static void main(String[] args){

        String[] strs = {"ABA","AAAA","aba","aaaa","a","abba","a1a","a11a"," aa ","a a a",
                "abab","a b a b","abb","aab","aa1","a11","1aa","11a"};

        for(String str : strs){
            System.out.println(str + "结果:" + verString(str) );
        }

    }

    public static boolean verString(String string){
        String str = string.toUpperCase();
        char[] chars = str.toCharArray();
        List<Character> listChar = new ArrayList<>();
        for(char c : chars){
            if(c != ' '){
                listChar.add(c);
            }
        }
        int start = 0;
        int end = listChar.size()-1;

        boolean result = true;
        while (start < (listChar.size()-1)/2){
            if(!listChar.get(start).equals(listChar.get(end))){
                result = false;
                break;
            }
            start++;
            end--;
        }
        return result;
    }


}
