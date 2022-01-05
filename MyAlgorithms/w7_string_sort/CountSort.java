

public class CountSort {
    private int[] base;
    private int radix;
    public CountSort(int[] a, int r) {
        this.base = a;
        this.radix = r;
    }

    private int[] sort(int[] a, int r) {
        int N = a.length;
        int[] count = new int[r + 1];
        int[] aux = new int[N];
        for(int i = 0; i < N; i++) {
            count[a[i]+1]++;
        }
        for(int i = 0; i < r; i++) {
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

    
    
}
