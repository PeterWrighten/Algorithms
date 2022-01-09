package api;


/*************************************************
 * 
 *  public final class String implements Comparable<String>:
 *      private char[] value;
 *      private int offset; //index of first char in array
 *      private int length;
 *      private int hash;
 * 
 *      public int length();
 *      public char charAt(int);
 *      private String(int offset, int length, char[] value);
 *      public String substring(int from, int to);
 * 
 *************************************************/


public final class String implements Comparable<String>{
    private char[] value;
    private int offset;
    private int length;
    private int hash;

    public int length() {
        return length;
    }

    public char charAt(int i) {
        return value[i + offset];
    }

    private String(int offset, int length, char[] value) {
        this.value = value;
        this.length = length;
        this.offset = offset;
    }

    public String substring(int from, int to) {
        return new String(offset + from, to - from, value);
    }
    
}
