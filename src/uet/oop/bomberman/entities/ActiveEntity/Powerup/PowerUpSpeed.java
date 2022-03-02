package uet.oop.bomberman.entities.ActiveEntity.Powerup;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;

public class PowerUpSpeed extends Powerup {

    public int value = 1; // sau khi cho bomber speed thì sẽ xóa

    public PowerUpSpeed(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }
}
