/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.addictivesoftware.games.afagddu;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import net.addictivesoftware.games.afagddu.model.Star;

/**
 *
 * @author gassies
 */
public class StarLoader {
    private static final Logger logger = Logger.getLogger(StarLoader.class.getName());
    
    public static Star load(String name) {
        Star currentStar = null;
        try {
            JAXBContext context = JAXBContext.newInstance("net.addictivesoftware.games.afagddu.model");
            Unmarshaller unmarshaller = context.createUnmarshaller();
            currentStar = (Star) unmarshaller.unmarshal(new File(name));
            
        } catch (JAXBException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        
        return currentStar;
    } 
}
