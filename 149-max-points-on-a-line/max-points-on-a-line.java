class Solution {
    public int maxPoints(int[][] points) {

        int n = points.length;
        if(n <= 2) return n;

        int result = 0;

        for(int i = 0; i < n; i++){

            HashMap<Long, Integer> map = new HashMap<>();
            int duplicates = 1;
            int max = 0;

            for(int j = i + 1; j < n; j++){

                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                // duplicate points
                if(dx == 0 && dy == 0){
                    duplicates++;
                    continue;
                }

                int g = gcd(dx, dy);
                dx /= g;
                dy /= g;

                // store slope as a long key
                long key = (((long)dx) << 32) | (dy & 0xffffffffL);

                int count = map.getOrDefault(key, 0) + 1;
                map.put(key, count);

                max = Math.max(max, count);
            }

            result = Math.max(result, max + duplicates);
        }

        return result;
    }

    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}