class Solution {
    
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num:hand) pq.add(num);
        while(!pq.isEmpty()){
            int smallest = pq.peek();
            for(int i = 0;i<groupSize;i++){
                if(!pq.contains(smallest + i)) return false;
                else pq.remove(smallest +i);
            }
        }
        return true;
    }
}
/*
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
for(int i : hand){
    minHeap.add(i);
}
while(minHeap.size() != 0) {
    int start = minHeap.poll();
    for(int j = 1; j < W; j++){
        if(minHeap.remove(start + j)) {
            continue;
        }
        else {
            return false;
        }
    }
}
return true;

public static boolean isNStraightHand(int[] hand, int W) {
    if (hand == null || hand.length == 0) return true;
    if (hand.length % W != 0) return false;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int curr : hand) map.put(curr, map.getOrDefault(curr, 0) + 1);     // O(nlogn) time.
    while (map.size() > 0) {
        // Try creating the next group of W consecutive cards.
        int start = map.firstKey();                 // O(logn) time.
        for (int i = start; i < start + W; ++i) {
            if (!map.containsKey(i)) return false;  // O(logn) time.
            map.put(i, map.get(i) - 1);             // O(logn) time.
            if (map.get(i) == 0) map.remove(i);     // O(logn) time.
        }
    }
    return true;
}
*/
