package Revision;

public class MultiplyString {
    public static void main(String[] args) {

        System.out.println(multiply("123", "456"));

    }

    public static String multiply(String n1, String n2) {

        int n = n1.length(), m = n2.length();


        char[] num1 = n1.toCharArray(), num2 = n2.toCharArray();

        int[] product = new int[n + m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                product[i + j + 1] += (num1[i] - '0') * (num2[j] - '0');
            }
        }

        int carry = 0;

        for (int i = product.length - 1; i >= 0; i--) {

            int sum = product[i] + carry;
            product[i] = sum % 10;
            carry = sum / 10;
        }

        StringBuilder sb = new StringBuilder();

        for (int nums : product)
            sb.append(nums);

        while (sb.length() != 0 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
