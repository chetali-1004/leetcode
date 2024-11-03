class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        if(s.equals(goal)) return true;
        StringBuilder sb = new StringBuilder(goal);
        System.out.println(sb.toString());
        for(int i = 0; i<s.length(); i++){
            char ch = sb.toString().charAt(sb.length()-1);
            sb.setLength(sb.length()-1);
            sb.reverse().append(ch).reverse();
            if(sb.toString().equals(s)) return true;
        }
        return false;
    }
}