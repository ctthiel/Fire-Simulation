import processing.core.PApplet;

/**
* Main for the Fire Simulation
 *
 * @author J.Hollingsworth and Carter Thiel
*/

public class Main extends PApplet {

    public static void main(String[] args) {
        PApplet.main(new String[]{Main.class.getName()});
    }

    private GridVis gridVis;
    private FireSim fireSim;

    @Override
    public void settings() {
        size(600, 600);

        gridVis = new GridVis(this);
        fireSim = new FireSim("forest_1.txt", .6);
        System.out.println(fireSim);

    }

    @Override
    public void setup() {

    }
    // Main method draw calls oneStep method from FireSim, and passes current grid from FireSim to GridVis.
    @Override
    public void draw() {
        gridVis.draw(fireSim.getGrid());
        fireSim.oneStep();
        delay(1000);

    }

}

