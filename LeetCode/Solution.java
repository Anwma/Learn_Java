public class Solution {
    public int findFirstBadVersion(int n) {
        // write your code here
        int l = 1, r = n;
        for (; l <= r; ) {
            int m = l + (r - l) >> 1;
            if (isBadVersion(m)) {
                r = m - 1;
                continue;
            }
            l = m + 1;
        }
        return l;
    }

    private boolean isBadVersion(int m) {
        return true;
    }
}
