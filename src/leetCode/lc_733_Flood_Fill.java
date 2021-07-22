package leetCode;

public class lc_733_Flood_Fill {
    public static void main(String[] args) {
        int[][] image = {
                    {1, 1,  1},
                    {1, 1, 0},
                    {1, 0, 1}};
        int row = 1, col = 1;
        int newColor = 2;
        int[][] newImage = (floodFill(image,row, col, newColor));
        for(int r = 0; r < newImage.length; r++){
            for(int c = 0; c < newImage[r].length;c++){
                System.out.print(newImage[r][c] + " " + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        int color = image[sr][sc];
        fill(image, sr, sc, color, newColor);
        return image;
    }

    public static void fill(int[][] image, int sr, int sc, int color, int newColor){
        if ( sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != color){
            return;
        }
        image[sr][sc] = newColor;
        // top
        fill(image, sr - 1, sc, color, newColor);
        // bottom
        fill(image, sr + 1, sc, color, newColor);
        // left
        fill(image, sr , sc - 1, color, newColor);
        // right
        fill(image, sr , sc + 1, color, newColor);
    }
}
/*
    // Depth First Search
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor){
            dfs(image, sr, sc, color, newColor);
        }
        return image;
    }

    // Time O(n) => n is number of pixels in the image
    // Space O(n) due to implicit recursive call stack
    public static void dfs(int[][] image, int sr, int sc, int color, int newColor){
        if (image[sr][sc] == color){
            image[sr][sc] = newColor;
            // top
            if (sr >= 1) dfs(image, sr-1, sc, color, newColor );
            // left
            if (sc >= 1) dfs(image, sr, sc -1, color, newColor);
            // bottom
            if ( sr+1 < image.length) dfs(image, sr +1, sc, color, newColor);
            // right
            if (sc+1 < image[0].length) dfs(image, sr, sc+ 1, color, newColor);
        }
    }
 */