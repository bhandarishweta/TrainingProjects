package in.stackroute;

public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix solver = new Search2DMatrix();

        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        int target = 5;

        System.out.println("Target " + target + " found: " + solver.searchMatrix(matrix, target));
        target = 20;
        System.out.println("Target " + target + " found: " + solver.searchMatrix(matrix, target));
    }
}
