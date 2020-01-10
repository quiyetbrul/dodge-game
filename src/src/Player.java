package src;

import java.awt.*;
import java.util.*;

public class Player extends GameObject {
    
    Random r = new Random();
    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }
    
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 32, 32);
    }

    public void tick() {
        x += velX;
        y += velY;
        
        x = GameMain.clamp((int)x, 0, GameMain.WIDTH -33);
        y = GameMain.clamp((int)y, 0, GameMain.HEIGHT - 64);
        
        //player character
        handler.addObject(new Tail((int)x, (int)y, ID.Trail, Color.white, 32, 32, 0.05f, handler));        

        collision();
    }
    
    private void collision(){
        for(int i = 0; i < handler.object.size(); i++){
            GameObject player = handler.object.get(i);
            
            if(player.getId() == ID.EnemyBasic 
                    || player.getId() == ID.EnemyFast
                    || player.getId() == ID.EnemySmart
                    || player.getId() == ID.EnemyBoss){
                if(getBounds().intersects(player.getBounds())){
                    HUD.HEALTH -= 2;
                }
            }
        }
    }

    public void render(Graphics g) {       
        g.setColor(Color.white);
        g.fillOval((int)x, (int)y, 32, 32);
    }
}
