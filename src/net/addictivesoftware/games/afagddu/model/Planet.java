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
class Planet extends Object {
    private List<Stations> stations;
    private List<Belts> belts;

    public List<Belts> getBelts() {
        return belts;
    }

    public void setBelts(List<Belts> belts) {
        this.belts = belts;
    }

    public List<Stations> getStations() {
        return stations;
    }

    public void setStations(List<Stations> stations) {
        this.stations = stations;
    }
    
}
