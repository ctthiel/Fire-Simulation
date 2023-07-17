import processing.core.PApplet;


public class GridVis {

    private PApplet pApplet;

    private final int [][] COLOR = {
            {255, 255, 255},       // white
            {  0, 255,   0},       // green
            {255,   0,   0},       // red
            {  0,   0, 255},       // blue
            {  0,   0,   0},       // black
            {255, 204,   0}        // yellow
    };

    public final int WHITE  = 0;
    public final int GREEN  = 1;
    public final int RED    = 2;
    public final int BLUE   = 3;
    public final int BLACK  = 4;
    public final int YELLOW = 5;

    public GridVis(PApplet pApplet) {
        this.pApplet = pApplet;
    }

    public void draw(int [][] grid) {
        int width = pApplet.width / grid[0].length;
        int height = pApplet.height / grid.length;

        pApplet.noStroke();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                int value = grid[r][c];
                pApplet.fill(COLOR[value][0],
                        COLOR[value][1],
                        COLOR[value][2]);
                pApplet.rect(c * width, r * height, width, height);
            }
        }
    }

}
