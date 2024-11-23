class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;
        char[][] sol = new char[m][n];
        for(int i = 0; i<n; i++){
            for(int j = m-1; j>=0; j--){
                if(box[i][j] == '#'){
                    int pos = j;
                    while(pos+1<m && box[i][pos+1]=='.'){
                        pos++;
                    }
                    if(pos!=j){
                        box[i][pos] = '#';
                        box[i][j] = '.'; 
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sol[j][n - i - 1] = box[i][j];
            }
        }

        return sol;
    }
}