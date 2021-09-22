class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        for (int i = 0; i < numRows; i++) {
            ret.add(new ArrayList<>());
            // f(i, j) = f(i-1, j-1) + f(i-1,j), i-1 > 0, j-1 > 0
            // f(i, j) = 1, if j = 0 or j = numRows - 1
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    ret.get(i).add(1);
                } else if (j == i ) {
                    ret.get(i).add(1);
                } else {
                    int sum = ret.get(i-1).get(j-1) + ret.get(i-1).get(j);
                    ret.get(i).add(sum);
                }
            }
        }
        return ret;
    }
}