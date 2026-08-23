class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        boolean[] visited = new boolean[n];
        visited[0] = true;
        bfs(0,rooms,visited);

        for(boolean ele : visited){
            if(ele == false) return false;
        }
        return true;
    }

    private static void bfs(int i, List<List<Integer>> rooms, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        
        while (q.size() > 0) {
            int front = q.remove();
            for (int ele : rooms.get(front)) {
                if(!visited[ele]){
                    visited[ele] = true;
                    q.add(ele);
                }
            }
        }
    }
}