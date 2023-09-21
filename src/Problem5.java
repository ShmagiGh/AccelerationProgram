import java.util.HashMap;

public class Problem5 {
    public static void main(String[] args) {
        System.out.println(countVariants(30));
    }

    /*
        We have two choice:
        1) We move up by 1, and we are left with n-1 floors
        2) We move up by 2, and we are left with n-2 floors
        So from given position we can just sum up how many each of this cases give by recursion.
        To reduce big load of recursive functions, we can save answers to what we already got
        We calculate countVariants(n - 1) and countVariants(n - 2) separately because one may get
     */
    public static int countVariants(int n) {
        return counterVariantsWrapper(n, new HashMap<>());
    }
    public static int counterVariantsWrapper(int n, HashMap<Integer, Integer> savedValues) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        if(savedValues.containsKey(n)) {
            return savedValues.get(n);
        }
        int value = countVariants(n - 1) + countVariants(n - 2);
        savedValues.put(n, value);
        return value;
    }
}
