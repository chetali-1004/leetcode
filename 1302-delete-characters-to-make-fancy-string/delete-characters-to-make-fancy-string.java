class Solution {
    public String makeFancyString(String s) {
        if(s.length()<3) return s;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length()-2; i++){
            char ch = s.charAt(i);
            if(s.charAt(i+1)==ch && s.charAt(i+2)==ch) continue;
            sb.append(ch);
        }
        sb.append(s.charAt(s.length()-2));
        sb.append(s.charAt(s.length()-1));
        return sb.toString();
    }
}