class Solution {
    public boolean canJump(int[] A) {
        int max = 0; // 갈 수 있는 최대
        for(int i = 0; i < A.length; i++){
            if (i > max) { // 갈 수 있는 최대치로 현재위치에 올 수 없다면  
                return false;
            }
            max = Math.max(A[i] + i, max);
        }
        return true;
    }
}