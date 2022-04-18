public class KMP {
    private final int R; // character
    private final int S; // state
    private int[][] dfa;

    public KMP(String txt) {
        this.R = 256;
        this.S = txt.length();
        dfa = new int[R][S];
        dfa[txt.charAt(0)][0] = 1;
        for(int cur = 1, backup = 0; cur < S ; cur++) {
            // Mismatch case
            for(int c = 0; c < R; c++) {
                dfa[c][cur] = dfa[c][backup];
            }
            // Match case
            dfa[txt.charAt(cur)][cur] = cur + 1;
            backup = dfa[txt.charAt(cur)][backup]; // DP
        }
    }

    public int search(String txt) {
        int pos, num;
        for(pos = 0, num = 0; pos < txt.length() && num < S; pos++) {
            num = dfa[txt.charAt(pos)][num];
        }

        if(num == S)    return pos - S;
        return txt.length();
    }

    public boolean contains(String txt) {
        if(search(txt) == txt.length()) 
            return false;
        return true;
    }

    public static void main(String[] args) {
        String pat = args[0];
        String txt = args[1];

        KMP kmp = new KMP(pat);

        if(kmp.contains(txt)) {
            System.out.println("Found in " + (kmp.search(txt) + 1) + " th word!");
        } else {
            System.out.println("Not Found!");
        }
        

    }
}
