package OOP.Basics;

public class Arrays_2D {
    public static void main(String[] args) {
        // [rows][column]
        int[][] array = new int[4][2];
        int[][] array1 = new int[][]{
                {3,4},
                {5,6},
                {6,7},
                {8,9}
        };
        // Array with fixed rows, not fixed col
        int[][] array2 = new int[2][];
        // length returns row length
        System.out.println(array.length);

        int[][][] array3D = new int[][][]{
                {
                        {0,0,0},
                        {0,0,0},
                        {0,850,0}
                }
        };
        System.out.println("Inside 3D Arrays....");
        System.out.println(array3D[0][0][1]);
    }
}

/*
        0   1
    0   9   11
    2   2   5
    3   4   4
    4   6   13

    JVM implements 2D array as 1D array
    -----------------------------------
    [0][0]  [0][1]

    array of array of int

    array =
    length

    Electric Store - Sales Data
    TV
    iPad                New York
            Jan Feb Mar

 */
