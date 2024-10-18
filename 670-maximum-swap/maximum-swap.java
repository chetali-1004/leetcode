import java.util.*;

class Solution {
    public int maximumSwap(int num2) {
        int num = num2;
        List<Integer> ls = new ArrayList<>();
        while (num > 0) {
            ls.add(num % 10);
            num /= 10;
        }
        Collections.reverse(ls);
        int n = ls.size();
        boolean flag = false;
        int[] lastIndex = new int[10];
        for (int i = 0; i < n; i++) {
            lastIndex[ls.get(i)] = i;
        }
        
        for (int i = 0; i < n; i++) {
            for (int d = 9; d > ls.get(i); d--) {
                if (lastIndex[d] > i) {
                    Collections.swap(ls, i, lastIndex[d]);
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
    
        if (!flag) return num2;
        int maxnum = 0;
        for (int i = 0; i < n; i++) {
            maxnum = (maxnum * 10) + ls.get(i);
        }
        
        return maxnum;
    }
}
