

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        Map<Integer, Integer> map = new HashMap<>();

        
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            
            if (col >= 2 && col <= 9) {
                int mask = map.getOrDefault(row, 0);
                mask |= (1 << col);
                map.put(row, mask);
            }
        }

       
        int ans = (n - map.size()) * 2;

        for (int mask : map.values()) {

           
            boolean left = (mask & 0b0000111100) == 0;

            
            boolean right = (mask & 0b1111000000) == 0;

            boolean middle = (mask & 0b0011110000) == 0;

            if (left && right) {
               
                ans += 2;
            } else if (left || middle || right) {
               
                ans += 1;
            }
        }

        return ans;
    }
}