/****************************************************************
 * 
 *  public class CountingSort:
 *      private String[] base;
 *      private int radix;
 *      private String[] sort(String[], int);
 *      public void sort();
 * 
 ****************************************************************/


public class CountingSort {
    private int[] base;
    private int radix;

    public CountingSort(int[] a, int r) {
        this.base = a;
        this.radix = r;
    }

    private int[] sort(int[] a, int R) {
        int N = a.length;
        int[] count = new int[R + 1];
        int[] aux = new int[N];
        for(int i = 0; i < N; i++) {
            count[a[i]+1]++;
        }
        for(int i = 0; i < R; i++) {
            count[i + 1] += count[i];
        }
        for(int i = 0; i < N; i++) {
            aux[count[a[i]]++] = a[i];
        }
        return aux;
    }
    public void sort() {
        base = sort(base, radix);
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 3, 2, 2, 1, 1, 5, 4, 3, 3, 0};
        CountingSort cs = new CountingSort(a, 6);
        cs.sort();
        for(int i: cs.base) {
            System.out.println(i);
        }
    }
    
}
