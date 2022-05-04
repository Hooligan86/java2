import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 6};
        System.out.println( checkIfSidesOfArrayEqual(arr));
        Integer[] arr2 = { 6, 1, 3, 5};
        shiftArray(arr2,-2);

    }

    public static boolean checkIfSidesOfArrayEqual(int[] arr) {
        int leftSum = 0;
        int rightSum;
        for (int i = 0; i < arr.length; i++) {
            rightSum = 0;
            for (int j = i; j < arr.length; j++) {
                rightSum += arr[j];
            }
            if(leftSum == rightSum){
                return true;
            }
            leftSum += arr[i];
        }
        return false;
    }

    public static Integer[] shiftArray(Integer[] arr, int shift) {

        Collections.rotate(Arrays.asList(arr),shift % arr.length);
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
