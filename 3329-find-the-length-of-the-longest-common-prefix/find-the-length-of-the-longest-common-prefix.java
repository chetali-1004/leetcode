class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> hs = new HashSet<>();
        for(int num : arr1){
            while(num>0){
                hs.add(num);
                num/=10;
            }
        }

        int res = Integer.MIN_VALUE;
        for(int num : arr2){
            while(num>0){
                if(hs.contains(num)){
                    res = Math.max(res, num);
                    break;
                }
                num/=10;
            }
        }

        if(res == Integer.MIN_VALUE) return 0;
        StringBuilder str = new StringBuilder(String.valueOf(res));
        return str.length();

    }
}