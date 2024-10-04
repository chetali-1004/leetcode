class Solution {
    public long dividePlayers(int[] skill) {
        if(skill.length == 2) return skill[0]*skill[1];
        Arrays.sort(skill);
        int n = skill.length;
        int sum = skill[0]+skill[n-1];
        long ans = skill[0]*skill[n-1];
        int i = 1;
        int j = n-2;
        while(i<=j){
            if(skill[i]+skill[j]!=sum){
                return -1;
            }
            ans += (skill[i]*skill[j]);
            i++;
            j--;
        }
        return ans;
    }
}