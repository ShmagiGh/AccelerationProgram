public class Problem1 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 2, 2, 8, 4, 4, 1}));
    }

    /*
        Since we know that all elements appear twice we can be sure that xor-ing them together will get zero(xor
        operation commutative). and since what we search for appears only once, we can be sure that after xor-ing
        everything we will be left with what we were looking for(0^num=num).
     */
    public static int singleNumber(int[] nums) {
        if(nums.length == 0){
            return -1;
        }
        int single = nums[0];
        for(int i = 1; i < nums.length; i++){
            single = single ^ nums[i];
        }
        return single;
    }
}
