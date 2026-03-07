class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> ans = new ArrayList<>();
        int r = mat.length;
        int c = mat[0].length;

        int topRow = 0, bottomRow = r-1, leftCol = 0, rightCol = c-1;
        int totalEle = 0;

        while(totalEle < r*c){
            //topRow => leftCol to rightCol
            for(int j = leftCol ; j <= rightCol && totalEle < r*c ; j++){
                ans.add(mat[topRow][j]);
                totalEle++;
            }
            topRow++;

            //rightCol => topRow to bottomRow
            for(int i = topRow ; i <= bottomRow && totalEle < r*c ; i++){
                ans.add(mat[i][rightCol]);
                totalEle++;
            }
            rightCol--;

            //bottomRom => rightCol to leftCol
            for(int j = rightCol ; j >= leftCol && totalEle < r*c ; j--){
                ans.add(mat[bottomRow][j]);
                totalEle++;
            }
            bottomRow--;

            //leftCol => bottomRow to topRow
            for(int i = bottomRow ; i >= topRow && totalEle < r*c ; i--){
                ans.add(mat[i][leftCol]);
                totalEle++;
            } 
            leftCol++;
        }

        return ans;

    }
}