package net.addictivesoftware.games.afagddu;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Sphere;
import net.addictivesoftware.games.afagddu.model.Planet;

import net.addictivesoftware.games.afagddu.model.Star;
import net.addictivesoftware.games.afagddu.model.Station;

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {
    private Star currentSystem;
    
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        currentSystem = StarLoader.load("assets/Scenes/Sun.xml");
        System.out.println(currentSystem.getName());
        for (Planet planet : currentSystem.getPlanets()) {
            System.out.println(" " + planet.getName());
            for (Station station : planet.getStations()) {
                System.out.println("  " + station.getName());
            }
        }
    }

    @Override
    public void simpleUpdate(float tpf) {
    }

    @Override
    public void simpleRender(RenderManager rm) {
    }
}
