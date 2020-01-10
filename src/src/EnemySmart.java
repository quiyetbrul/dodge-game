package src;

import java.awt.*;
import java.util.Random;

public class EnemySmart extends GameObject {

    private Handler handler;
    private GameObject player;
    
    Random r = new Random();

    private int red = r.nextInt(255);
    private int green = r.nextInt(255);
    private int blue = r.nextInt(255);
    private Color col;

    public EnemySmart(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        for (int i = 0; i < handler.object.size(); i++) {
            if (handler.object.get(i).getId() == ID.Player) {
                player = handler.object.get(i);
            }
        }

        velX = 40;
        velY = 45;
        
        col = new Color(red, green, blue);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    public void tick() {
        x += velX;
        y += velY;
        
        float diffX = x - player.getX() - 8;
        float diffY = y - player.getY() - 8;
        float distance = (float) Math.sqrt(Math.pow(x - player.getX(), 2) + Math.pow(y - player.getY(), 2));

        velX = (float) ((-1.0 / distance) * diffX);
        velY = (float) ((-1.0 / distance) * diffY);

        if (y <= 0 || y >= GameMain.HEIGHT - 36) {
            velY *= -1;
        }
        if (x <= 0 || x >= GameMain.WIDTH - 16) {
            velX *= -1;
        }

        handler.addObject(new Tail((int) x, (int) y, ID.Trail, col, 16, 16, 0.02f, handler));
    }

    public void render(Graphics g) {
        g.setColor(col);
        g.fillRect((int) x, (int) y, 16, 16);
    }
}
