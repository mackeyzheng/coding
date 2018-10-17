class Solution {
    // 1D overlap condition: left1 < right2 && left2 < right1
    // expand to 2D
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (rec1[0] < rec2[2] && rec2[0] < rec1[2]) && // x dimension
                (rec1[1] < rec2[3] && rec2[1] < rec1[3]); // y dimension
    }
}
