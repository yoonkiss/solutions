class Solution {
    public int coinChange(int[] coins, int amount) {
        // f(n) : 동전으로 n금액을 만들 수 있는 최소 개수
        // f(n) = Min(f(n-1), f(n-2), f(n-5)) + 1
        if (amount == 0) {
            return 0;
        }
        int[] ret = new int[amount+1];
        
        Arrays.fill(ret, -1);
        ret[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && ret[i - coins[j]] != -1 ) {
                    if (ret[i] == -1) { // initialize
                        ret[i] = ret[i - coins[j]] + 1;
                    } else {
                        ret[i] = Math.min(ret[i], ret[i - coins[j]] + 1);
                    }
                }
            }
        }
        
        return ret[amount];
    }
}