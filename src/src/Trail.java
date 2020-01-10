package src;

import java.awt.*;

public class Trail extends GameObject{
    
    private float alpha = 1;
    private Handler handler;
    private Color color;
    private int width, height;
    private float tail;
    
    //constructor for the Trail()
    public Trail(int x, int y, ID id, Color color, int width, int height, float tail, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        this.color = color;
        this.width = width;
        this.height = height;
        this.tail = tail;
    }

    public void tick() {
        if(alpha > tail){
            alpha -= (tail - 0.0001f);
        }else handler.removeObject(this);
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        /*setComposite specifies how new pixels are combined 
          with the existing pixels on the graphics device 
          during the rendering process*/
        
        //**deals with all 2d graphics, e.g. draw, fill, set
        g2d.setComposite(makeTransparent(alpha));
        
        g.setColor(color);
        g.fillOval((int)x, (int)y, width, height);
        
        g2d.setComposite(makeTransparent(1));
    }
    
    private AlphaComposite makeTransparent(float alpha){
        //overlaps one image onto another without any transparency
        int type = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(type, alpha);
    }

    public Rectangle getBounds() {
        return null;
    }
    
}
