/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.addictivesoftware.games.afagddu.model;

import com.jme3.math.Vector3f;

/**
 *
 * @author gassies
 */
public abstract class Object implements Positionable {
    private String name;
    private String description;
    private Vector3f position;
    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public Vector3f getPosition() {
        return this.position;
    }
    
}
