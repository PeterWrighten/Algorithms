/* This is a min-heap */

import java.util.Scanner;

public class PriorityQueue 
{
    private Integer[] pq;
    private int N = 0;

    public PriorityQueue(int nums) {
        pq = new Integer[nums + 1];
    }

    public void swap(int i, int j) {
        int tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    private void swim(int k) {
        while(k > 1 && pq[k / 2] > pq[k]) {    
            swap(k, k / 2);
            k = k / 2;            
        }
    }

    private void sink(int k) {
        while(2 * k <= N) {
            int j = 2 * k;
            if(j < N && pq[j] > pq[j + 1])     j++; // j's range!!
            if(pq[j] < pq[k])     swap(k, j);
            k = j;
        }
    }

    public void insert(int k) {
        pq[++N] = k;
        swim(N);
    }

    public int delMin() {
        int tmp =  pq[1];
        swap(1, N--);
        sink(1);
        pq[N + 1] = null;
        return tmp;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many data do you wanna save?");
        int nums = input.nextInt();
        PriorityQueue heap = new PriorityQueue(nums);
        for(int i = 0; i < nums; i++) {
            System.out.println("Input numbers you wanna insert: ");
            int tmp = input.nextInt();
            heap.insert(tmp);
        }
        while(true) {
            System.out.println("Functions: ");
            System.out.println("1. GetMin;");
            System.out.println("2. delMin;");
            System.out.println("Others. Exit;");
            int tmp = input.nextInt();
            System.out.println("-------------------------------------");
            if(tmp == 1) {
                System.out.println(heap.pq[1]);
            } else if(tmp == 2) {
               System.out.println(heap.delMin());
            } else {
                break;
            }

        }

        input.close();
    }
}
