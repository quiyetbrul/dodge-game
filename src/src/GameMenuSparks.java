package src;

import java.awt.*;
import java.util.*;

public class GameMenuSparks extends GameObject {

    private Handler handler;

    Random r = new Random();

    private int red = r.nextInt(255);
    private int green = r.nextInt(255);
    private int blue = r.nextInt(255);
    private Color col;

    public GameMenuSparks(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        do{
        velX = (r.nextInt(5 - -5) + -5);
        velY = (r.nextInt(5 - -5) + -5);
        }while(velX == 0 && velY == 0);
        
        col = new Color(red, green, blue);

    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= GameMain.HEIGHT - 36) {
            velY *= -1;
        }
        if (x <= 0 || x >= GameMain.WIDTH - 16) {
            velX *= -1;
        }

        handler.addObject(new Tail((int) x, (int) y, ID.Trail, col, 16, 16, 0.05f, handler));
    }

    public void render(Graphics g) {
        g.setColor(col);
        g.fillOval((int) x, (int) y, 16, 16);
    }

}
