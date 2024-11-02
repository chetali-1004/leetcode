class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] strarr = sentence.split(" ");
        // if(strarr.length==1) return false;
        for(int i = 0; i<strarr.length-1; i++){
            if(strarr[i].charAt(strarr[i].length()-1)!=strarr[i+1].charAt(0)) return false;
        }
        if(strarr[strarr.length-1].charAt(strarr[strarr.length-1].length()-1)!=strarr[0].charAt(0)) return false;
        return true;
    }
}