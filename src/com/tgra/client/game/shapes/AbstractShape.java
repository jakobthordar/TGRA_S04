package com.tgra.client.game.shapes;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;
import com.tgra.client.utility.Texture;
import com.badlogic.gdx.math.collision.BoundingBox;

/**
 * <h1>AbstractShape</h1>
 * <h2>com.tgra.client.game.shapes</h2>
 * <p></p>
 * Created on 18.11.2014.
 *
 * @author jakob
 * @version 1.1
 */
public abstract class AbstractShape implements Shape {
    protected BoundingBox box;
    protected ModelInstance shapeInstance;
    protected BoundingBox boundingBox;
    protected Vector3 center;
    protected Texture texture;

    @Override
    public Vector3 getPosition() {
        return center;
    }

    @Override
    public void setRotation(float degrees, Vector3 axis) {
        shapeInstance.transform.rotate(axis, degrees);
        shapeInstance.calculateTransforms();
    }

    @Override
    public void translate(Vector3 motion) {
        shapeInstance.transform.translate(motion);
        shapeInstance.calculateTransforms();
    }

    @Override
    public void translate(float x, float y, float z) {
        shapeInstance.transform.translate(x, y ,z);
        shapeInstance.calculateTransforms();
    }

    @Override
    public boolean isHit(BoundingBox player) {
        System.out.println("------------------");
        System.out.println("Player : " + player);
        System.out.println("Shapes Center : " + box.getCenter());
        System.out.println("Shape Height : " + box.getHeight());
        System.out.println("------------------");


        return box.contains(player);
    }
}
