package src;

import java.awt.*;

public abstract class GameObject { 

    //constructor + mutator and accessor
    //takes care of the values in the x and y direction
    //takes care of speed in the x and y direction
    
    protected float x, y;
    protected ID id;
    protected float velX, velY;

    public GameObject(float x, float y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();

    public abstract void render(Graphics g);
    
    public abstract Rectangle getBounds();

    public void setX(float x) {
        this.x = x;
    }
    public float getX() {
        return x;
    }

    public void setY(float y) {
        this.y = y;
    }
    public float getY() {
        return y;
    }

    public void setId(ID id) {
        this.id = id;
    }
    public ID getId() {
        return id;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }
    public float getVelX() {
        return velX;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }
    public float getVelY() {
        return velY;
    }

}
