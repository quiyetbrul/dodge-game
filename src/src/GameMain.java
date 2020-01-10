package src;

import java.awt.*;
import java.awt.image.*;
import java.util.*;

public class GameMain extends Canvas implements Runnable {

    private static final long serialVersionUID = 4730308219818161523L;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    private Thread thread;
    private boolean running = false;

    private Random r;
    private Handler handler;
    private HUD hud;
    private Spawn spawner;
    private GameMenu menu;

    public enum GAME_STATE {
        Menu, Help, Game, GameOver
    }

    public static GAME_STATE gameStart = GAME_STATE.Menu;

    public GameMain() {
        handler = new Handler();
        hud = new HUD();
        menu = new GameMenu(this, handler, hud);
        this.addMouseListener(menu);
        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "DODGE", this);

        spawner = new Spawn(handler, hud);

        r = new Random();

        if (gameStart == GAME_STATE.Game) {
            handler.addObject(new Player(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.Player, handler));
            handler.addObject(new EnemyBasic(r.nextInt(GameMain.WIDTH - 50), r.nextInt(GameMain.HEIGHT - 50),
                    ID.EnemyBasic, handler));

        } else {
            for (int i = 0; i < 15; i++) {
                handler.addObject(new GameMenuSparks(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.GameMenuSparks, handler));

            }
        }
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;

        } catch (InterruptedException e) {
        }
    }

    // fps //game loops
    // research part: renders game as fast as it can
    /* resolves large amount of collisions per frame, dragging the performance. */
    /* calls tick() at a steady frequency to make the game stable */
    /*
     * improvement: avoid using System.currentTimeMillis() it is susceptible to
     * changing the system clock
     */
    /*
     * research other or create game loops that offer variable timestep but doesn't
     * wreck game physics computations
     */

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);

                frames = 0;
            }
        }
        stop();
    }

    // updates the game at the rate specified in function run()
    private void tick() {
        handler.tick();
        if (gameStart == GAME_STATE.Game) {
            hud.tick();
            spawner.tick();

            // determines user health + game over
            if (HUD.HEALTH <= 0) {
                HUD.HEALTH = 100;
                gameStart = GAME_STATE.GameOver;
                handler.EnemyClear();

            } else if (gameStart == GAME_STATE.Menu || gameStart == GAME_STATE.GameOver) {
                menu.tick();
            }
        }
    }

    // screen
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        if (gameStart == GAME_STATE.Game) {
            hud.render(g);
        } else if (gameStart == GAME_STATE.Menu || gameStart == GAME_STATE.Help || gameStart == GAME_STATE.GameOver) {
            menu.render(g);
        }

        g.dispose();
        bs.show();
    }

    // Clamps the elapsed time from the game loop
    /*
     * Without this, objects can possibly be led tunneling through other objects or
     * getting out of bounds
     */
    public static int clamp(int var, int min, int max) {

        // Clamping means literally in this instance.
        //// it's used to restrict a value to a given range
        if (var >= max) {
            return var = max;
        } else if (var <= min) {
            return var = min;
        } else {
            return var;
        }
    }

    public static void main(String args[]) {
        new GameMain();
    }
}
