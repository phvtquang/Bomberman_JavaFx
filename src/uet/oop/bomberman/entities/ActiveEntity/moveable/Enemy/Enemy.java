package uet.oop.bomberman.entities.ActiveEntity.moveable.Enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.PD.MobEasy;
import uet.oop.bomberman.entities.ActiveEntity.ActiveEntity;
import uet.oop.bomberman.entities.ActiveEntity.moveable.Bomber;
import uet.oop.bomberman.entities.ActiveEntity.moveable.MovableEntity;

public class Enemy extends MovableEntity {

    protected int animationTime = 90;
    protected int direction;

    public Enemy(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void collide(ActiveEntity entity) {
        if (this.isDead) {
            return;
        }
        if (entity instanceof Bomber && !((Bomber) entity).isDead) {
            if (this.getSmallX() == entity.getSmallX() && this.getSmallY() == entity.getSmallY()) {
                entity.isDead = true;
                BombermanGame.countBomber--;
            }
        }
    }

    @Override
    public void moveUP() {

    }

    @Override
    public void moveDOWN() {

    }

    @Override
    public void moveLEFT() {

    }

    @Override
    public void moveRIGHT() {

    }
}
