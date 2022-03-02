package uet.oop.bomberman.utils;

import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.ActiveEntity.ActiveEntity;
import uet.oop.bomberman.entities.ActiveEntity.Brick;
import uet.oop.bomberman.entities.ActiveEntity.Portal;
import uet.oop.bomberman.entities.ActiveEntity.Powerup.PowerUpFlames;
import uet.oop.bomberman.entities.ActiveEntity.Powerup.PowerUpMoreBombs;
import uet.oop.bomberman.entities.ActiveEntity.Powerup.PowerUpSpeed;
import uet.oop.bomberman.entities.ActiveEntity.Powerup.PowerUpWallpass;
import uet.oop.bomberman.entities.ActiveEntity.moveable.Enemy.*;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.StillEntity.Grass;
import uet.oop.bomberman.entities.StillEntity.Wall;
import uet.oop.bomberman.graphics.Sprite;

import java.io.FileReader;
import java.util.Scanner;

public class MapReader {

    // Đọc map
    public static char[][] ReadMap(String filedir) {
        char[][] map = new char[BombermanGame.HEIGHT][BombermanGame.WIDTH];
        int level = 1;
        int height = 0;
        int width = 0;
        try {
            FileReader file = new FileReader(filedir);
            Scanner sc = new Scanner(file);
            level = sc.nextInt();
            height = sc.nextInt();
            width = sc.nextInt();
            map = new char[BombermanGame.HEIGHT][BombermanGame.WIDTH];
            sc.nextLine();

            for (int i = 0; i < height; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < width; j++)
                    map[i][j] = line.charAt(j);
            }
            sc.close();
            file.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return map;
    }

    public static void LoadMap() {
        BombermanGame.bombmap = new char[BombermanGame.HEIGHT][BombermanGame.WIDTH];
        for (int i = 0; i < BombermanGame.HEIGHT; i++) {
            for (int j = 0; j < BombermanGame.WIDTH; j++) {
                char a = BombermanGame.map[i][j];
                BombermanGame.bombmap[i][j] = ' ';
                Entity object = null;
                switch (a) {
                    case '#': // WALL - STILL OBJECT
                        object = new Wall(j, i, Sprite.wall.getFxImage());
                        BombermanGame.stillObjects.add(object);
                        break;

                    case '%': // WALL - STILL OBJECT
                        object = new Wall(j, i, Sprite.wall.getFxImage());
                        BombermanGame.stillObjects.add(object);
                        break;

                    case '*': // BRICK - ACTIVE OBJECT
                        BombermanGame.stillObjects.add(new Grass(j, i, Sprite.grass.getFxImage()));
                        object = new Brick(j, i, Sprite.brick.getFxImage());
                        BombermanGame.activeEntities.add((ActiveEntity) object);
                        break;

                    case 'x': // PORTAL - ACTIVE OBJECT
                        // tạo layer 0 - grass
                        BombermanGame.stillObjects.add(new Grass(j, i, Sprite.grass.getFxImage()));

                        // tạo layer 1 - Portal
                        object = new Portal(j, i, Sprite.portal.getFxImage());
                        BombermanGame.activeEntities.add((ActiveEntity) object);

                        // tao layer 2 - brick
                        BombermanGame.activeEntities.add(new Brick(j, i, Sprite.brick.getFxImage()));
                        BombermanGame.map[i][j] = '*';
                        break;

                    case '1': // BALLOOM - MOVABLE ENTITY
                        BombermanGame.activeEntities.add(new Balloom(j, i, Sprite.balloom_left1.getFxImage()));
                        BombermanGame.stillObjects.add(new Grass(j, i, Sprite.grass.getFxImage()));
                        BombermanGame.map[i][j] = ' ';
                        BombermanGame.countenemy++;
                        break;

                    case '2': // ONEAL - MOVABLE ENTITY
                        BombermanGame.activeEntities.add(new Oneal(j, i, Sprite.oneal_right1.getFxImage()));
                        BombermanGame.stillObjects.add(new Grass(j, i, Sprite.grass.getFxImage()));
                        BombermanGame.map[i][j] = ' ';
                        BombermanGame.countenemy++;
                        break;

                    case '3': // MINVO - MOVABLE ENTITY
                        BombermanGame.activeEntities.add(new Minvo(j, i, Sprite.minvo_right1.getFxImage()));
                        BombermanGame.stillObjects.add(new Grass(j, i, Sprite.grass.getFxImage()));
                        BombermanGame.map[i][j] = ' ';
                        BombermanGame.countenemy++;
                        break;

                    case '4': // KONDORIA - MOVABLE ENTITY
                        BombermanGame.activeEntities.add(new Kondoria(j, i, Sprite.kondoria_right1.getFxImage()));
                        BombermanGame.stillObjects.add(new Grass(j, i, Sprite.grass.getFxImage()));
                        BombermanGame.map[i][j] = ' ';
                        BombermanGame.countenemy++;
                        break;

                    case '5': // KONDORIA - MOVABLE ENTITY
                        BombermanGame.activeEntities.add(new Doll(j, i, Sprite.doll_right1.getFxImage()));
                        BombermanGame.stillObjects.add(new Grass(j, i, Sprite.grass.getFxImage()));
                        BombermanGame.map[i][j] = ' ';
                        BombermanGame.countenemy++;
                        break;

                    case 'b': // MORE BOMBS
                        // tạo layer 0 - grass
                        BombermanGame.stillObjects.add(new Grass(j, i, Sprite.grass.getFxImage()));

                        // tạo layer 1 - PowerUP
                        object = new PowerUpMoreBombs(j, i, Sprite.powerup_bombs.getFxImage());
                        BombermanGame.activeEntities.add((ActiveEntity) object);

                        // tao layer 2 - Brick
                        BombermanGame.activeEntities.add(new Brick(j, i, Sprite.brick.getFxImage()));
                        BombermanGame.map[i][j] = '*';
                        break;

                    case 'f': // MORE FLAMES
                        // tạo layer 0 - grass
                        BombermanGame.stillObjects.add(new Grass(j, i, Sprite.grass.getFxImage()));

                        // tạo layer 1 - PowerUP
                        object = new PowerUpFlames(j, i, Sprite.powerup_flames.getFxImage());
                        BombermanGame.activeEntities.add((ActiveEntity) object);

                        // tao layer 2 - Brick
                        BombermanGame.activeEntities.add(new Brick(j, i, Sprite.brick.getFxImage()));
                        BombermanGame.map[i][j] = '*';
                        break;

                    case 's': // SPEED
                        // tạo layer 0 - grass
                        BombermanGame.stillObjects.add(new Grass(j, i, Sprite.grass.getFxImage()));

                        // tạo layer 1 - PowerUP
                        object = new PowerUpSpeed(j, i, Sprite.powerup_speed.getFxImage());
                        BombermanGame.activeEntities.add((ActiveEntity) object);

                        // tao layer 2 - Brick
                        BombermanGame.activeEntities.add(new Brick(j, i, Sprite.brick.getFxImage()));
                        BombermanGame.map[i][j] = '*';
                        break;

                    case 'w': // WALL PASS
                        // tạo layer 0 - grass
                        BombermanGame.stillObjects.add(new Grass(j, i, Sprite.grass.getFxImage()));

                        // tạo layer 1 - PowerUP
                        object = new PowerUpWallpass(j, i, Sprite.powerup_wallpass.getFxImage());
                        BombermanGame.activeEntities.add((ActiveEntity) object);

                        // tao layer 2 - Brick
                        BombermanGame.activeEntities.add(new Brick(j, i, Sprite.brick.getFxImage()));
                        BombermanGame.map[i][j] = '*';
                        break;

                    default: // GRASS
                        BombermanGame.stillObjects.add(new Grass(j, i, Sprite.grass.getFxImage()));
                        BombermanGame.map[i][j] = ' ';
                        break;
                }

            }
        }
    }
}
