package net.addictivesoftware.games.afagddu;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.material.RenderState.BlendMode;
import com.jme3.material.RenderState.FaceCullMode;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Matrix3f;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.queue.RenderQueue.Bucket;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Quad;
import com.jme3.scene.shape.Sphere;
import com.jme3.util.TangentBinormalGenerator;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.addictivesoftware.games.afagddu.model.Planet;
import net.addictivesoftware.games.afagddu.model.Position;
import net.addictivesoftware.games.afagddu.model.Star;

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {
    private Star currentSystem;
    
    public static void main(String[] args) {
        try {
            Main app = new Main();
            app.start();            
        } catch (Exception e) {
            System.exit(1);
        }
    }

    @Override
    public void simpleInitApp() {
        currentSystem = StarLoader.load("assets/Scenes/Sun.xml");
        renderStar();
        rootNode.setLocalTranslation(0f, 0f, -30.0f);
        rootNode.setLocalRotation(new Quaternion().fromAngleAxis(FastMath.PI/8, new Vector3f(1,0,1)));
    }

    @Override
    public void simpleUpdate(float tpf) {
    }

    @Override
    public void simpleRender(RenderManager rm) {
    }
    
    
    private String PositionToString(Position p) {
        if (null == p) return "[null]";
        return " [" + p.getX() + ", " + p.getY() + ", " + p.getZ() + "]"; 
    }

    private ColorRGBA StringToColorRGBA(String color) {
        try {
            return (ColorRGBA)ColorRGBA.class.getDeclaredField(color).get(null);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private void renderStar() {
    
        float size = currentSystem.getRenderInfo().getSize();    

        /** Bumpy rock with shiny light effect. Uses Texture from jme3-test-data library! Needs light source! */
        Sphere rock = new Sphere(32,32, size);
        Geometry starGeo = new Geometry("Shiny rock", rock);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/SolidColor.j3md");
        mat.setColor("Color", StringToColorRGBA(currentSystem.getRenderInfo().getColor()));
        starGeo.setMaterial(mat);
//        rock.setTextureMode(Sphere.TextureMode.Projected); // better quality on spheres
//        TangentBinormalGenerator.generate(rock);           // for lighting effect
//        Material mat_lit = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
//        mat_lit.setTexture("DiffuseMap", assetManager.loadTexture("Textures/Terrain/Pond/Pond.png"));
//        mat_lit.setTexture("NormalMap", assetManager.loadTexture("Textures/Terrain/Pond/Pond_normal.png"));
//        mat_lit.setFloat("Shininess", 5f); // [0,128]
//        starGeo.setMaterial(mat_lit);
        Node starNode = new Node();
        starNode.attachChild(starGeo);

        for (Planet planet : currentSystem.getPlanets()) {
            Sphere planetSphere = new Sphere(32, 32, planet.getRenderInfo().getSize());
            
            Geometry planetGeo = new Geometry(planet.getName(), planetSphere);
            planetGeo.setLocalTranslation(
                    planet.getPosition().getX(), 
                    planet.getPosition().getY(), 
                    planet.getPosition().getZ());
            mat = new Material(assetManager, "Common/MatDefs/Misc/SolidColor.j3md");
            mat.setColor("Color", StringToColorRGBA(planet.getRenderInfo().getColor()));

            planetGeo.setMaterial(mat);
            starNode.attachChild(planetGeo);
        }

        Box boxshape3 = new Box(Vector3f.ZERO, 24f,0.001f,24f);
        Geometry plane = new Geometry("translucent cube", boxshape3);
        Material mat_tt = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_tt.setTexture("ColorMap", assetManager.loadTexture("Textures/grid.png"));
        mat_tt.getAdditionalRenderState().setBlendMode(BlendMode.Alpha);
        plane.setMaterial(mat_tt); 
        
        plane.setQueueBucket(Bucket.Transparent);
        
        rootNode.attachChild(plane);
        rootNode.attachChild(starNode);

    } 

}
