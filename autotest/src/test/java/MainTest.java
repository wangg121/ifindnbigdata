import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Guo Yan
 * @date 2020/5/27-11:15
 */
public class MainTest {



    @Test
    public void verString(){
        String string = "Was it a bar or a bat I saw";
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
            if(listChar.get(start)!= listChar.get(end)){
                result = false;
                break;
            }
            start++;
            end--;
        }
        System.out.println(result);
    }




}