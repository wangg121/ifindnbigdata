/**
 * @author Guo Yan
 * @date 2020/5/13-20:52
 */
public class Cacl {

    public static void main(String[] args) {
        int[] arr = {-8, 1,1, -4, -3, 0, 1, 2, 4, 5, 8, 8, 9};

        int left = 0;
        int right = arr.length-1;
        int k = 10;
        while (left < right){
            if(arr[left] + arr[right] < k ){
                left++;
            }else if(arr[left] + arr[right] > k){
                right--;
            }else if(left == 0 || arr[left-1] != arr[left]){
                System.out.println(arr[left] + " + " + arr[right] + " = " +k);
                left++;
                right--;
            }
        }
    }

}
