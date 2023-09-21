public class Problem4 {
    public static void main(String[] args) {
        String a = "10011010111";
        String b =   "110110101110110010101";
        System.out.println(binStringSum(a, b));
        System.out.println(binStringSum(b, a));
    }
    /*
        While I could just have used Integer.parseInt(str, 2) to get integer representation of binary string, sum them
        and then used Integer.toBinaryString(sum) to convert to binary string, I thought it was too simple and just
        described whole logic.
     */
    public static String binStringSum(String a, String b) {
        if(a.length() < b. length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        StringBuilder sum = new StringBuilder();
        char remainder = '0';
        for(int i = b.length() - 1; i >= 0; i --) {
            char a_char = a.charAt(a.length() - b.length() + i);
            char b_char = b.charAt(i);
//            System.out.println(a_char + "  " + b_char + "  " + remainder);
            if(a_char == '1' && b_char == '1' && remainder == '0') {
                remainder = '1';
                sum.insert(0, '0');
            } else if(a_char == '1' && b_char == '1' && remainder == '1') {
                sum.insert(0, '1');
            } else if((a_char == '1' || b_char == '1') && (remainder == '1')) {
                sum.insert(0, '0');
            } else if(a_char == '0' && b_char == '0' && (remainder == '1')) {
                remainder = '0';
                sum.insert(0, '1');
            } else {
                remainder = '0';
                int i1 = a_char - b_char;
                sum.insert(0, i1 * i1);
            }
        }
        for(int i = a.length() - b.length() - 1; i >= 0; i --) {
            char a_char = a.charAt(i);
            if(a_char == '1' && remainder == '1') {
                sum.insert(0, '0');
            } else if(a_char == '1' && remainder == '0') {
                sum.insert(0, '1');
            } else if(a_char == '0' && remainder == '1') {
                remainder = '0';
                sum.insert(0, '1');
            } else {
                sum.insert(0, '0');
            }
        }
        if(remainder == '1') {
            sum.insert(0, '1');
        }
        return sum.toString();
    }
}
