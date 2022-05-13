package w1_quickunion.quick_find;

import w1_quickunion.quick_find.binarysearch;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args){
		int[] x = {1, 2, 3, 4, 9, 13};
		int k;
		binarysearch b = new binarysearch();
		Scanner input = new Scanner(System.in);
		System.out.println("Input the key you wanna search: ");
		k = input.nextInt();
		input.close();
		int r = b.search(x, k) + 1;
		System.out.println("The arrayNum of "+ k + " is " + r);
	}
}
