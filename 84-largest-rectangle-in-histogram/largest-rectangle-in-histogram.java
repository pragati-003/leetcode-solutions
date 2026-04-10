class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for(int i = 0;i<=n;i++){
            
            int currHeight = (i == n) ? 0:heights[i];

            while(!st.isEmpty() && heights[st.peek()]>currHeight){
                int height = heights[st.pop()];

                int right = i;
                int left = st.isEmpty() ? -1:st.peek();
                int width = right-left-1;
                maxArea = Math.max(maxArea , height*width);
            }
            st.push(i);
        }
        return maxArea;

        // int[] nse = new int[n];
        // int[] pse = new int[n];

        // //calculate nse
        // st.push(n-1);
        // nse[n-1] = n;
        // for(int i = n-2;i>=0;i--){
        //     while(st.size()>0 && heights[st.peek()]>=heights[i]){
        //         st.pop();
        //     }
        //     if(st.size() == 0){
        //         nse[i] = n;
        //     }else{
        //         nse[i] = st.peek();
        //     }
        //     st.push(i);
        // }

        //  // emptying stack
        //  while(st.size()>0) st.pop();

        // //calculate pse
        // st.push(0);
        // pse[0] = -1;
        // for(int i = 1;i<n;i++){
        //     while(st.size()>0 && heights[st.peek()]>=heights[i]){
        //         st.pop();
        //     }
        //     if(st.size() == 0){
        //         pse[i] = -1;
        //     }
        //     else{
        //         pse[i] = st.peek();
        //     }
        //     st.push(i);
        // }

        // //max area of rec==
        // int max = -1;
        // for(int i = 0;i<n;i++){
        //     int area = heights[i]*(nse[i]-pse[i] - 1);
        //     max = Math.max(max,area);
        // }
        // return max;

    }
}