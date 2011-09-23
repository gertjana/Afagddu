/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.addictivesoftware.games.afagddu.model;

import com.jme3.renderer.RenderManager;
import java.util.List;

/**
 *
 * @author gassies
 */
public class System extends Object implements Updatable, Renderable {
    private List<Planet> planets;

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }
    
    public void update(float tpf) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void render(RenderManager rm) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
