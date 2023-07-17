import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FireSim {
    public final int EMPTY = 0;
    public final int TREE = 1;
    public final int BURNING = 2;

    private int [][] forest;
    private double probCatch;

    public FireSim(String fileName, double probCatch) {
        File file = new File("forest_1.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(fileName + " is invalid.");
            System.exit(0);
        }

        // get n and m
        int n = sc.nextInt();
        int m = sc.nextInt();
        this.probCatch = probCatch;

        // fill the forest array with data
        forest = new int[n + 2][m + 2];

        for (int r = 1; r < forest.length - 1; r++) {
            for (int c = 1; c < forest[r].length - 1; c++) {
                forest[r][c] = sc.nextInt();
            }
        }
    }

    // Spread determines what will happen in the next time increment depending on the values and their position.
    public int spread(int site, int north, int east, int south, int west) {
        if(site == EMPTY) {
            return EMPTY;
        }

        if(site == BURNING) {
            return EMPTY;
        }

        if(site == TREE && (north == BURNING || east == BURNING || south == BURNING || west == BURNING)) {
            if (Math.random() < probCatch) {
                return BURNING;
            }
        }
        return TREE;
        }

        // Shows what will happen to the forest after one time increment
    public void oneStep() {
            int [][] newGrid = new int [forest.length][forest[0].length];

            for (int r = 1; r < forest.length - 1; r++) {
                for (int c = 1; c < forest[r].length - 1; c++) {
                    int site = forest[r][c];
                    int north = forest[r][c + 1];
                    int east = forest[r + 1][c];
                    int south = forest[r][c - 1];
                    int west = forest[r - 1][c];
                    newGrid[r][c] = spread(site, north, east, south, west);

                }
            }
        forest = newGrid;
        }

    public int[][] getGrid() {
        return forest;
    }


    public String toString() {
        String str = "";

        for (int r = 0; r < forest.length; r++) {
            for (int c = 0; c < forest[r].length; c++) {
                str += forest[r][c] + "  ";
            }
            str += "\n";
        }

        return str;
    }

}