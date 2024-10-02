class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if(arr.length == 2) return true;
        int n = arr.length;
        Arrays.sort(arr);
        int diff = arr[1]-arr[0];
        for(int i = 2; i<n; i++){
            if(arr[i]-arr[i-1]!=diff) return false;
        }
        return true;
    }
}