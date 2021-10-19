class Solution {
      
    private int cntInRange(int[] nums, int majorityNums, int l, int r) {
        int sum = 0;
        
        for (int i = l; i <= r; i++) {
            if (nums[i] == majorityNums) {
                sum++;
            }
        }
        return sum;
    }
    
    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi-lo)/2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid+1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = cntInRange(nums, left, lo, hi);
        int rightCount = cntInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }
    
    private int divideAndConquer(int[] nums, int lo, int hi) {
        if (lo == hi) { // base case: 둘중 첫번째걸 반환
            return nums[lo];
        }
        
        int mid = (hi-lo)/2 + lo;
        int left = divideAndConquer(nums, lo, mid);
        int right = divideAndConquer(nums, mid + 1, hi);
        
        if (left == right) { // (l, mid) or (mid+1, r) 범위에서 많은 빈도가 나오는 수가 같으면 아무거나 반환
            return left;
        }
        
        // 서로 다르다면, 더 빈도가 많은 수를 반환한다
        int leftCount = cntInRange(nums, left, lo, hi);
        int rightCount = cntInRange(nums, right, lo, hi);
        
        return leftCount > rightCount ? left : right; // 서로 다를 경우 어느쪽이 빈도 카운트가 많은지 보고 left, right를 정한다
    }
    
    public int majorityElement(int[] nums) {
        return divideAndConquer(nums, 0, nums.length - 1);
        
    }
  
}