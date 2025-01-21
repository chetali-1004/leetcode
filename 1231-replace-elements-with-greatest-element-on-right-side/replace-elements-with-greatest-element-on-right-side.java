class Solution {
    public int[] replaceElements(int[] arr) {
        if(arr.length == 1) return new int[]{-1};
        int n = arr.length;
        int[] sol = new int[n];
        sol[n-1] = -1;
        int maxElementOnRight = arr[n-1];
        for(int i = n-2; i>=0; i--){
            sol[i] = Math.max(sol[i+1], maxElementOnRight);
            maxElementOnRight = Math.max(arr[i], maxElementOnRight);
        }
        return sol;
    }
}