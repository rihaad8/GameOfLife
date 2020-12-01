package Game;

public class GameOfLife {
    public int[][] startGameOfLife(int WIDTH, int HEIGHT, int[] coordinates) {
        int lifeArea[][] = new int[WIDTH][HEIGHT];
        lifeArea = fillArea(lifeArea, coordinates);
        return lifeArea;
    }

    public int[][] nextGen(int[][] currentGenArea,int currentHeight, int currentWidth){
        int[][] nextGenArea = new int[currentWidth][currentHeight];
        for (int i = 0; i < currentGenArea.length; i++) {
            for (int j = 0; j < currentGenArea.length; j++) {
                nextGenArea[i][j] = currentGenArea[i][j];
            }
        }
        for (int i = 0; i < nextGenArea.length; i++) {
            for (int j = 0; j < nextGenArea.length; j++) {
                int nCount = countNeighbours(currentGenArea, i, j);
                if (nCount <= 1 ^ nCount >= 4) {
                    killCell(nextGenArea, i, j);
                } else if (nCount == 3) {
                    birthCell(nextGenArea, i, j);
                }
            }
        }
        System.out.println();
        printMatrix(nextGenArea);
        return nextGenArea;
    }

    private int[][] fillArea(int[][] lifeArea, int[] coordinates){
        for (int i = 0; i < lifeArea.length; i++) {
            for (int j = 0; j < lifeArea.length; j++) {
                lifeArea[i][j] = 0;
            }
        }
        for (int i = 0; i <coordinates.length;i++){
            lifeArea[coordinates[i]][coordinates[i+1]] = 1;
            i++;
        }
        printMatrix(lifeArea);
        return lifeArea;
    }

    private void printMatrix(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j] + " ");

            }
            System.out.println();
        }
    }

    private int countNeighbours(int grid[][], int i, int j) {
        int count = 0;
        if ((i != 0) && (j != 0)) {
            if (grid[i - 1][j - 1] == 1) {
                count++;
            }
        }
        if (i != 0) {
            if (grid[i - 1][j] == 1) {
                count++;
            }
        }
        if ((i != 0) && (j < (grid.length) - 1)) {
            if (grid[i - 1][j + 1] == 1) {
                count++;
            }
        }
        if (j > 0) {
            if (grid[i][j - 1] == 1) {
                count++;
            }
        }
        if (j < (grid.length) - 1) {
            if (grid[i][j + 1] == 1) {
                count++;
            }
        }
        if ((i < (grid.length) - 1) && (j != 0)) {
            if (grid[i + 1][j - 1] == 1) {
                count++;
            }
        }
        if (i < (grid.length - 1)) {
            if (grid[i + 1][j] == 1) {
                count++;
            }
        }
        if ((i < (grid.length) - 1) && (j < (grid.length) - 1)) {
            if (grid[i + 1][j + 1] == 1) {
                count++;
            }
        }

        // System.out.println((count));
        return count;

    }

    public int countLife(int[][] grid){
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }

    private void killCell(int grid[][], int i, int j) {
        grid[i][j] = 0;
    }

    private void birthCell(int grid[][], int i, int j) {
        grid[i][j] = 1;
    }
}
