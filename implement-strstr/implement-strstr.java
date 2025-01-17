class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) {
			return 0;
		}
		if(haystack.length() < needle.length()) {
			return -1;
		}
		if(haystack.length() == needle.length()) {
			return haystack.equals(needle) ? 0 : -1;
		}
		for(int i=0; i < haystack.length(); i++) {
			int hIndex = i;
			int nIndex = 0;
			while(hIndex < haystack.length() && nIndex < needle.length() && haystack.charAt(hIndex) == needle.charAt(nIndex)) {
				hIndex++;
				nIndex++;
			}
			if(nIndex == needle.length()) {
				return i;
			}
		}
		return -1;
        
    }
}