package src;

import java.awt.*;
import java.util.*;

public class EnemyBoss extends GameObject {
    
    private Handler handler;
    private int timer = 80;
    private int timer2 = 50;
    Random r = new Random();
    private int red = r.nextInt(255);
    private int green = r.nextInt(255);
    private int blue = r.nextInt(255);
    private Color col;


    public EnemyBoss(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
        
        velX = 0; 
        velY = 2;
        
        col = new Color(red, green, blue);
    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 96, 96);
    }
    
    public void tick() {
        x += velX;
        y += velY;
        
        if(timer <= 0) velY = 0;
        else timer--;
        
        if(timer <= 0) timer2--;
        if(timer2 <= 0)
        {
            if(velX == 0) velX = 2;
            
            if(velX > 0) velX += 0.005f;
            else if(velX < 0) velX-= 0.005f;
            
            velX = GameMain.clamp((int)velX, -10, 10);
            
            int spawn = r.nextInt(10);
            if(spawn == 0) handler.addObject(new EnemyBossBullet((int) x+48, (int) y+48, ID.EnemyBasic, handler));
        }
        
        if(x<=0 || x >= GameMain.WIDTH - 96) velX *= -1;
        
    }

    public void render(Graphics g) {
        g.setColor(col);
        g.fillRect((int)x, (int)y, 96, 96);
    }

}
