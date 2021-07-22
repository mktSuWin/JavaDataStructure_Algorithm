package leetCode;

public class lc_836_RectangleOverlap {
    public static void main(String[] args) {

    }
    /*
    Pattern - 2D
    In 1D scenario
    Possible Intersections between two segments
    case 1:
    =======
    1. left1 < x < right1 &&  left2 <x< right2
    2. left1 <x < right2 && left2 < x< right1
    3. left1 < right2 && left2 < right1

    2D pane,

    left1        right1
    --------------------
        left2           right2
        ------------------------

    case 2:
    ========
    left1        right1
    --------------------
                            left2           right2
                            ------------------------

    case 3:
    =======
                             left1        right1
                             --------------------
        left2           right2
        ------------------------
        x1  y1  x2  y2
index   0   1   2   3
rec1    0   0   2   2
x-axis  0   2
y-axis  0   2
rec2    1   1   3   3

     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2){
        // left1 < right2 && left2 < right1
        // x-axis : 0 2
        // for x-axis
        return
        rec1[0] < rec2[2] && rec2[2] < rec1[2] &&
        // for y-axis
        rec1[1] < rec2[3] && rec2[1] < rec1[3];

    }
}
