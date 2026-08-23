class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = new ArrayList[n];

        for(int i = 0;i < n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        visited[source] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(source);

        while(q.size()>0){
            int front = q.remove();

            if(front == destination){
                return true;
            }

            for(int ele : graph[front]){
                if(!visited[ele]){
                    visited[ele] = true;
                    q.add(ele);
                }
            }
        }
        return false;
    }
}