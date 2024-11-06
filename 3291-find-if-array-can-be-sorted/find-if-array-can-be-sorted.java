class Solution {
    public boolean canSortArray(int[] arr) {
        int len = arr.length;
        for(int i = 0; i<len; i++){
            for(int j = i+1; j<len; j++){
                if(arr[j]<arr[i]){
                    if(countSetBits(arr[i])!=countSetBits(arr[j])) return false;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for(int i = 1; i<len; i++){
            if(arr[i-1]>arr[i]) return false;
        }
        return true;
    }

    private int countSetBits(int dec){
        int count = 0;
        while(dec>0){
            count += dec & 1;
            dec/=2;
        }
        return count;
    }
}