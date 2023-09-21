import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem3 {
    public static void main(String[] args) {
        System.out.println(notContains(new int[]{1, 2, 2, 8, 4, 4, 1}));
    }

    public static int notContains(int[] array) {
        /*
            First step is to sort array as it will help us to no longer keep track of what numbers appeared
            in array. Next is to place first guess as 1. Now we will be able to just iterate over array and if element
            of array is equal than our guess then we increment our guess. If some element becomes greater than our
            guess at given time, than we can be sure that our guess is correct, because elements past that will only
            increase.
         */
        Arrays.sort(array);
        int min_positive = 1;
        for(int i = 0; i < array.length; i++){
            if(array[i] == min_positive) {
                min_positive ++;
            } else if(array[i] > min_positive) {
                break;
            }
        }

        return min_positive;
    }
}
