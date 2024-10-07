class Solution {
    public int minLength(String s) {
        StringBuilder sb = new StringBuilder(s);
        while(true){
            boolean flag = false;
            for(int i = 0; i<sb.length()-1; i++){
                if((sb.charAt(i) == 'A' && sb.charAt(i+1)=='B') || (sb.charAt(i)=='C'&& sb.charAt(i+1)=='D')){
                    sb.delete(i,i+2);
                    flag = true;
                }
            }
            if(flag == false) return sb.length();
        }
    }
}