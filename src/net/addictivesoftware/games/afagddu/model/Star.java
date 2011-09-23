/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.addictivesoftware.games.afagddu.model;

import com.jme3.renderer.RenderManager;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gassies
 */
@XmlRootElement(name="System")
public class Star extends Object implements Updatable, Renderable {

    @XmlElement(name="Planets")
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
    
    public static Star load(String name) {
        Star system = null;
        try {
            JAXBContext jc = JAXBContext.newInstance("net.addictivesoftware.games.afagddu.model");
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            system = (Star) unmarshaller.unmarshal(new File("Scenes/Sun.xml"));
            
            
        } catch (JAXBException ex) {
            Logger.getLogger(Star.class.getName()).log(Level.SEVERE, null, ex);
        }
        return system;
    } 

}
