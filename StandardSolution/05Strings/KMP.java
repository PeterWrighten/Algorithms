/****************************************************************
 * 
 * public class KMP:
 *      private final int R;
 *      
 * 
 ****************************************************************/


public class KMP {
    private final int R;
    private final int m;
    private int[][] dfa;
    public KMP(String pat) {
        this.R = 256;
        this.m = pat.length();
        this.dfa = new int[R][m];
        dfa[pat.charAt(0)][0] = 1;
        /*****************************************
         * 
         *  i: Backup's state
         *  x: current state
         * 
         *****************************************/
        for(int i = 0, x = 1; x < m; x++) {
            for(int c = 0; c < R; c++)// mismatches case
                dfa[c][x] = dfa[c][i]; // Backup
            dfa[pat.charAt(x)][x] = x + 1;
            i = dfa[pat.charAt(x)][i]; //Backup
        }
    }

    /*********************************************************
     *  
     *  public KMP(char[] pattern, int R) {
     *      this.R = R;
     *      this.m = pattern.length;
     *      dfa = new int[R][m];
     *      dfa[pattern[0]][0] = 1;
     *      for(int cur = 1, back = 0; cur < m; cur++) {
     *          for(int c = 0; c < R; c++) 
     *              dfa[c][cur] = dfa[c][back];
     *          dfa[pattern[cur]][cur] = cur + 1;
     *          back = dfa[pattern[cur]][back];
     *      }
     *  }
     * 
     * ********************************************************/ 
    
     public int search(String txt) {
         int pos, num;
         for(pos = 0, num = 0; pos < txt.length() && num < m; pos++) {
            num = dfa[txt.charAt(pos)][num];
         }
         if(num == m) return pos - m;
         return txt.length();
     }

     public boolean contains(String txt) {
        if(search(txt) == txt.length())
            return false;
        return true;  
     }
}
