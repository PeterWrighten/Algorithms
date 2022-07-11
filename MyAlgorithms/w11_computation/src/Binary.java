package MyAlgorithms.w11_computation.src;

import java.util.Scanner;

public class Binary {
    private int binary_recur(int a, int n) {
        if(n == 0) {
            return 1;
        } else if(n % 2 == 1) {
            return binary_recur(a, n - 1) * a;
        } else {
            int temp = binary_recur(a, n / 2);
            return temp * temp;
        }
    }

    private int qpow(int a, int n) {
        int ans = 1;
        while(n) {
            if(n & 1) {
                ans *= a;
            }
            a *= a;
            n >>= 1;
        }
        return ans;
    }


    public int quickPow(int a, int n) {
        return binary_recur(a, n);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a: ");
        int a = input.nextInt();
        System.out.println("Input n: ");
        int n = input.nextInt();
        Binary binary = new Binary();
        int res = binary.quickPow(a, n);
        System.out.println("Result: " + res);
        input.close();
    }
}
