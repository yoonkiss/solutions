class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        
        backtrack(list, new ArrayList<>(), candidates, target, 0, 0);
        return list;
        
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] candidates, int target, int sum, int start){
        if (sum > target) {
            return;
        } 
        if(sum == target){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = start; i < candidates.length; i++){
                //if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(candidates[i]);
                backtrack(list, tempList, candidates, target, sum + candidates[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}