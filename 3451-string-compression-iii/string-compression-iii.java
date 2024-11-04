class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int n = word.length();
        int count = 1;
        for(int i=1; i<n; i++){
            if(word.charAt(i)==word.charAt(i-1)){
                count++;
                if(count == 9){
                    sb.append('9');
                    sb.append(word.charAt(i));
                    count = 0;
                }
            }
            else{
                if(count!=0){
                    sb.append(count);
                    sb.append(word.charAt(i-1));
                }
                count=1;
            }
        }

        if(count>0){
            sb.append(count);
            sb.append(word.charAt(n-1));
        }
        return sb.toString();
    }
}