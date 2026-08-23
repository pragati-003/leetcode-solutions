class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]){
                    bfs(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }

    class Pair {
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    private void bfs(int i, int j, char[][] grid, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));

        while(q.size() > 0){
            Pair front = q.poll();
            int row = front.row , col = front.col;

            // Bottom
            if (row + 1 < m &&
                !visited[row + 1][col] &&
                grid[row + 1][col] == '1') {

                visited[row + 1][col] = true;
                q.add(new Pair(row + 1, col));
            }

            // Top
            if (row - 1 >= 0 &&
                !visited[row - 1][col] &&
                grid[row - 1][col] == '1') {

                visited[row - 1][col] = true;
                q.add(new Pair(row - 1, col));
            }

            // Right
            if (col + 1 < n &&
                !visited[row][col + 1] &&
                grid[row][col + 1] == '1') {

                visited[row][col + 1] = true;
                q.add(new Pair(row, col + 1));
            }

            // Left
            if (col - 1 >= 0 &&
                !visited[row][col - 1] &&
                grid[row][col - 1] == '1') {

                visited[row][col - 1] = true;
                q.add(new Pair(row, col - 1));
            }
        }
    }
}