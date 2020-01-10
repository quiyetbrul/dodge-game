package src;

import java.awt.*;
import java.util.*;

public class EnemyBossBullet extends GameObject {
    
    private Handler handler;
    private int timer = 60;
    private int timer2 = 50;
    Random r = new Random();
    
    private int red = r.nextInt(255);
    private int green = r.nextInt(255);
    private int blue = r.nextInt(255);
    private Color col;


    public EnemyBossBullet(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
        
        velX = (r.nextInt(5 - -5) + -5); 
        velY = 5;
        
        col = new Color(red, green, blue);
    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 10, 10);
    }
    
    public void tick() {
        x += velX;
        y += velY;
        
    if(y >= GameMain.HEIGHT) handler.removeObject(this);

        handler.addObject(new Tail((int)x, (int)y, ID.Trail, col, 10, 10, 0.02f, handler));
    }

    public void render(Graphics g) {
        g.setColor(col);
        g.fillOval((int)x, (int)y, 10, 10);
    }

}
