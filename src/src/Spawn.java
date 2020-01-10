package src;

import java.util.*;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private Random r = new Random();

    private int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick() {
        scoreKeep++;

        if (scoreKeep >= 300) {
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);

            switch (hud.getLevel()) {
                case 1:
                    handler.addObject(new EnemyBasic(r.nextInt(GameMain.WIDTH - 50), r.nextInt(GameMain.HEIGHT - 50), ID.EnemyBasic, handler));
                    break;
                case 2:
                    handler.addObject(new EnemyBasic(r.nextInt(GameMain.WIDTH - 50), r.nextInt(GameMain.HEIGHT - 50), ID.EnemyBasic, handler));
                    break;
                case 3:
                    handler.addObject(new EnemyFast(r.nextInt(GameMain.WIDTH - 50), r.nextInt(GameMain.HEIGHT - 50), ID.EnemyFast, handler));
                    break;
                case 4:
                    handler.addObject(new EnemyFast(r.nextInt(GameMain.WIDTH - 50), r.nextInt(GameMain.HEIGHT - 50), ID.EnemyFast, handler));
                    break;
                case 5:
                    handler.addObject(new EnemySmart(r.nextInt(GameMain.WIDTH - 50), r.nextInt(GameMain.HEIGHT - 50), ID.EnemySmart, handler));
                    handler.addObject(new EnemySmart(r.nextInt(GameMain.WIDTH - 50), r.nextInt(GameMain.HEIGHT - 50), ID.EnemySmart, handler));
                    handler.addObject(new EnemySmart(r.nextInt(GameMain.WIDTH - 50), r.nextInt(GameMain.HEIGHT - 50), ID.EnemySmart, handler));
                    break;
                case 6:
                    handler.addObject(new EnemySmart(r.nextInt(GameMain.WIDTH - 50), r.nextInt(GameMain.HEIGHT - 50), ID.EnemySmart, handler));
                    handler.addObject(new EnemyFast(r.nextInt(GameMain.WIDTH - 50), r.nextInt(GameMain.HEIGHT - 50), ID.EnemyFast, handler));
                    break;
                case 7:
                    handler.addObject(new EnemyBasic(r.nextInt(GameMain.WIDTH - 50), r.nextInt(GameMain.HEIGHT - 50), ID.EnemyBasic, handler));
                    break;
                case 8:
                    handler.addObject(new EnemySmart(r.nextInt(GameMain.WIDTH - 50), r.nextInt(GameMain.HEIGHT - 50), ID.EnemySmart, handler));
                    break;
                case 9:
                    handler.addObject(new EnemySmart(r.nextInt(GameMain.WIDTH - 50), r.nextInt(GameMain.HEIGHT - 50), ID.EnemySmart, handler));
                    break;
                case 10:
                    handler.EnemyClear();
                    handler.addObject(new EnemyBoss(r.nextInt(GameMain.WIDTH / 2) - 48, -120, ID.EnemyBoss, handler));
                    handler.addObject(new EnemySmart(r.nextInt(GameMain.WIDTH - 50), r.nextInt(GameMain.HEIGHT - 50), ID.EnemySmart, handler));
                    handler.addObject(new EnemyFast(r.nextInt(GameMain.WIDTH - 50), r.nextInt(GameMain.HEIGHT - 50), ID.EnemyFast, handler));
                    handler.addObject(new EnemyBasic(r.nextInt(GameMain.WIDTH - 50), r.nextInt(GameMain.HEIGHT - 50), ID.EnemyBasic, handler));
                    break;
                case 11:
//                    handler.EnemyClear();
                    handler.addObject(new EnemySmart(r.nextInt(GameMain.WIDTH - 50), r.nextInt(GameMain.HEIGHT - 50), ID.EnemySmart, handler));
                    handler.addObject(new EnemyBasic(r.nextInt(GameMain.WIDTH - 50), r.nextInt(GameMain.HEIGHT - 50), ID.EnemyBasic, handler));
                    handler.addObject(new EnemyBasic(r.nextInt(GameMain.WIDTH - 50), r.nextInt(GameMain.HEIGHT - 50), ID.EnemyBasic, handler));
                    handler.addObject(new EnemyFast(r.nextInt(GameMain.WIDTH - 50), r.nextInt(GameMain.HEIGHT - 50), ID.EnemyFast, handler));
                    break;
                case 13:
                    handler.addObject(new EnemyBasic(r.nextInt(GameMain.WIDTH - 50), r.nextInt(GameMain.HEIGHT - 50), ID.EnemyBasic, handler));
                    handler.addObject(new EnemySmart(r.nextInt(GameMain.WIDTH - 50), r.nextInt(GameMain.HEIGHT - 50), ID.EnemySmart, handler));
                    break;
                case 15:
//                    handler.EnemyClear();
                    handler.addObject(new EnemyBoss(r.nextInt(GameMain.WIDTH / 2) - 48, -120, ID.EnemyBoss, handler));
                    break;
                default:
                    break;
            }
        }
    }
}
