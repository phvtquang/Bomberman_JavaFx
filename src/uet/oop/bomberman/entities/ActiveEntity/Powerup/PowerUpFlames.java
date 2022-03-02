package uet.oop.bomberman.entities.ActiveEntity.Powerup;

import javafx.scene.image.Image;

public class PowerUpFlames extends Powerup {

    public int value = 1; // cộng 1 power cho bomber

    public PowerUpFlames(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

}
